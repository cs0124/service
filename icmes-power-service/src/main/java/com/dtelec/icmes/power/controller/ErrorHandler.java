package com.dtelec.icmes.power.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.alibaba.fastjson.JSON;
import com.dtelec.icmes.power.controller.vo.GenericResponseErrorVO;

/**
 * 错误处理
 * @author hlxu
 *
 */
@ControllerAdvice
public class ErrorHandler {

	/**
	 * 系统错误统一捕获处理
	 * 并统一成标准的Json格式给前端使用
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Throwable.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<String> parseErrorMessage(Throwable ex) {
		GenericResponseErrorVO error = new GenericResponseErrorVO(ex);
		ResponseEntity<String> res = new ResponseEntity<>(JSON.toJSONString(error), HttpStatus.INTERNAL_SERVER_ERROR);
        return res;
	}
	
	
}
