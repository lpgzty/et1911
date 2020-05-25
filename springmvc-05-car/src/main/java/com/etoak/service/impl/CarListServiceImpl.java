package com.etoak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoak.bean.Car;
import com.etoak.mapper.CarListMapper;
import com.etoak.service.CarListService;

@Service
public class CarListServiceImpl implements CarListService {

	@Autowired
	CarListMapper carListMapper;
	
	
	@Override
	public List<Car> queryCar() {
		
		return carListMapper.queryCar();
	}


	@Override
	public List<String> queryCarBrand() {
		
		return carListMapper.queryCarBrand();
	}


	@Override
	public List<String> queryCarSeries() {
		// TODO Auto-generated method stub
		return carListMapper.queryCarSeries();
	}

}
