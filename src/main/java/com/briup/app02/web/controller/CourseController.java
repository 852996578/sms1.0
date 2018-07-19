package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Course;
import com.briup.app02.service.ICourseService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="课程相关接口")
@RestController
@RequestMapping("/course")
public class CourseController {
	// 注入studentService的实例
	@Autowired
	private ICourseService courseService;

	@ApiOperation(value="添加课程信息",notes="id不用填")
	@PostMapping("saveCourse")
	public MsgResponse saveCourse(Course course) {
		try {
			courseService.save(course);
			return MsgResponse.success("添加课程信息成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="修改课程信息",notes="通过id修改课程信息")
	@PostMapping("updateCourse")
	public MsgResponse updateCourse(Course course) {
		try {
			courseService.update(course);
			return MsgResponse.success("修改课程信息成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@ApiOperation(value="删除课程信息",notes="通过id删除信息")
	@GetMapping("deleteCourseById")
	public MsgResponse deleteCourseById(long id) {
		try {
			// 调用service层代码删除学生信息
			courseService.deleteById(id);
			// 如果删除成功返回成功信息
			return MsgResponse.success("删除课程信息成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// http://127.0.0.1:8080/course/findAllCourse
	@ApiOperation(value="查询课程信息",notes="查询全部课信息")
	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse() {

		try {
			List<Course> list = courseService.findAll();
			return MsgResponse.success("查询课程信息成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="查询课程信息",notes="通过id查询某个课程信息")
	@GetMapping("findCourseById")
	public MsgResponse findCourseById(long id) {
		try {
			Course course = courseService.findById(id);
			return MsgResponse.success("查询课程信息成功！", course);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
