package com.etoak.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/*
 * id int PRIMARY key auto_increment,
	brand VARCHAR(64) not null COMMENT '品牌',
	series VARCHAR(64) not null COMMENT '车系',
	price int not null COMMENT '价格',
	licensing_time VARCHAR(7) comment '上牌时间',
	level varchar(1) comment '级别',
	gearbox VARCHAR(1) comment '变速箱',
	output_volume VARCHAR(1) comment '排量',
	mileage int COMMENT '里程(万)',
	location VARCHAR(64) COMMENT '归属地',
	pic VARCHAR(128) comment '图片地址',
	summary varchar(512) comment '概述',
	create_time datetime comment '创建时间'
 */

@Data
public class Car {
	//
	private Integer id; 		
	//品牌
	@NotNull(message = "brand not null")
	@NotEmpty(message = "brand not null")
	private String brand; 
	
	//车系
	@NotNull(message = "车系不能为空")
	@NotEmpty(message = "车系不能为空")
	private String series; 		
	
	@NotNull(message = "价格不能为空" )
	@Min(value = 1,message = "价格最小为1")
	@Max(value = 100,message = "不能大于100")
	private Integer price;
	//上牌时间
	private String licensingTime;
	//级别
	private String level;		
	//变速箱
	private String gearbox; 	
	//排量
	private String outputVolume;
	//里程
	private Integer mileage; 	
	//归属地
	private String location; 	
	//图片地址
	private String pic; 		
	//概述
	@Size(min=6,max = 15,message = "概述只能在5-15个字符之间")
	private String summary; 	
	//创建时间
	private String createTime; 	
	
	private String gearboxName;
	private String levelName;
	private String outputVolumeName;
	
}












