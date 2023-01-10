package com.microservices.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.demo.entity.User;
import com.microservices.demo.entity.VO.Department;
import com.microservices.demo.entity.VO.ResponseTemplateVO;
import com.microservices.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;


@Service("userService")
@Slf4j
public class UserService {

	@Autowired private UserRepository userRepository;
	
	@Autowired private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Start of saveUser of UserService");
		userRepository.save(user);
		log.info("End of saveUser of UserService");
		return user;
	}

	public User findUserById(Long userId) {
		//userRepository.findByUserId(userId);
		log.info("Start of findUserById of UserService");
		return userRepository.findByUserId(userId);
	}

	public List<User> findAllUser() {
		log.info("Start of findAllUser of UserService");
		return userRepository.findAll();
	}

	public void deleteAllUser() {
		log.info("Start of deleteAllUser of UserService");
		userRepository.deleteAll();
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Start of getUserWithDepartment of UserService");
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		responseTemplateVO.setUser(user);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICES/MicroService1/department/"+user.getUserId(), Department.class);
		//Department department = null;
		//Department department = restTemplate.getForObject("http://localhost:9501/MicroService1/department/"+user.getUserId(), Department.class);
		responseTemplateVO.setDepartment(department);
		log.info("End of getUserWithDepartment of UserService");
		return responseTemplateVO;
	}
	
	
	
	
}
