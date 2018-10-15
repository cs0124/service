package com.dtelec.icmes.common.utility;

import com.alibaba.fastjson.JSON;
import com.dtelec.icmes.common.model.AuthUserModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * JwtUtils Token 分析工具
 * @author HLXu
 * @version 1.0
 */
public class JwtUtils {
	
	/**
	 * 用于JWT token 分析 附属内容
	 * @param token 被分析的token
	 * @param secret 签名Key
	 * @param type 串行类型
	 * @return 返回附属内容对象
	 */
	public static <T> T parseJwtPayloadInformation(String token, String secret, Class<T> type) {
		T model = null;
		
        try {
        	Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        	String subject = claims.getSubject();
        	model = JSON.parseObject(subject, type);
        } 
        catch (Exception e) {
        	model = null;
        }
        
		return model;
	}
	

	/**
	 * 用于方便分析登录的token
	 * @param token token 
	 * @return 返回登录中内部的附属对象
	 */
	public static AuthUserModel parseAuthJwtPayloadInformation(String token) {
		AuthUserModel model = parseJwtPayloadInformation(token, "701f7ec3-9123-4965-b317-46a0d88832c0", AuthUserModel.class);
		
		return model;
	}
	
}
