package com.userapi.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.userapi.mongodb.models.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	@Query("{'username': ?0}")
	Optional<User> findByUsername(String Username);

}
