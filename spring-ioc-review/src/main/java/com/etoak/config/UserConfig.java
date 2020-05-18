package com.etoak.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.etoak.action.UserAction;
import com.etoak.service.UserService;


/**
 * @Configuration相当于xml的根元素 <beans> 标签
   *  表示这是一个spring IOC容器
 * @author LPG
 *
 */
@Configuration 
public class UserConfig {
	
	//使用@Bean注册spring bean,返回类型相当于bean标签的class属性,方法名可以人为是bean标签的id属性
	@Bean("userService")
	public UserService userService() {
		return new UserService();
	}
	
	@Bean
	public UserAction userAction(@Qualifier("userService") UserService userService) {
		UserAction userAction = new UserAction();
		//userAction.setUserService(this.userService());
		
		//配合@Qualifier使用
		userAction.setUserService(userService);
		
		return userAction;
	}
}
