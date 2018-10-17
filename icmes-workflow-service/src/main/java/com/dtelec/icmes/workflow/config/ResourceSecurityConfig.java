package com.dtelec.icmes.workflow.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.dtelec.icmes.workflow.config.security.AdvanceUserInfoTokenServices;

/**
 * 用于资源客户端安全访问的配置
 * 
 * @author hlxu
 *
 */

@Configuration
@EnableResourceServer
public class ResourceSecurityConfig extends ResourceServerConfigurerAdapter {

    private final ResourceServerProperties sso;

    @Autowired
    public ResourceSecurityConfig(ResourceServerProperties sso) {
        this.sso = sso;
    }
    
    /**
     * 注入当前 token 存储对象
     * @return token 存储对象
     */
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    /**
     * 注入当前Token的产生转换器
     * @return JwtAccessTokenConverter 当前Token 的产生转换器 
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("701f7ec3-9123-4965-b317-46a0d88832c0");
        return converter;
    }

    /**
     * 注入服务之间验证的资源对象的配置
     * @return ClientCredentialsResourceDetails 服务之间的验证资源对象
     */
    @Bean
    @ConfigurationProperties(prefix = "security.oauth2.client")
    public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
        return new ClientCredentialsResourceDetails();
    }

    /**
     * 注入 Feign 的拦截器截获对象，用户扩展更多内容到当前登录用户的Principal对象 
     * @return RequestInterceptor Feign的拦截器截获对象
     */
    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor(){
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails());
    }

    /**
     * 注入 RestTemplate 的 OAuth2RestTemplate 类型对象
     * @return OAuth2RestTemplate 带有验证的RestTemplate 对象
     */
    @Bean
    public OAuth2RestTemplate clientCredentialsRestTemplate() {
        return new OAuth2RestTemplate(clientCredentialsResourceDetails());
    }

    @Bean
    @Primary
    public ResourceServerTokenServices tokenServices() {
        return new AdvanceUserInfoTokenServices(sso.getUserInfoUri(), sso.getClientId(), tokenStore());
    }

    /**
     * 用于资源客户端的安全验证的匹配，此处用于过滤一些不需要验证的URL。
     * @param http 当前的 HttpSecurity 对象
     * 
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/v2/api-docs").permitAll()
                .anyRequest().authenticated();
    }
    
    @Override
    public void configure(ResourceServerSecurityConfigurer config) {
        config.tokenServices(tokenServices());
    }
}
