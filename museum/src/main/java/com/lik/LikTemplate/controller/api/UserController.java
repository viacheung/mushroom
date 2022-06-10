package com.lik.LikTemplate.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lik.LikTemplate.common.Result;
import com.lik.LikTemplate.entity.CulturalRelic;
import com.lik.LikTemplate.entity.Enshrine;
import com.lik.LikTemplate.entity.Notice;
import com.lik.LikTemplate.entity.User;
import com.lik.LikTemplate.entity.vo.CollectionVo;
import com.lik.LikTemplate.service.UserService;
import com.lik.LikTemplate.utils.VerifyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;



	@RequestMapping("/verifyPic")
	@ResponseBody
	public String addUser(String code, HttpServletResponse response) {
		Map<String, Object> data = VerifyUtil.generateVerify(code);
		//获取图片
		BufferedImage verifyPic = (BufferedImage) data.get("verifyPic");
		//输出图片给前端，使用工具类ImageIO
		try {
			ImageIO.write(verifyPic, "jpg", response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	// 用户注册
	@RequestMapping("/register")
	@ResponseBody
	public Result insertUser(@RequestBody User user) {
		System.out.println(userService);
		int rows = userService.insertUser(user);
		if (rows > 0) {
			System.out.println("成功添加" + rows + "条数据！");
			return Result.ok().data("item",user);
		} else {
			System.out.println("ִ添加失败");
			return Result.error().message("ִ添加失败");
		}
	}


	// 用户登录验证
	@PostMapping("/login")
	@ResponseBody
	public Result userLogin(@RequestBody User user) {

		System.out.println(user);
		boolean flag = userService.userLogin(user);
		if (flag) {
			System.out.println("登录成功");
			return Result.ok().data("item",user);
		} else {
			System.out.println("登录失败");
			return Result.error().message("登录失败");
		}
	}

	@PostMapping("/1")
	public String userLogin1(User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("name", user.getUserName());
		session.setMaxInactiveInterval(6000);
		System.out.println("跳转主页");
		return "table";
	}

	// 判断用户名
	@PostMapping("/judgeUser")
	@ResponseBody
	public String judgeUser(User user) {
		boolean flag = userService.judgeUser(user);
		if (flag) {
			return "OK";
		} else {
			return "F";
		}
	}

	// 通过用户名查找用户
	@RequestMapping(value = "/querUser", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String QueryById(Model model, HttpServletRequest request) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("name");
		// System.out.println(username);
		User user = userService.queryUserById(username);
		model.addAttribute("user", userService.queryUserById(username));
		String str = mapper.writeValueAsString(user);
		return str;
	}

	// 修改密码
	@PostMapping("/updatePwd")
	@ResponseBody
	public String updatePwd(String userPwd, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		// System.out.println(name + userPwd);
		int i = userService.updatePwd(userPwd, name);
		if (i > 0) {
			System.out.println("密码更新成功");
			return "OK";
		} else {
			System.out.println("密码更新失败");
			return "F";
		}

	}

	// 密码比对
	@PostMapping("/pwd")
	@ResponseBody
	public String Pwd(String oldPwd, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		User user = userService.queryUserById(name);
		if (user.getUserPwd().equals(oldPwd)) {
			System.out.println("旧密码正确");
			return "OK";
		} else {
			System.out.println("旧密码不正确");
			return "F";
		}
	}

	// 更新用户信息
	@PostMapping("/updateUser")
	@ResponseBody
	public Result updateUser(@RequestBody User user) {

		int r = userService.updateUser(user);
		if (r > 0) {
			System.out.println("用户信息更新成功");
			return Result.ok();
		} else {
			System.out.println("用户信息更新失败");
			return Result.error().message("用户信息更新失败");
		}
	}

	// 查询全部文物
	@RequestMapping(value = "/getCulturalRelicByName", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Result getCulturalRelicByName(@RequestParam(defaultValue = "1", value = "name") String name) throws JsonProcessingException {
		// 创建一个对象
		List<CulturalRelic> culturalRelic = userService.queryCulturalRelicByName(name);
		return Result.ok().data("items",culturalRelic);
	}






	// 查询用户收藏
	@RequestMapping(value = "/queryEnshrine",produces="application/json;charset=utf-8")
	@ResponseBody
	public Result queryEnshrine(@RequestBody Enshrine enshrine) throws JsonProcessingException {

		System.out.print(enshrine.getName());
		List<CollectionVo> enshrines = userService.queryEnshrine(enshrine);
		System.out.print(enshrines);
		return Result.ok().data("items", enshrines);
	}

	// 查询用户收藏
	@RequestMapping(value = "/queryEnshrine1", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Result queryEnshrine1(@RequestBody Enshrine enshrine) throws JsonProcessingException {

		System.out.println(enshrine);
		if(userService.queryEnshrine1(enshrine)) {//已收藏
			return Result.ok().data("flag",true);
		}
		return Result.ok().data("flag",false);
	}

	// 取消收藏
	@RequestMapping("/deleteUserEnshrine")
	@ResponseBody
	public Result deleteUserEnshrine(@RequestBody Enshrine enshrine) {
		int rows = userService.deleteUserEnshrine(enshrine);
		if (rows > 0) {
			System.out.println("成功删除" + rows + "条收藏！");
			return Result.ok();
		} else {
			System.out.println("ִ删除收藏失败");
			return Result.error().message("ִ删除收藏失败");
		}
	}

	// 收藏
	@RequestMapping("/userEnshrine")
	@ResponseBody
	public Result userEnshrine(@RequestBody Enshrine enshrine) {
		System.out.println("进来了1111");
		int rows = userService.userEnshrine(enshrine);
		if (rows > 0) {
			System.out.println("成功添加" + rows + "条收藏！");
			return Result.ok();
		} else {
			System.out.println("ִ添加收藏失败");
			return Result.error().message("ִ添加收藏失败");
		}
	}

}
