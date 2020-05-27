package com.etoak.bean;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarVo extends Car{
	private String levelName;
	
	private String gerboxName;
	
	private String outputVolumeName;
	
	//传到sql中的条件
	@JsonIgnore //返回的时候不会把这个属性返回到结果中
	private List<Map<String, Integer>> priceMapList;
	
	@JsonIgnore
	private String vehicleAge;
	
	@JsonIgnore
	private Integer startYear;
	@JsonIgnore
	private Integer endYear;
	
	
	
	
}
















