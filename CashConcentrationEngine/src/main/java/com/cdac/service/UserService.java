package com.cdac.service;

import com.cdac.entity.User;

//User service interface to provide methods and loose coupling.
public interface UserService {
	public void addUser(User user);

	public String updateUserData(User user, String userId);

	public User findUser(String userId);

	public String updateUserPassword(String userId, String newPassword);

	public String loginUser(String userName, String password);
}
