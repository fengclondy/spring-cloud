package com.cheng.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.cheng.demo.bean.Cat;

public interface CatRepository extends CrudRepository<Cat, Integer>{
	
}
