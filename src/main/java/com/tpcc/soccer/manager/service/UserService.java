package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.dto.UserRequest;
import com.tpcc.soccer.manager.entity.User;
import com.tpcc.soccer.manager.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser() {
        return userRepository.findById(1).get();
    }

    public User addUser(UserRequest request) {
        User user = User.builder().userName(request.getUserName() + "Jayking").email(request.getEmail()).password(request.getPassword()).build();
        return userRepository.save(user);
    }
}
