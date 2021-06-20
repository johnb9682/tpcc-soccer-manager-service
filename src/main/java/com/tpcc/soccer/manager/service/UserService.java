package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.User;
import com.tpcc.soccer.manager.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUser() {
        return userRepository.findById(1).get();
    }
}
