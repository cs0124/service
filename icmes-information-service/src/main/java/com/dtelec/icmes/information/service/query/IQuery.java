package com.dtelec.icmes.information.service.query;

import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;

import org.jdeferred2.Deferred;
import org.jdeferred2.Promise;
import org.jdeferred2.impl.DeferredObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dtelec.icmes.common.utility.ReflectionUtils;
import com.dtelec.icmes.information.config.SystemSettingConfig;


public interface IQuery<R> {
	
	final static Logger logger = LoggerFactory.getLogger(IQuery.class);

	@SuppressWarnings("unchecked")
	default public Promise<R, Throwable, Object> query() {
		Deferred<R, Throwable, Object> deferred = new DeferredObject<>();
		
		Type argType = ReflectionUtils.fetchTypeArgumentsOfGenericClassByInstance(this)[0];
        CompletableFuture<R> future = SystemSettingConfig.getQueryGateway().query(this, (Class<R>)argType);
        future.handle((result, exception) -> {
        	if (result != null) {
        		deferred.resolve(result);
        	}
        	else {
        		logger.error("error while execute query(", IQuery.this.getClass().getName(), ")" , exception);
        		deferred.reject(exception);
        	}
        	
        	return null;
        });

        return deferred.promise();
    }
	
	
	@SuppressWarnings("unchecked")
	default public R queryAndWait() throws Exception {
		Type argType = ReflectionUtils.fetchTypeArgumentsOfGenericClassByInstance(this)[0];
        CompletableFuture<R> future = SystemSettingConfig.getQueryGateway().query(this, (Class<R>)argType);
        
        return future.get();
	}
	
}
