package com.cdac.usertest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cdac.entity.User;
import com.cdac.repository.UserRepository;
import com.cdac.serviceimpl.UserServiceImpl;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Test
	void testSaveUser() {
		User user = new User("Pratik412","Pratikpatil","1212","GOVERNER");
		userService.addUser(user);
	
		boolean bool = userRepo.existsById("Pratik412");
		assertTrue(bool);
	}
	
	@Test
	void updateUserPasswordTest() {
		String getMessage = userService.updateUserPassword("Shubham923","9292" );
		System.out.println(getMessage);
	}
	
	

}
