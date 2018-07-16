package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.School;
import com.briup.app02.service.ISchoolService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/school")
public class SchoolController {
	//注入schoolService的实例
	@Autowired
	private ISchoolService schoolService;
	
	@PostMapping("saveSchool")
	public MsgResponse saveSchool(School school){
		try {
			schoolService.save(school);
			return MsgResponse.success("添加学生信息成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@PostMapping("updateSchool")
	public MsgResponse updateSchool(School school){
		try {
			schoolService.update(school);
			return MsgResponse.success("修改成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}	
	
	@GetMapping("deleteSchoolById")
	public MsgResponse deleteSchoolById(long id){
		try {
			// 调用service层代码删除学生信息
			schoolService.deleteById(id);
			// 如果删除成功返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAllSchool")
	public List<School> findAllSchool(){
		
		try {
			List<School> list = schoolService.findAll();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@GetMapping("findSchoolById")
	public School findSchoolById(long id){
		try {
			School school = schoolService.findById(id);
			return school;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
