package com.etoak.service;

import java.util.List;

import com.etoak.bean.Car;

public interface CarListService {
	List<Car> queryCar();
	
	List<String> queryCarBrand();
	
	List<String> queryCarSeries();
}
