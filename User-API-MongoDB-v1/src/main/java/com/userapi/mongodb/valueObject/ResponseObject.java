package com.userapi.mongodb.valueObject;

import com.userapi.mongodb.models.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseObject {
	
	private User user;
	private Department department;

}
