package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Grade;

public interface GradeMapper {
	//查询所有年级信息
	List<Grade> findAll();
			
	//通过id查询年级信息
	Grade findById(long id);
		
	//保存年级信息
	void save(Grade grade);
			
	//修改年级信息
	void update(Grade grade);
			
	//删除年级信息
	void deleteById(long id);
}
