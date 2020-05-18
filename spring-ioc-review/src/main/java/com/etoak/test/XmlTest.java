package com.etoak.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etoak.action.UserAction;
import com.etoak.bean.User;
import com.etoak.service.UserService;

public class XmlTest {

	public static void main(String[] args) {
		ApplicationContext aic = new ClassPathXmlApplicationContext("spring.xml");
		
		UserAction userAction = aic.getBean("userAction",UserAction.class);//alt+shift+L
		
		System.out.println(userAction);
		User user = userAction.getById(1000);
		System.out.println(user);
		
		
	}

}
