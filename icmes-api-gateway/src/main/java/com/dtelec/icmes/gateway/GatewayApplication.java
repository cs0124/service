package com.dtelec.icmes.gateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.spring4all.swagger.EnableSwagger2Doc;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * API 网关的微服务入口
 * @author hlxu
 *
 */
@EnableSwagger2Doc
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	/**
	 * 注入 CORS 跨域 过滤器
	 * @return 返回要应用的过滤器
	 */
	@Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
	
	/**
	 * 提供Swagger的资源提供器
	 * @author hlxu
	 *
	 */
	@Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider {
		
		@Override
        public List<SwaggerResource> get() {
        	List<SwaggerResource> resources = new ArrayList<>();
            //resources.add(swaggerResource("ICMES-授权子系统", "/uaa/v2/api-docs", "2.0"));
            resources.add(swaggerResource("ICMES-账户子系统", "/account/v2/api-docs", "2.0"));
            resources.add(swaggerResource("ICMES-信息子系统", "/info/v2/api-docs", "2.0"));
            resources.add(swaggerResource("ICMES-停电子系统", "/power/v2/api-docs", "2.0"));
            resources.add(swaggerResource("ICMES-工作流子系统", "/flow/v2/api-docs", "2.0"));

            return resources;
        }

		/**
		 * 
		 * @param name  微服务子系统的名称
		 * @param location 获取子系统的Swagger 的子系统接口
		 * @param version 当前使用版本
		 * @return  返回对应的Swagger 资源
		 */
        private SwaggerResource swaggerResource(String name, String location, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }
}
