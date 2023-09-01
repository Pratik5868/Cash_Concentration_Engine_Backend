package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entity.User;

//CompanyRepository use to give database related operations
@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	//Custom queries.
	public User findByUserId(String userId);
	
	public User findByUserName(String userName);

}
