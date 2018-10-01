package com.dtelec.icmes.information.config;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSON;
import com.dtelec.icmes.information.controller.context.UserInfo;
import com.dtelec.icmes.information.controller.context.UserInfoContext;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class ContextTransmitterAutoConfig {

    @Bean
    public TransmitUserInfoFeighClientIntercepter transmitUserInfo2FeighHttpHeader(){
       return new TransmitUserInfoFeighClientIntercepter();
    }

    @Bean
    public TransmitUserInfoFilter transmitUserInfoFromHttpHeader(){
        return new TransmitUserInfoFilter();
    }
}


class TransmitUserInfoFeighClientIntercepter implements RequestInterceptor {
	
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //从应用上下文中取出user信息，放入Feign的请求头中
        UserInfo user = UserInfoContext.getUserInfo();
        if (user != null) {
            try {
                String userJson = JSON.toJSONString(user);
                requestTemplate.header(UserInfoContext.KEY_USERINFO_HTTP_HEADER, new String[]{URLDecoder.decode(userJson,"UTF-8")});
            } 
            catch (UnsupportedEncodingException e) {
            	e.printStackTrace();
            }
        }
    }
}

class TransmitUserInfoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      // do nothing
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       this.initUserInfo((HttpServletRequest)request);
       chain.doFilter(request,response);
    }

    private void initUserInfo(HttpServletRequest request) {
        String userJson = request.getHeader(UserInfoContext.KEY_USERINFO_HTTP_HEADER);
        if (StringUtils.isNotBlank(userJson)) {
            try {
                userJson = URLDecoder.decode(userJson, "UTF-8");
                UserInfo userInfo = JSON.parseObject(userJson, UserInfo.class);
                //将UserInfo放入上下文中
                UserInfoContext.setUserInfo(userInfo);
            }
            catch (UnsupportedEncodingException e) {
               e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {
    	// do nothing
    }
}