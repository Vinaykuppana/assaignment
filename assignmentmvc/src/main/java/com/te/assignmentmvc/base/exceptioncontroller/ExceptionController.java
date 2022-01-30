package com.te.assignmentmvc.base.exceptioncontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.assignmentmvc.base.exception.ProductException;

@ControllerAdvice
public class ExceptionController  {
		
	@ExceptionHandler(ProductException.class)
	public String handleException(HttpServletRequest request ,ProductException exception) {
		request.setAttribute("err", exception.getMessage());
		return "loginform";
	}

}
