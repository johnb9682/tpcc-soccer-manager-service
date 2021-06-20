package com.tpcc.soccer.manager;

import org.springframework.data.repository.CrudRepository;

import com.tpcc.soccer.manager.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}
