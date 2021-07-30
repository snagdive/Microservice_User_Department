package com.department.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.departmentapi.mongodb.models.Department;

@Repository
public interface DepartmentRepo extends MongoRepository<Department, Long> {

}
