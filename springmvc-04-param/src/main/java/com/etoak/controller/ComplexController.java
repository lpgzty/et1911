package com.etoak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etoak.bean.Student;

/*
 * 测试javabean接受参数
 * 测试数组接受参数
 * 测试List接受参数
 * 测试Map接受参数
 */

@Controller
@RequestMapping("/complex")
public class ComplexController {
	//get请求:@RequestMapping的method属性指定
	//get请求:@GetMapping
	@GetMapping("/bean")
	public String bean (Student student,Model m)  {
		
		System.out.println(student);
		
		m.addAttribute("result2","使用Model传值");
		
		//传值
		return "forward:/simple/simple?id=321";
	}
	
	
}













