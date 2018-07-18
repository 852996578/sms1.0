package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Qq;

public interface QqMapper {
	//查询所有桥梁信息
	List<Qq> findAll();
			
	//通过id查询桥梁信息
	Qq findById(long id);
			
	//保存桥梁信息
	void save(Qq qq);
			
	//修改桥梁信息
	void update(Qq qq);
		
	//删除桥梁信息
	void deleteById(long id);
}
