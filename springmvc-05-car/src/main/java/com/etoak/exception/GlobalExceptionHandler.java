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
	
	
	@ExceptionHandler(Et1911LoginException.class)
	public ModelAndView handLoginException(Et1911LoginException e) {
		String msg = e.getMessage() ;
		log.error(msg,e);
		ModelAndView mv = new ModelAndView();
		mv.addObject("error",msg);
		mv.setViewName("login");
		return mv;
	}
	
	
	
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
