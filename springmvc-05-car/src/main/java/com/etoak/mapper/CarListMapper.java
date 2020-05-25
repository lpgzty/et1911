package com.etoak.mapper;

import java.util.List;

import com.etoak.bean.Car;

public interface CarListMapper {
	List<Car> queryCar();
	
	List<String> queryCarBrand();
	
	List<String> queryCarSeries();
}
