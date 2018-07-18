package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Clazz;
import com.briup.app02.dao.ClazzMapper;
import com.briup.app02.dao.extend.ClazzVMMapper;
import com.briup.app02.service.IClazzService;
import com.briup.app02.vm.ClazzVM;

@Service
public class ClazzServiceImpl implements IClazzService {
	//注入ClazzMapper   让spring产生一个ClazzMapper的对象，然后送过来
	@Autowired
	private ClazzVMMapper clazzVMMapper;
	@Autowired
	private ClazzMapper clazzMapper;

	@Override
	public List<Clazz> findAll() throws Exception {
		// 调用studnetMapper查询所有学生
		List<Clazz> list = clazzMapper.findAll();
		return list;
	}

	@Override
	public List<ClazzVM> findAllClazzVM() throws Exception {
		List<ClazzVM> list = clazzVMMapper.findAllClazzVM();
		return list;
	}
	
	@Override
	public Clazz findById(long id) throws Exception {
		// 通过id查询某个学生
		return clazzMapper.findById(id);
	}

	@Override
	public void save(Clazz clazz) throws Exception {
		// 插入学生信息
		clazzMapper.save(clazz);
	}

	@Override
	public void update(Clazz clazz) throws Exception {
		// 修改学生信息
		clazzMapper.update(clazz);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// 1. 通过id查找
		Clazz clazz = clazzMapper.findById(id);
		// 2. 如果该学生存在，执行删除操作，如果该学生不存在，抛出异常
		if (clazz != null) {
			clazzMapper.deleteById(id);
		} else {
			throw new Exception("要删除的班级不存在");
		}
	}
}
