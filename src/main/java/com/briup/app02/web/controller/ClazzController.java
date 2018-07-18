package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Clazz;
import com.briup.app02.service.IClazzService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.ClazzVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="班级相关接口")
@RestController   //服务
@RequestMapping("/clazz")
public class ClazzController {
	// 注入studentService的实例
	@Autowired
	private IClazzService clazzService;

	@PostMapping("saveClazz")
	public MsgResponse saveClazz(Clazz clazz) {
		try {
			clazzService.save(clazz);
			return MsgResponse.success("添加班级信息成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@PostMapping("updateClazz")
	public MsgResponse updateClazz(Clazz clazz) {
		try {
			clazzService.update(clazz);
			return MsgResponse.success("修改班级信息成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@GetMapping("deleteClazzById")
	public MsgResponse deleteClazzById(long id) {
		try {
			// 调用service层代码删除学生信息
			clazzService.deleteById(id);
			// 如果删除成功返回成功信息
			return MsgResponse.success("删除班级信息成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// http://127.0.0.1:8080/student/findAllClazz
	@ApiOperation(value="查询所有班级"
			,notes="只能查询班级的基本信息，无法练级查询到年级和班主任")
	@GetMapping("findAllClazz")
	public MsgResponse findAllClazz() {

		try {
			List<Clazz> list = clazzService.findAll();
			return MsgResponse.success("查询班级信息成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage()); 
		}
	}

	@ApiOperation(value="查询所有班级并级联年级和班主任"
			,notes="查询班级的基本信息，并且级联查询到年级和班主任")
	@GetMapping("findAllClazzVM")
	public MsgResponse findAllClazzVM() {

		try {
			List<ClazzVM> list = clazzService.findAllClazzVM();
			return MsgResponse.success("查询班级，年级，班主任信息成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage()); 
		}
	}

	
	@GetMapping("findClazzById")
	public MsgResponse findClazzById(long id) {
		try {
			Clazz clazz = clazzService.findById(id);
			return MsgResponse.success("查询班级信息成功！", clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage()); 
		}
	}
}
