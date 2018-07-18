package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Option;
import com.briup.app02.service.IOptionService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="选项相关接口")
@RestController
@RequestMapping("/option")
public class OptionController {
	// 注入studentService的实例
	@Autowired
	private IOptionService optionService;

	@PostMapping("saveOption")
	public MsgResponse saveOption(Option option) {
		try {
			optionService.save(option);
			return MsgResponse.success("添加选项信息成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@PostMapping("updateOption")
	public MsgResponse updateOption(Option option) {
		try {
			optionService.update(option);
			return MsgResponse.success("修改选项信息成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@GetMapping("deleteOptionById")
	public MsgResponse deleteOptionById(long id) {
		try {
			// 调用service层代码删除学生信息
			optionService.deleteById(id);
			// 如果删除成功返回成功信息
			return MsgResponse.success("删除选项信成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAllOption")
	public MsgResponse findAllOption() {

		try {
			List<Option> list = optionService.findAll();
			return MsgResponse.success("查询选项信成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findOptionById")
	public MsgResponse findOptionById(long id) {
		try {
			Option option = optionService.findById(id);
			return MsgResponse.success("查询选项信成功！", option);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
