package com.department.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.mongodb.repository.DepartmentRepo;
import com.departmentapi.mongodb.models.Department;
import com.shashi.exception.DepartmentNotFoundException;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepo repo;
	
	public Department getDepartmentById(Long id)
	{
		return repo.findById(id)
		.orElseThrow(()->new DepartmentNotFoundException("No Department Found With Id: "+id));
	}
	
	public Department saveDepartment(Department dept)
	{
		return repo.save(dept);
	}

	public List<Department> getAllDeprtments() {
		
		return repo.findAll();
	}

}
