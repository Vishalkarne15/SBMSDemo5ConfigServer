package com.microservices.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.demo.entity.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUserId(Long userId);
	
}
