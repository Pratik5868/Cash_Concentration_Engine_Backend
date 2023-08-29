package com.cdac.controller;

import javax.validation.Valid;

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
     
	@PostMapping("saveUser")
	public void saveUser(@Valid  @RequestBody User user) {
		userService.addUser(user);
	}
	
	@PostMapping("ChangeUserData")
	public String changeUserData(@Valid @RequestBody  User user,@Valid @RequestParam String userId) {
		return userService.updateUserData(user,userId);
	}
	
	@PostMapping("ChangeUserPassword")
	public String changeUserPassword(@Valid @RequestParam  String userId,@Valid @RequestParam String newPassword) {
		return userService.updateUserPassword(userId, newPassword);
	}
	
	@PostMapping("validatelogin")
	public String checkLogin(@Valid @RequestParam String userName,@Valid @RequestParam  String password) {
		return this.userService.loginUser(userName, password);
	}
}
