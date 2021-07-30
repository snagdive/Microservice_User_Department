package com.departmentapi.mongodb.models;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	@Id
	private Long id;
	private String deptName;
	private String deptCode;
	

}
