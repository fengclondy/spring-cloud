package com.cheng.demo.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cheng.demo.bean.Cat;
import com.cheng.demo.repository.Cat2Repository;
import com.cheng.demo.repository.CatRepository;

@Service
public class CatService {
	
	@Resource
	private CatRepository catRepository;
	@Resource
	private Cat2Repository cat2Repository;
	
	/**
	 * save,update ,delete 方法需要绑定事务.
	 * 
	 * 使用@Transactional进行事务的绑定.
	 * 
	 * @param cat
	 */
	
	//保存数据.
	@Transactional
	public void save(Cat cat){
		catRepository.save(cat);
	}
	
	//删除数据》
	@Transactional
	public void delete(int id){
		catRepository.delete(id);
	}
	
	//查询数据.
	public Iterable<Cat> getAll(){
		return catRepository.findAll();
	}
	
	public Cat findByName(String name){
		return cat2Repository.findByName(name);
	}
	
	public Cat findByName2(String name){
		return cat2Repository.findMyCatName(name);
	}
	
}
