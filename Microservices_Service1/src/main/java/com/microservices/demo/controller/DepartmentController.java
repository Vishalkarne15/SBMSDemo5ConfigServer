package com.microservices.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.demo.entity.Department;
import com.microservices.demo.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	@PostMapping("/")
	public Department saveDepatment(@RequestBody Department department) {
		log.info("Start of saveDepatment of DepartmentController");
		return departmentService.saveDeparment(department);
		
	}
	
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long departmentById) {
		log.info("Start of findDepartmentById of DepartmentController");
		return departmentService.findDepartmentById(departmentById);
	}
	
	
	@GetMapping("/")
	public List<Department> findAllDepartments(){
		return departmentService.findAllDepartments();
	}
	
	@PostMapping("/deleteAll")
	public List<Department> deleteAllDepartment() {
		departmentService.deleteAllDepartments();
		return departmentService.findAllDepartments();
	}
}
