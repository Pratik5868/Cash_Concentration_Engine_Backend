package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	public User findByUserId(String userId);
	
	public User findByUserName(String userName);

}
