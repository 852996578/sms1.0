package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Course;

public interface CourseMapper {
	//查询所有课程信息
	List<Course> findAll();
				
	//通过id查询课程信息
	Course findById(long id);
			
	//保存课程信息
	void save(Course course);
				
	//修改课程信息
	void update(Course course);
				
	//删除课程信息
	void deleteById(long id);
}
