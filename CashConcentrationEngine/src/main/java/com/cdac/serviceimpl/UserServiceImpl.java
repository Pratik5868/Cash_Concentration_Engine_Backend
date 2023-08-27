package com.cdac.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.User;
import com.cdac.repository.UserRepository;
import com.cdac.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}
    @Override
	public String loginUser(String userName, String password) {
		User checkUser = userRepository.findByUserName(userName);
		if (checkUser.getUserName().equals(userName) && checkUser.getPassword().equals(password)) {
			return "Successfully Login...!";
		}
		return "Not a valid User";
	}

	@Override
	public String updateUserData(User user, String userId) {
		User updateUser = findUser(userId);
		updateUser.setUserName(user.getUserName());
		updateUser.setPassword(user.getPassword());
		updateUser.setRole(user.getRole());
		userRepository.save(updateUser);
		return "User Updated Successfully...!";
	}

	public String updateUserPassword(String userId, String newPassword) {
		User updateUser = findUser(userId);
		updateUser.setPassword(newPassword);
		userRepository.save(updateUser);
		return "Password Updated Successfully...!";
	}

	@Override
	public User findUser(String userId) {

		return userRepository.findByUserId(userId);
	}

}
