package com.dtelec.icmes.account.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix="icmes", ignoreUnknownFields = false)
public class SystemSettingConfig {
    private String version;
    private boolean debugWorkMode;
    private String initPassword;
    private int loginRetryCount;
    
    private static SystemSettingConfig staticConfig;
    
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public boolean getDebugWorkMode() {
		return debugWorkMode;
	}

	public void setDebugWorkMode(boolean debugWorkMode) {
		this.debugWorkMode = debugWorkMode;
	}

	public String getInitPassword() {
		return initPassword;
	}

	public void setInitPassword(String initPassword) {
		this.initPassword = initPassword;
	}
	
	public int getLoginRetryCount() {
		return loginRetryCount;
	}

	public void setLoginRetryCount(int loginRetryCount) {
		this.loginRetryCount = loginRetryCount;
	}

	public static SystemSettingConfig getAllConfig() {
		return staticConfig;
	}
	
	@Bean
    public int initStatic() {
		staticConfig = this;
        return 0;
    }

	
}
