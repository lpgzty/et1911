package com.etoak.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.x500.X500Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etoak.bean.Student;
import com.etoak.bean.User;
import com.etoak.vo.ResultVo;

@RestController
@RequestMapping("/json")
public class JsonController {
	@PostMapping(value="/jsonToMap",produces = "application/json;charset=utf-8")
	public String mapToJson(@RequestBody Map<String,Object> jsoMap) {
		System.out.println(jsoMap);
		
		return "{\"msg\":\"success\"}" ;
	}
	
	@PostMapping("/jsonToList")
	public Map<String, Object> jsonToList(
				@RequestBody List<User> userList
			){
		//打印参数
		userList.forEach(x -> System.out.println(x));
		
		//封装结构 spring mvc可以自动将map转换成json返回
		Map<String,Object> resMap = new HashMap<String, Object>();
		resMap.put("code",200);
		resMap.put("msg","SUCCESS");
		return resMap;
	}
	
	@PostMapping("/jsonToBean")
	public ResultVo jsonToBean(
				@RequestBody Student student
			) {
		System.out.println(student);
		
		return new ResultVo(200,"SUCCESS");
	}
	
	
	
}














