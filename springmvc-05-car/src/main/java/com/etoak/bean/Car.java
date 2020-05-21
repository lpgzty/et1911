package com.etoak.bean;

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
	private String brand; 
	//车系
	private String series; 		
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
	private String summary; 	
	//创建时间
	private String createTime; 	
}












