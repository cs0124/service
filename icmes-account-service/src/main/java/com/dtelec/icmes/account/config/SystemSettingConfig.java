package com.dtelec.icmes.account.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用于读取ICMES 配置文件信息
 * 
 * @author hlxu
 *
 */

@Configuration
@ConfigurationProperties(prefix="icmes", ignoreUnknownFields = false)
public class SystemSettingConfig {
	/**
	 * 版本号
	 */
    private String version;
    /**
     * 系统运行模式，是否是debug 模式
     */
    private boolean debugWorkMode;
    /**
     * 系统当前的初始密码
     */
    private String initPassword;
    /**
     * 配置错误密码几次锁的阈值
     */
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
