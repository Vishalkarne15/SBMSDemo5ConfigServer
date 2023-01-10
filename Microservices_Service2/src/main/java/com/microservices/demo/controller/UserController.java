package com.microservices.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.demo.entity.User;
import com.microservices.demo.entity.VO.ResponseTemplateVO;
import com.microservices.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	@Autowired private UserService userService;
	
	@PostMapping("/")
	public User saveDepatment(@RequestBody User user) {
		log.info("Start of saveDepatment of UserController");
		return userService.saveUser(user);
	}

	/*
	@GetMapping("/{id}")
	public User findUserById(@PathVariable("id") Long userId) {
		log.info("Start of findUserById of UserController");
		return userService.findUserById(userId);
	}
	*/
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		return userService.getUserWithDepartment(userId);
	}
	
	
	@GetMapping("/")
	public List<User> findAllUser(){
		return userService.findAllUser();
	}
	
	@PostMapping("/deleteAll")
	public List<User> deleteAllUser() {
		userService.deleteAllUser();
		return userService.findAllUser();
	}
}
