package com.etoak.exception;

import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.etoak.controller.CarController;

import lombok.extern.slf4j.Slf4j;



@ControllerAdvice  
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ParameException.class)
	public ModelAndView handlerParameException(ParameException e) {
		
		
		
		String message = e.getMessage();
		log.error(message,e);
		ModelAndView mView = new ModelAndView();
		mView.addObject("paramError",message);
		mView.setViewName("car/add");
		
		return mView;
	}
}
