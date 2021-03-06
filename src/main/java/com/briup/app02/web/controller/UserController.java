package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.User;
import com.briup.app02.service.IUserService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
	// 注入studentService的实例
	@Autowired
	private IUserService userService;

	@PostMapping("saveUser")
	public MsgResponse saveUser(User user) {
		try {
			userService.save(user);
			return MsgResponse.success("添加用户信息成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@PostMapping("updateUser")
	public MsgResponse updateUser(User user) {
		try {
			userService.update(user);
			return MsgResponse.success("修改用户信息成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@GetMapping("deleteUserById")
	public MsgResponse deleteUserById(long id) {
		try {
			// 调用service层代码删除学生信息
			userService.deleteById(id);
			// 如果删除成功返回成功信息
			return MsgResponse.success("删除用户信息成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// http://127.0.0.1:8080/user/findAllUser
	@GetMapping("findAllUser")
	public MsgResponse findAllUser() {

		try {
			List<User> list = userService.findAll();
			return MsgResponse.success("查询用户信息成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findUserById")
	public MsgResponse findUserById(long id) {
		try {
			User user = userService.findById(id);
			return MsgResponse.success("查询用户信息成功！", user);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
