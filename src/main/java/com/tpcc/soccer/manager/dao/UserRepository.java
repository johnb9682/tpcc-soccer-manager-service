package com.tpcc.soccer.manager.dao;

import com.tpcc.soccer.manager.dto.UserRequest;
import org.springframework.data.repository.CrudRepository;

import com.tpcc.soccer.manager.entity.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}
