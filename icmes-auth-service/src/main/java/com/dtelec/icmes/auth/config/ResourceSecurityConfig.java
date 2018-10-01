package com.dtelec.icmes.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@Configuration
@EnableResourceServer
public class ResourceSecurityConfig extends ResourceServerConfigurerAdapter {
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
		// @formatter:off    	
        http
               .authorizeRequests()
               .antMatchers("/v2/api-docs").permitAll()
               .anyRequest().authenticated()
               .and()
               .csrf().disable();
        // @formatter:on
    }
	
}
