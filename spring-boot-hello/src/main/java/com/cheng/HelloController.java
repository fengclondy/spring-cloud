package com.cheng;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(){
		return "Hello Spring!";
	}
	
	@RequestMapping("/getDemo")
	public Demo getDemo(){
		Demo demo=new Demo();
		demo.setId(1);
		demo.setName("张山峰");
		demo.setCreateDate(new Date());
		demo.setRemarks("武当山的创始人");
		return demo;
	}
}
