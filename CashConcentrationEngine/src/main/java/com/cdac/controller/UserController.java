package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.User;
import com.cdac.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
     
	@PostMapping("SaveUser")
	public void saveUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PostMapping("ChangeUserData")
	public String changeUserData(@RequestBody  User user,@RequestParam String userId) {
		return userService.updateUserData(user,userId);
	}
	
	@PostMapping("ChangeUserPassword")
	public String changeUserPassword(@RequestParam  String userId,@RequestParam String newPassword) {
		return userService.updateUserPassword(userId, newPassword);
	}
	
	@PostMapping("validatelogin")
	public String checkLogin(@RequestParam String userName,@RequestParam  String password) {
		return this.userService.loginUser(userName, password);
	}
}
