package com.microservices.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.demo.entity.Department;
import com.microservices.demo.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	
	public Department saveDeparment(Department department) {
		log.info("Start of saveDepatment of DepartmentService");
		return departmentRepository.save(department);
	}


	public Department findDepartmentById(Long departmentById) {
		log.info("Start of findDepartmentById of DepartmentService");
		return departmentRepository.findByDepartmentId(departmentById);
	}


	public List<Department> findAllDepartments() {
		// TODO Auto-generated method stub
		
		
		return departmentRepository.findAll();
	}
	
	public void deleteAllDepartments() {
		 departmentRepository.deleteAll();;
	}
	
	
}
