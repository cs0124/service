package com.dtelec.icmes.information.config;

import java.util.Map;
import java.util.Map.Entry;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.config.Configurer;
import org.axonframework.queryhandling.QueryBus;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dtelec.icmes.information.service.core.ICMESConfigurer;
import com.dtelec.icmes.information.service.core.ICommandHandler;
import com.dtelec.icmes.information.service.core.IQueryHandler;
import com.dtelec.icmes.information.utility.SpringBeanUtils;


@Configuration
@ConfigurationProperties(prefix="icmes", ignoreUnknownFields = false)
public class SystemSettingConfig {
    private String version;
    private int commandTimeout;
    private int commandWorkerCount;
    private boolean debugWorkMode;
    
    private static SystemSettingConfig staticConfig;
	private static org.axonframework.config.Configuration axonStaticConfig;
    
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public int getCommandTimeout() {
		return commandTimeout;
	}
	
	public void setCommandTimeout(int commandTimeout) {
		this.commandTimeout = commandTimeout;
	}
	
	public int getCommandWorkerCount() {
		return commandWorkerCount;
	}
	
	public void setCommandWorkerCount(int commandWorkerCount) {
		this.commandWorkerCount = commandWorkerCount;
	}
	
	public boolean getDebugWorkMode() {
		return debugWorkMode;
	}

	public void setDebugWorkMode(boolean debugWorkMode) {
		this.debugWorkMode = debugWorkMode;
	}

	public static SystemSettingConfig getAllConfig() {
		return staticConfig;
	}
	
	public static CommandGateway getCommandGateway() {
		return axonStaticConfig.commandGateway();
	}
	
	public static QueryGateway getQueryGateway() {
		return axonStaticConfig.queryGateway();
	}
	
	public static CommandBus getCommandBus() {
		return axonStaticConfig.commandBus();
	}
	
	public static QueryBus getQueryBus() {
		return axonStaticConfig.queryBus();
	}
	
	@Bean
    public int initStatic() {
		staticConfig = this;
		
		// Axon 
	    Configurer configurer = ICMESConfigurer.defaultConfiguration();
	
	    Map<String, ICommandHandler> commandMapper = SpringBeanUtils.getApplicationContext().getBeansOfType(ICommandHandler.class);
	    for (Entry<String, ICommandHandler> entry : commandMapper.entrySet()) {
	    	ICommandHandler commandHandler = entry.getValue();
	    	configurer.registerCommandHandler(c -> commandHandler);
	    }
	    
	    Map<String, IQueryHandler> queryMapper = SpringBeanUtils.getApplicationContext().getBeansOfType(IQueryHandler.class);
	    for (Entry<String, IQueryHandler> entry : queryMapper.entrySet()) {
	    	IQueryHandler queryHandler = entry.getValue();
	    	configurer.registerQueryHandler(c -> queryHandler);
	    }
	    
	    axonStaticConfig = configurer.start();
        
        return 0;
    }

	
}
