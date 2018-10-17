package com.dtelec.icmes.workflow.config;

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

	public static SystemSettingConfig getAllConfig() {
		return staticConfig;
	}
	
	@Bean
    public int initStatic() {
		staticConfig = this;
        return 0;
    }

	
}
