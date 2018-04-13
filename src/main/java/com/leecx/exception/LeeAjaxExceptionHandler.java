package com.leecx.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.leecx.pojo.LeeJSONResult;

//@RestControllerAdvice
public class LeeAjaxExceptionHandler {
	
	public static final String DEFAULT_ERROR_VIEW = "error";
	
//	@ExceptionHandler(value = Exception.class)
	public LeeJSONResult defaultErrorHandler(HttpServletRequest request,Exception e) throws Exception {
		e.printStackTrace();
		return LeeJSONResult.errorException(e.getMessage());
	}

	
}
