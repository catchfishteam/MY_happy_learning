package com.shenzk.web.controller;

import com.shenzk.web.dao.UserDao;
import com.shenzk.web.domain.User;
import com.shenzk.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
public class FirstController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDao;

	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}

	@RequestMapping("/get")
	public User get(){
		User user = userService.getUserById(1);
		System.out.println(user);
		return user;
	}

	@RequestMapping("/getList")
	public List<User> getUserList(){
		List<User> list = userService.getUserList();
		for(int i = 0; i < list.size(); i++){
			list.get(i).setRank(i+1);
		}
		return list;
	}

	@RequestMapping("/insert")
	public int insertUser(HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("name");
		String finishNum = request.getParameter("finishNum");
		String lastTime = request.getParameter("lastTime");
		return userService.insertUser(new User(name, Integer.parseInt(finishNum), lastTime));
	}

	@RequestMapping("/update")
	public int updateUser(HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("name");
		Integer finishNum = Integer.parseInt(request.getParameter("finishNum"));
		String lastTime = request.getParameter("lastTime");
		User user = new User(name, finishNum, lastTime);
		return userService.updateUser(user);
	}

	@RequestMapping("/delete")
	public int deleteUser(){
		return userService.deleteUser(2);
	}
}
