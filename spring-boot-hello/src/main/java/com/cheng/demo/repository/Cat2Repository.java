package com.cheng.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.cheng.demo.bean.Cat;

public interface Cat2Repository extends PagingAndSortingRepository<Cat, Integer>{
	
	
	/**
	 * 1/ 查询方法 以 get | find | read 开头.
	 * 2/ 涉及查询条件时，条件的属性用条件关键字连接，要注意的是条件属性以首字母大写。
	 */
	
	//根据catName进行查询 : 根据catName进行查询.
	public Cat findByName(String name);
	
	/**
	 * 如何编写JPQL语句， 
	 * Hibernate  -- HQL语句.
	 * JPQL 语句 和HQL语句是类似的.
	 */
	@Query("from Cat where name=:cn")
	public Cat findMyCatName(@Param("cn")String name);
}