package com.etoak.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;

public interface CarMapper {
	//添加车辆信息
	int addCar(Car car);
	
	List<CarVo> queryList(CarVo carVo);
	
	List<String> getAllBrand();
	
	//根据品牌查询车系,品牌为空时,随机查询十条数据
	List<String> getSeriesByBrand(
				@Param("brand") String brand
			);
}
