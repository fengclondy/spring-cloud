package com.cheng.demo.service;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cheng.Demo;
import com.cheng.demo.mapper.DemoMappper;

@Service
public class DemoService {

	@Resource
	private DemoMappper demoMappper;
	
	public List<Demo> likeName(String name){
		return demoMappper.likeName(name);
	}
	
	@Transactional//添加事务.
	public void save(Demo demo){
		demoMappper.save(demo);
	}
	
}
