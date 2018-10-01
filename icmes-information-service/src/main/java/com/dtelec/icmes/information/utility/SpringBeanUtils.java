package com.dtelec.icmes.information.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanUtils implements ApplicationContextAware {  
    protected final static Log logger = LogFactory.getLog(SpringBeanUtils.class);  
  
    private static ApplicationContext ctx = null; 
  
    public void setApplicationContext(ApplicationContext ctx)  
            throws BeansException {  
    	SpringBeanUtils.ctx = ctx;  
    }  
  
    public static ApplicationContext getApplicationContext() {  
        return ctx;  
    }  
  
    @SuppressWarnings("unchecked")
	public  static <T> T getBean(String prop) {  
        Object obj = ctx.getBean(prop);  
        if (logger.isDebugEnabled()) {  
            logger.debug("property=[" + prop + "],object=[" + obj + "]");  
        }  
        return (T)obj;  
    }  
  
    
}  