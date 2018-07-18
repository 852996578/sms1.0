package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Answer;

public interface AnswerMapper {
	//查询所有问卷答案信息
	List<Answer> findAll();
		
	//通过id查询问卷答案信息
	Answer findById(long id);
			
	//保存问卷答案信息
	void save(Answer answer);
			
	//修改问卷答案信息
	void update(Answer answer);
			
	//删除问卷答案信息
	void deleteById(long id);
}
