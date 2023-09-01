package com.cdac.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.Exception.BusinessException;
import com.cdac.entity.User;
import com.cdac.repository.UserRepository;
import com.cdac.service.UserService;

//Service implementation class
@Service
public class UserServiceImpl implements UserService {

	// User repository reference is autowired.
	@Autowired
	private UserRepository userRepository;

	// Add User method
	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	// login validation method
	@Override
	public String loginUser(String userName, String password) {
		User checkUser = userRepository.findByUserName(userName);
		String message = "Not a valid User..";

		if (checkUser != null) {
			if (checkUser.getUserName().equals(userName) && checkUser.getPassword().equals(password)) {
				message = "Successfully Login...!";
				return message;
			}

		}
		return message;

	}

	// User data update method.
	@Override
	public String updateUserData(User user, String userId) {
		User updateUser = findUser(userId);
		updateUser.setUserName(user.getUserName());
		updateUser.setPassword(user.getPassword());
		updateUser.setRole(user.getRole());
		userRepository.save(updateUser);
		return "User Updated Successfully...!";
	}

	// User password method.
	public String updateUserPassword(String userId, String newPassword) {
		User updateUser = findUser(userId);
		updateUser.setPassword(newPassword);
		userRepository.save(updateUser);
		return "Password Updated Successfully...!";
	}

	// User data to find on basis of user_id passed
	@Override
	public User findUser(String userId) {

		return userRepository.findByUserId(userId);
	}

}
