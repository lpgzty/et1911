package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * 用于测试简单的参数传递
 * 使用HTTPServletRequest接受参数
 * 使用基本数据类型,String
 * @author LPG
 *
 */

@Controller
@RequestMapping("/simple")
public class SimpleController {
	
	/*
	 * 第一种接受参数的方式:使用HTTPServletRequest
	 */
	@RequestMapping("/servlet")
	public String servlet(HttpServletRequest request) throws Exception {
		//接受前端传入的参数
		String name = request.getParameter("name");
		// name==null && "".equals(name)
		if(StringUtils.isEmpty(name)) {
			name = " World ";
		}
		
		request.setAttribute("result","Hello "+ name);
		
		return "param";
	}
	
	
	/*
	 *第二种接受参数的方式:使用ModelAndView 
	 *@RequestParam可以对参数进行限制
	 *属性required :默认是true,表示参数必须传入
	 *defaultValue :当参数不传时,给他一个默认值
	 *
	 */
	@RequestMapping(value = "/simple",method= {RequestMethod.GET})
	public ModelAndView simple(
			@RequestParam(required = false,defaultValue = "1") int id,
			String name
			) {
		System.out.println("id param -"+id);
		System.out.println("name param -" + name);
		ModelAndView mView = new ModelAndView();
		mView.addObject("result","ModelAndView传值");
		mView.setViewName("param");
		return mView;
	}
	
	
	
	
	
	
	
	
	
	
	
}
