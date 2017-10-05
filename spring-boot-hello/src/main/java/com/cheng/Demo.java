package com.cheng;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Demo {
	private int id;
	private String name;
	
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	
	@JSONField(serialize=false)
	private String remarks;
	
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
