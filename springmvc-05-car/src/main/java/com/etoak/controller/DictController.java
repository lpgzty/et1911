package com.etoak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etoak.bean.Dict;
import com.etoak.service.DictService;

@RestController
@RequestMapping("/dict")
public class DictController {
	
	@Autowired
	DictService dictService;
	
	
	/**
	 * springmvc 提供了一个注解@PathVariable,可以吧url地址上的参数映射到
	 * @param groupId
	 * @return
	 */
	
	@GetMapping("/{groupId}")
	public List<Dict> queryList(@PathVariable String groupId){
		return dictService.queryList(groupId);
	}
	
	
	
}
