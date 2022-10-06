package com.userapi.mongodb.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shashi.exception.UserNotFoundException;
import com.userapi.mongodb.models.User;
import com.userapi.mongodb.repository.UserRepository;
import com.userapi.mongodb.valueObject.Department;
import com.userapi.mongodb.valueObject.ResponseObject;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${department.api.path}")
	private String url; 
	
	public User addUser(User user) {
		return repo.insert(user);
	}
	
	public List<ResponseObject> getAllUsers() {
		List<ResponseObject> usersList = new ArrayList<>();
		List<User> users = repo.findAll();
		Iterator<User> itr = users.listIterator();
		while(itr.hasNext())
		{
			User user = itr.next();
			Department dept = restTemplate.getForObject(url+user.getDepartmentId(), Department.class);
			ResponseObject responseObject = new ResponseObject(user, dept);
			usersList.add(responseObject);
		}		
		return usersList;
	}
	
	public ResponseObject getUserById(String id) {
		
		User user = repo.findById(id)
				.orElseThrow(()->new UserNotFoundException("No User Found With ID: "+id));
		Department dept = restTemplate.getForObject(url+user.getDepartmentId(), Department.class);
		
		return new ResponseObject(user, dept);
		
	}
	
	
	public ResponseEntity<Object> deleteUser(String id) {
		User user = repo.findById(id)
					.orElseThrow(() -> new UserNotFoundException("No User Found With Id : "+id));
		
		repo.delete(user);
		return ResponseEntity.noContent().build();
	}
	
	public User updateUser(String id, User newUser) {
		User savedUser = repo.findById(id)
							.orElseThrow(
									() -> new UserNotFoundException(String.format("No User Found With Id : %s ",id))
									);
		
		savedUser.setName(newUser.getName());
		savedUser.setCity(newUser.getCity());
		savedUser.setDepartmentId(newUser.getDepartmentId());
		
		return repo.save(savedUser);
	}

	

}
