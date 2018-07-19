package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Grade;
import com.briup.app02.service.IGradeService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="年级相关接口")
@RestController
@RequestMapping("/grade")
public class GradeController {
	// 注入studentService的实例
	@Autowired
	private IGradeService gradeService;

	@ApiOperation(value="添加年级信息",notes="id不用填")
	@PostMapping("saveGrade")
	public MsgResponse saveStudent(Grade grade) {
		try {
			gradeService.save(grade);
			return MsgResponse.success("添加年级信息成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="修改课程信息",notes="通过id修改课程信息")
	@PostMapping("updateGrade")
	public MsgResponse updateGrade(Grade grade) {
		try {
			gradeService.update(grade);
			return MsgResponse.success("修改年级信息成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@GetMapping("deleteGradeById")
	public MsgResponse deleteGradeById(long id) {
		try {
			// 调用service层代码删除学生信息
			gradeService.deleteById(id);
			// 如果删除成功返回成功信息
			return MsgResponse.success("删除年级信息成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAllGrade")
	public MsgResponse findAllStudent() {

		try {
			List<Grade> list = gradeService.findAll();
			return MsgResponse.success("删除年级信息成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findGradeById")
	public MsgResponse findGradeById(long id) {
		try {
			Grade grade = gradeService.findById(id);
			return MsgResponse.success("删除年级信息成功！", grade);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
