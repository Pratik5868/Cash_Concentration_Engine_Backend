package com.cdac.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.User;
import com.cdac.service.UserService;

//UserController class at district level
@RestController
public class UserController {
	
	// User Service interface is use to autowired for loose coupling
	@Autowired
	private UserService userService;
    
	
	////PostMapping is use to save the User.
	@PostMapping("saveUser")
	public void saveUser(@Valid  @RequestBody User user) {
		userService.addUser(user);
	}
	
	//PutMapping use to upadte the User data in database
	@PutMapping("ChangeUserData")
	public String changeUserData(@Valid @RequestBody  User user,@Valid @RequestParam String userId) {
		return userService.updateUserData(user,userId);
	}
	
	//PostMapping use to change user password
	@PostMapping("ChangeUserPassword")
	public String changeUserPassword(@Valid @RequestParam  String userId,@Valid @RequestParam String newPassword) {
		return userService.updateUserPassword(userId, newPassword);
	}
	
	//PostMapping use to validate user by passing username and password
	@PostMapping("validatelogin")
	public String checkLogin(@Valid @RequestParam String userName,@Valid @RequestParam  String password) {
		return this.userService.loginUser(userName, password);
	}
}
