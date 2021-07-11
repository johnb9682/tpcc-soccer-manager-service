package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.dto.UserRequest;
import com.tpcc.soccer.manager.dto.UserResponse;
import com.tpcc.soccer.manager.entity.User;
import com.tpcc.soccer.manager.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }

    public UserResponse addUser(UserRequest request) {
        User user = User.builder().userName(request.getUserName() + "Jayking").email(request.getEmail()).password(request.getPassword()).build();
        User newUser = userRepository.save(user);
        return UserResponse.builder().userName(newUser.getUserName()).email(newUser.getEmail()).build();
    }

    public User deleteUser(Integer id) {
        User userToDelete = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return userToDelete;
    }
}
