package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Option;

public interface OptionMapper {
	//查询所有选项信息
	List<Option> findAll();
		
	//通过id查询选项信息
	Option findById(long id);
			
	//保存选项信息
	void save(Option option);
			
	//修改选项信息
	void update(Option option);
			
	//删除选项信息
	void deleteById(long id);
}
