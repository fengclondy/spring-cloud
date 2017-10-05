package com.cheng.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/templates")
public class TemplatesController {
	
	/**
	 * 映射地址是：/templates/hello
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello(Map<String,Object> map){
		//返回的是ModelAndView对象;
        //ModelAndView mv = new ModelAndView("hello");
        //return mv;
		map.put("name","Andy");
		return "hello";
	}
	
	@RequestMapping("/helloFtl")
	public String helloFtl(Map<String,Object> map){
		map.put("name","Andy");
		return "helloFtl";
	}
	
}