package com.userapi.mongodb.valueObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	private Long id;
	private String deptName;
	private String deptCode;

}
