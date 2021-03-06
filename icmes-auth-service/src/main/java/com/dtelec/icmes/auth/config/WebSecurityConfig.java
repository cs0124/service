package com.dtelec.icmes.auth.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.dtelec.icmes.auth.service.IUserService;

/**
 * @author hlxu
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private IUserService userDetailsService;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off    	
        http
               .authorizeRequests().anyRequest().authenticated()
               .and()
               .csrf().disable();
        // @formatter:on
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {    	
    	auth.userDetailsService(userDetailsService)
    	        .passwordEncoder(NoOpPasswordEncoder.getInstance());
                // .passwordEncoder(new BCryptPasswordEncoder()); // 暂时注销掉密码加密，等前后端联调成功后再次打开
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
    
	/*
	 * // 暂时注销掉密码加密，等前后端联调成功后再次打开
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    */
}