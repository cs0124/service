package com.dtelec.icmes.information.controller.vo;

import java.lang.reflect.InvocationTargetException;

import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.queryhandling.QueryExecutionException;

import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesException;
import com.dtelec.icmes.common.utility.ReflectionUtils;
import com.dtelec.icmes.information.config.SystemSettingConfig;

public class GenericResponseErrorVO {
    public int errorCode;
    public String errorDescription;
    public int errorType;     // 0 - server unexpected error   1 - business error    
    
    public GenericResponseErrorVO() {
    	// do nothing
    }
    
    public GenericResponseErrorVO(Throwable error) {
    	if (error != null) {
    		int errCode = 500;
    		int errType = 0;  // 0 - system ,  1 - business
    		String errMess = null;
    		
    		InvocationTargetException invocationError = ReflectionUtils.asClassInstance(error, InvocationTargetException.class);
    		if (invocationError != null) {
    			Throwable targetError = invocationError.getTargetException();
    			if (targetError != null) {error = targetError;}
    		}
    		
    		CommandExecutionException commandError = ReflectionUtils.asClassInstance(error, CommandExecutionException.class);
    		if (commandError == null) {
        		QueryExecutionException queryError = ReflectionUtils.asClassInstance(error, QueryExecutionException.class);
        		Throwable targetError = null;
        		if (queryError != null) {targetError = queryError.getCause();}
    			if (targetError != null) {error = targetError;}
    		}
    		else {
    			Throwable targetError = commandError.getCause();
    			if (targetError != null) {error = targetError;}
    		}
    		
    		IcmesException oceanusError = ReflectionUtils.asClassInstance(error, IcmesBusinessException.class);
    		if (oceanusError == null) {
    			oceanusError = ReflectionUtils.asClassInstance(error, IcmesException.class);
    		}
    		
    		if (oceanusError != null) {
    			errCode = oceanusError.getErrorCode();
    			errType = oceanusError.getErrorType();
    		}
    		
    		Throwable superError = error.getCause();
    		
    		if (superError != null) {
    			errMess = superError.getMessage();
    		}
    		
    		if (errMess == null) {
    			errMess = error.getMessage();
    		}
    		
    		if (errMess == null) {
    			errMess = error.getClass().getName();
    		}
    		
    		boolean isDebugWorkMode = SystemSettingConfig.getAllConfig().getDebugWorkMode();
    		if (isDebugWorkMode == false) {
    			errMess = "System error, Please contact the administrator.";
    		}
    		
    		this.errorCode = errCode;
    		this.errorDescription = errMess;
    		this.errorType = errType;
    	}
    }
}
