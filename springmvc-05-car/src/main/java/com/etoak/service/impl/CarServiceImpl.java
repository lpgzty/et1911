package com.etoak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;
import com.etoak.mapper.CarMapper;
import com.etoak.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javassist.CtNewConstructor;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarMapper carMapper;
	
	@Override
	public int addCar(Car car) {
		// TODO Auto-generated method stub
		return carMapper.addCar(car);
	}

	@Override
	public PageVo<CarVo> queryList(int pageNum, int pageSize, CarVo carVo) {
		//设置分页条件
		PageHelper.startPage(pageNum,pageSize);
		//查询冷裱
		List<CarVo> carList = carMapper.queryList(carVo);
		//创建pageInfo对象,用于获取分页数据
		PageInfo<CarVo> info = new PageInfo<CarVo>(carList);
		
		
		
		return new PageVo<CarVo>(info.getPageNum(),
				info.getPages(),
				carList,
				info.getTotal(),
				info.getPages(),
				info.isIsFirstPage(),
				info.isIsLastPage());
	}

	@Override
	public List<String> getAllBrand() {
		// TODO Auto-generated method stub
		return carMapper.getAllBrand();
	}

	@Override
	public List<String> getSeriesByBrand(String brand) {
		// TODO Auto-generated method stub
		return carMapper.getSeriesByBrand(brand);
	}

	

}
