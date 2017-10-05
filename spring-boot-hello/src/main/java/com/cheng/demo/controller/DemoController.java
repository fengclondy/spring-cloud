package com.cheng.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cheng.Demo;
import com.cheng.demo.service.DemoService;
import com.github.pagehelper.PageHelper;

@RestController
public class DemoController {
	
	@Resource
	private DemoService demoService;
	
	@RequestMapping("/likeName")
	public List<Demo> likeName(String name){
		/*
		 * 第一个参数：第几页;
		 * 第二个参数：每页获取的条数.
		 */
		PageHelper.startPage(1, 2);
		return demoService.likeName(name);
	}
	
	@RequestMapping("/save")
	public Demo save(){
		Demo demo = new Demo();
		demo.setName("张三");
		demo.setId(6);
		demoService.save(demo);
		return demo;
	}
	
}
