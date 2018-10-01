package com.dtelec.icmes.information.service.core;

import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.monitoring.MessageMonitor;
import org.axonframework.queryhandling.QueryInvocationErrorHandler;
import org.axonframework.queryhandling.QueryMessage;
import org.axonframework.queryhandling.SimpleQueryBus;

public class ICMESQueryBus extends SimpleQueryBus {
    
	public ICMESQueryBus(MessageMonitor<? super QueryMessage<?, ?>> messageMonitor,
            TransactionManager transactionManager,
            QueryInvocationErrorHandler errorHandler) {
		
		super(messageMonitor, transactionManager, errorHandler);
	}
	
}
