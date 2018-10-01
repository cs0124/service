package com.dtelec.icmes.information.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.alibaba.fastjson.JSON;
import com.dtelec.icmes.information.controller.vo.GenericResponseErrorVO;


@ControllerAdvice
public class ErrorHandler {

	
	@ExceptionHandler(Throwable.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<String> parseErrorMessage(Throwable ex) {
		GenericResponseErrorVO error = new GenericResponseErrorVO(ex);
		ResponseEntity<String> res = new ResponseEntity<>(JSON.toJSONString(error), HttpStatus.INTERNAL_SERVER_ERROR);
        return res;
	}
	
	
}
