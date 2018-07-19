package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Answer;
import com.briup.app02.service.IAnswerService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="答案相关接口")
@RestController
@RequestMapping("/answer")
public class AnswerController {
	//注入studentService的实例
	@Autowired
	private IAnswerService answerService;
	
	@ApiOperation(value="添加答案信息",notes="id不用填")
	@PostMapping("saveAnswer")
	public MsgResponse saveAnswer(Answer answer){
		try {
			answerService.save(answer);
			return MsgResponse.success("添加问卷答案成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
		
	@ApiOperation(value="修改答案信息",notes="通过id修改信息")	
	@PostMapping("updateAnswer")
	public MsgResponse updateAnswer(Answer answer){
		try {
			answerService.update(answer);
			return MsgResponse.success("修改答卷答案成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
			
	}	
		
	@ApiOperation(value="删除答案信息",notes="通过id删除答案信息")
	@GetMapping("deleteAnswerById")
	public MsgResponse deleteAnswerById(long id){
		try {
			// 调用service层代码删除学生信息
			answerService.deleteById(id);
			// 如果删除成功返回成功信息
			return MsgResponse.success("删除答卷成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
		
	//http://127.0.0.1:8080/student/findAllAnswer
	@ApiOperation(value="查询答案信息",notes="查询某个答案")
	@GetMapping("findAllAnswer")
	public MsgResponse findAllAnswer(){
			
		try {
			List<Answer> list = answerService.findAll();
			return MsgResponse.success("查询答卷成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="添加班级信息",notes="id不用填")
	@GetMapping("findAnswerById")
	public MsgResponse findAnswerById(long id){
		try {
			Answer answer = answerService.findById(id);
			return MsgResponse.success("查询答卷成功！", answer);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}

