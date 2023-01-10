package com.microservices.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.microservices.demo.entity.Department;


@Repository("departmentRepository")
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	public Department findByDepartmentId(Long departmentById);

}
