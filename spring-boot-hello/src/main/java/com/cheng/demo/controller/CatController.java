package com.cheng.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cheng.demo.bean.Cat;
import com.cheng.demo.service.CatService;

@RestController
@RequestMapping("/cat")
public class CatController {
	
	@Resource
	private CatService catService;
	
	@RequestMapping("/save")
	public String save(){
		Cat cat = new Cat();
		cat.setName("jack");
		cat.setAge(3);
		catService.save(cat);
		return "save ok.";
	}
	
	@RequestMapping("/delete")
	public String delete(){
		catService.delete(1);
		return "delete ok";
	}
	
	@RequestMapping("/getAll")
	public Iterable<Cat> getAll(){
		return catService.getAll();
	}
	
	@RequestMapping("/getName1")
	public Cat getName1(String name){
		return catService.findByName(name);
	}
	
	@RequestMapping("/getName2")
	public Cat getName2(String name){
		return catService.findByName2(name);
	}
	
	
}
