package com.cdac.usertest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cdac.entity.User;
import com.cdac.repository.UserRepository;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepo;

	// Test case to check findall user from usertable.
	@Test
	@Disabled
	void checkFindAll() {
		User user1 = new User("Prathmesh456", "Prathamesh99", "789", "ADMIN");
		User user2 = new User("Rahul452", "Rahul128", "658", "USER");
		userRepo.save(user1);
		userRepo.save(user2);

		boolean result1 = userRepo.existsById("Prathmesh456");
		boolean result2 = userRepo.existsById("Rahul452");
		assertThat(result1).isTrue();
		assertThat(result2).isTrue();
	}

	@Test
	@Disabled
	void testCreatePerson() {
		User user = new User("Shubham923", "ShubhamRathod", "963", "ADMIN");
		User saveUser = userRepo.save(user);
		assertNull(saveUser);
	}

	@Test
	@Disabled
	void testFindByUserId() {
		User user = userRepo.findByUserId("Rahul452");
		System.out.println(user);
		assertNotNull(user);
	}

	@Test
	// @Disabled
	void testFindByUserName() {
		User user = userRepo.findByUserName("ShubhamRathod");
		System.out.println(user);
		assertNotNull(user);
	}

}
