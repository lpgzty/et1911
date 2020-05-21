package com.etoak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car")
public class CarController {
	
	//跳转到添加车辆页面
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "car/add";
	}
}
