package com.etoak.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;
import com.etoak.exception.ParameException;
import com.etoak.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {
	
	
	@Autowired
	CarService carService;
	
	//跳转到添加车辆页面
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "car/add";
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("/toList")
	public String toList() {
		
		
		return "car/list";
	}
	
	//车辆列表查询
	@GetMapping("/list")
	@ResponseBody
	public PageVo<CarVo> queryList(
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "8") int pageSize,
			CarVo carVo,
			String[] priceList
			){
		return carService.queryList(pageNum, pageSize, carVo,priceList);
	}
	
	
	
	@RequestMapping("/add")
	public String add(MultipartFile file,
			@Valid Car car,
			BindingResult bindingResult,
			HttpServletRequest request
			) throws IllegalStateException, IOException {
		
		String originalFilename = file.getOriginalFilename();
		log.info("文件名称 - {}",originalFilename);
		log.info("param car - {}",car);
		
		
		//先校验参数car
		//先获取所有的校验结果
		List<ObjectError> allErrors = bindingResult.getAllErrors();
		if(!CollectionUtils.isEmpty(allErrors)) {
			StringBuffer errorBuf = new StringBuffer();
			for(ObjectError error : allErrors) {
				String errorMsg = error.getDefaultMessage();
				errorBuf.append(errorMsg).append(";");
			}
			//request.setAttribute("paramError", errorBuf.toString());
			//return "forward:/car/toAdd";
			
			//抛出异常,让全局异常处理器去处理
			throw new ParameException(errorBuf.toString());
		}
		
		
		//新文件名字:UUID_originalFilename
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		
		String newFileName = uuid + "_"+originalFilename;
		
		//目标文件d:/upload/uuid_老文件名.jpg
		File destFile = new File("e:/upload",newFileName);
		
		file.transferTo(destFile);
		
		//设置图片地址
		car.setPic("/pic/"+newFileName );
		
		//调用服务层添加车辆信息
		carService.addCar(car);
		
		//重定向方式返回
		return "redirect:/car/toAdd";
	}
	
	
	@GetMapping("/getBrand")
	@ResponseBody
	public List<String> getBrand(){
		return carService.getAllBrand();
	}
	
	@GetMapping("/getSeries")
	@ResponseBody
	public List<String> getSeries(String brand){
		return carService.getSeriesByBrand(brand);
		
		
	}
	
	
	
	
}























