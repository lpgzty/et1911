package com.etoak;

import com.etoak.service.User;
import com.etoak.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by LPG on 2020-06-01.
 */
public class SpringClient {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-cxf.xml");
        UserService userService = (UserService) ioc.getBean("userService");
        User user = userService.getById(100);
        System.out.println(user.getName() + "\t" +user.getAge());


    }
}
