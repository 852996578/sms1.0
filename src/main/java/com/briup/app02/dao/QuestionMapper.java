package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Question;

public interface QuestionMapper {
	
	//查询所有问题信息
	List<Question> findAll();
			
	//通过id查询问题信息
	Question findById(long id);
			
	//保存问题信息
	void save(Question option);
			
	//修改问题信息
	void update(Question option);
			
	//删除问题信息
	void deleteById(long id);
}
