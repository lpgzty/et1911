package com.etoak.bean;

import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data //包括get/set/toString/equals....
@NoArgsConstructor //无参构造方法
//@ArgsConstructor //按照参数书序生成的构造构造方法
public class Student {
	private Integer id;
	private String name;
	private Integer age;
	
	private List<String> hobbyList;
	
	private Map<String,Object> stuMap;
	
}
