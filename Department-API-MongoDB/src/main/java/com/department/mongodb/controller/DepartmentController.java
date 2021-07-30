package com.department.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.mongodb.service.DepartmentService;
import com.departmentapi.mongodb.models.Department;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department dept)
	{
		return service.saveDepartment(dept);
	}
	
	@GetMapping("/")
	public List<Department> getAllDepartments()
	{
		return service.getAllDeprtments();
	}
	
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable Long id)
	{
		return service.getDepartmentById(id);
	}

}
