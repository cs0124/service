package com.dtelec.icmes.information.service.command;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.CommandMessage;
import org.jdeferred2.Deferred;
import org.jdeferred2.Promise;
import org.jdeferred2.impl.DeferredObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dtelec.icmes.information.config.SystemSettingConfig;
import com.dtelec.icmes.information.service.core.ICommandRegistrar;

public interface ICommand<R> {
	
	final static Logger logger = LoggerFactory.getLogger(ICommand.class);
    
	final static SystemSettingConfig systemSetting = SystemSettingConfig.getAllConfig();	
	final static CommandMonitor monitor = new CommandMonitor();
	final static int defaultCommandTimeoutSeconds = systemSetting.getCommandTimeout();
	
	default public Promise<R, Throwable, Object> send() {
        Deferred<R, Throwable, Object> deferred = new DeferredObject<>();
        SystemSettingConfig.getCommandGateway().send(this, new CommandCallback<ICommand<R>, R>() {

            @Override
            public void onSuccess(CommandMessage<? extends ICommand<R>> commandMessage, R result) {
            	try {
                    monitor.publish(ICommand.this, result);	
            	}
            	catch(Exception ex) {
            		logger.error("error while monitor publish command(", commandMessage.getCommandName(), ")" , ex);
            	}
                deferred.resolve(result);
            }

            @Override
            public void onFailure(CommandMessage<? extends ICommand<R>> commandMessage, Throwable cause) {
            	logger.error("error while execute command(", commandMessage.getCommandName(), ")" , cause);
                deferred.reject(cause);
            }
        });

        return deferred.promise();
    }
	
	default public R sendAndWait(long timeout, TimeUnit unit) {
		R result = SystemSettingConfig.getCommandGateway().sendAndWait(this, timeout, unit);
		monitor.publish(this, result);
		return result;
	}
	
	default public R sendAndWait() {
		return this.sendAndWait(defaultCommandTimeoutSeconds, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" }) 
	public static <R> ICommandRegistrar subscribe(Class<? extends ICommand> commandCls, Class<R> resultCls, Consumer<R> func) {
		
		return monitor.subscribe(commandCls, (command, result) -> {
			func.accept((R)result);
		});
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" }) 
	public static <R> ICommandRegistrar subscribe(Class<? extends ICommand> commandCls, Consumer<R> func) {
		
		return monitor.subscribe(commandCls, (command, result) -> {
			func.accept((R)result);
		});
	}
	
	@SuppressWarnings("rawtypes") 
	public static <C extends ICommand, R> ICommandRegistrar subscribe(Class<C> commandCls, Class<R> resultCls, BiConsumer<C, R> func) {
		
		return monitor.subscribe(commandCls, func);
	}
	
	@SuppressWarnings("rawtypes") 
	public static <C extends ICommand, R> ICommandRegistrar subscribe(Class<C> commandCls, BiConsumer<C, R> func) {
		
		return monitor.subscribe(commandCls, func);
	}
	
	
	class CommandMonitor {
		@SuppressWarnings("rawtypes")
		private final ConcurrentMap<Class<? extends ICommand>, List<BiConsumer>> subscriptions =
	            new ConcurrentHashMap<>();
		
        @SuppressWarnings("rawtypes")
		public <C extends ICommand, R> ICommandRegistrar subscribe(Class<C> commandCls, BiConsumer<C, R> func) {

            final List<BiConsumer> handlers;
			List<BiConsumer> tmpHandlers = subscriptions.get(commandCls);
            if (tmpHandlers == null) {
                handlers = new Vector<>();
                subscriptions.putIfAbsent(commandCls, handlers);
            }
            else {
                handlers = tmpHandlers;
            }
            
            handlers.add(func);
	        
            return () -> {
            	boolean result = handlers.remove(func);
            	if (handlers.isEmpty()) {
                    subscriptions.remove(commandCls, handlers);
            	}    
            	return result;
	        };
	    }
		
        @SuppressWarnings({ "rawtypes", "unchecked" }) 
		public <C extends ICommand, R> void publish(C commandIns, R result) {
        	Class<? extends ICommand> commandCls = commandIns.getClass();
			List<BiConsumer> handlers = subscriptions.get(commandCls);
            if (handlers != null) {
                handlers.forEach(handler -> {
                	try {
                        handler.accept(commandIns, result);	
                	}
                	catch(Exception ex) {
                		logger.error("error while execute publish handler" , ex);
                	}
                });
            }
		}
	}
	
	
	
}
