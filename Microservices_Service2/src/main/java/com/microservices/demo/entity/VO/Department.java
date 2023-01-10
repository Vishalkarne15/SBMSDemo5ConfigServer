package com.microservices.demo.entity.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

	@Id
	@SequenceGenerator(name="SEQ_DEPARTMENT",catalog = "SEQ_DEPARTMENT", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_DEPARTMENT", strategy = GenerationType.AUTO)
	@Column(name="DEPARTMENTID")
	private Long departmentId;
	@Column(name="DEPARTMENTNAME")
	private String departmentName;
	@Column(name="DEPARTMENTADDRESS")
	private String departmentAddress;
	@Column(name="DEPARTMENTCODE")
	private String departmentCode;
	
}
