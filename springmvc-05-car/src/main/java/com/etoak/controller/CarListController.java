package com.etoak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.Car;
import com.etoak.service.CarListService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("list")
@Slf4j
public class CarListController {

	@Autowired
	CarListService carListService;
	
	
	
	
	@RequestMapping("listCar")
	public String listCar() {
		return "car/indexfront";
	}
	
	
	
	
	
	@RequestMapping("queryCar")
	@ResponseBody
	public List<Car> queryCar(){
		
		return carListService.queryCar();
	}
	
	
	@RequestMapping("queryCarBrand")
	@ResponseBody
	public List<String> queryCarBrand() {
		return carListService.queryCarBrand();
	}

	@RequestMapping("queryCarSeries")
	@ResponseBody
	public List<String> queryCarSeries(){
		return carListService.queryCarSeries();
	}
	
	
}
