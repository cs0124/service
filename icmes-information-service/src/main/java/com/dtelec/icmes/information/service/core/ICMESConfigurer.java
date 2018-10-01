package com.dtelec.icmes.information.service.core;

import java.util.concurrent.Executors;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.common.transaction.NoTransactionManager;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.config.Configuration;
import org.axonframework.config.Configurer;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.messaging.interceptors.CorrelationDataInterceptor;
import org.axonframework.queryhandling.QueryBus;
import org.axonframework.queryhandling.QueryInvocationErrorHandler;

import com.dtelec.icmes.information.config.SystemSettingConfig;


public class ICMESConfigurer extends DefaultConfigurer {
	
	final static SystemSettingConfig systemSetting = SystemSettingConfig.getAllConfig();
	
	@Override
	protected CommandBus defaultCommandBus(Configuration config) {
		ICMESCommandBus cb =
                new ICMESCommandBus(Executors.newFixedThreadPool(systemSetting.getCommandWorkerCount()),
                		config.getComponent(TransactionManager.class, () -> NoTransactionManager.INSTANCE),
                                     config.messageMonitor(ICMESCommandBus.class, "commandBus"));
		
        cb.registerHandlerInterceptor(new CorrelationDataInterceptor<>(config.correlationDataProviders()));
        return cb;
    }
	
	@Override
	protected QueryBus defaultQueryBus(Configuration config) {
        return new ICMESQueryBus(config.messageMonitor(ICMESQueryBus.class, "queryBus"),
                                  config.getComponent(TransactionManager.class, NoTransactionManager::instance),
                                  config.getComponent(QueryInvocationErrorHandler.class));
    }
	
	public static Configurer defaultConfiguration() {
        return new ICMESConfigurer();
    }
	
}
