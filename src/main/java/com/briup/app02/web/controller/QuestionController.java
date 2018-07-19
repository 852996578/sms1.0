 package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Question;
import com.briup.app02.service.IQuestionService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.QuestionVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问题相关接口")
@RestController
@RequestMapping("/question")
public class QuestionController {
	// 注入studentService的实例
	@Autowired
	private IQuestionService questionService;

	@ApiOperation(value="保存问题"
						,notes="保存问题的同时还应该保存选项,问题id,选项id,选项中的外键question_id也不必输入")
	@PostMapping("saveQuestion")
	public MsgResponse saveQuestion(QuestionVM questionVM) {
		try {
			//调用业务逻辑层方法完成保存
			System.out.println("======"+questionVM);
			questionService.saveQuestion(questionVM);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@PostMapping("updateQuestion")
	public MsgResponse updateQuestion(Question question) {
		try {
			questionService.update(question);
			return MsgResponse.success("修改问题信息成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@GetMapping("deleteQuestionById")
	public MsgResponse deleteStudentById(long id) {
		try {
			// 调用service层代码删除学生信息
			questionService.deleteById(id);
			// 如果删除成功返回成功信息
			return MsgResponse.success("删除问题信息成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// http://127.0.0.1:8080/question/findAllQuestion
	@ApiOperation(value="查询所有问题"
			,notes="只能查询问题的基本信息，无法练级查询到问题答案")
	@GetMapping("findAllQuestion")
	public MsgResponse findAllQuestion() {

		try {
			List<Question> list = questionService.findAll();
			return MsgResponse.success("查询问题信息成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="查询所有问题并级联问题选项"
			,notes="查询问题的基本信息，并且级联查询到问题选项")	
	@GetMapping("findAllQuestionVM")
	public MsgResponse findAllQuestionVM() {

		try {
			List<QuestionVM> list = questionService.findAllQuestionVM();
			return MsgResponse.success("查询问题信息成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findQuestionById")
	public MsgResponse findQuestionById(long id) {
		try {
			Question question = questionService.findById(id);
			return MsgResponse.success("查询成功！", question);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
