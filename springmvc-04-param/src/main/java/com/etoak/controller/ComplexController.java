package com.etoak.controller;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.Student;
import com.sun.org.apache.regexp.internal.recompile;

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
	
	//array
	@PostMapping("/array")
	public String array(String[] hobby,ModelMap modelMap) {
		for(String hobbyString : hobby) {
			System.out.println("hobby - " + hobbyString);
		}
		modelMap.addAttribute("result", "使用modelMap传参");
		return "param";
	}
	
	//测试list传参
	@PostMapping("/list")
	public String list(Student student,Map<String, Object> map) {
		
		List<String> hobbList = student.getHobbyList();
		if(!CollectionUtils.isEmpty(hobbList)) {
			hobbList.forEach(x -> System.out.println(x));
		}
		
		map.put("result","map传值");
		return "param";
	}
	
	//测试map传参
	//@PostMapping(value="/map",produces = {"text/plain"})
	@PostMapping("/map")
	@ResponseBody  //可以返回json,xml,纯文本
	public String map(Student student) {
		System.out.println(student.getStuMap());
		return "success";
	}
	
}













