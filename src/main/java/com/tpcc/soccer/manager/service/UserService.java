package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.dto.LoginRequest;
import com.tpcc.soccer.manager.dto.UserRequest;
import com.tpcc.soccer.manager.dto.UserResponse;
import com.tpcc.soccer.manager.entity.User;
import com.tpcc.soccer.manager.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponse getUser(Integer id) {
        User user = userRepository.findById(id).get();
        return UserResponse.builder().userName(user.getUserName()).email(user.getEmail()).build();
    }

    public UserResponse addUser(UserRequest request) {
        User user = User.builder().userName(request.getUserName()).email(request.getEmail()).password(request.getPassword()).build();
        User newUser = userRepository.save(user);
        return UserResponse.builder().userName(newUser.getUserName()).email(newUser.getEmail()).build();
    }

    public UserResponse deleteUser(Integer id) {
        User userToDelete = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return UserResponse.builder().userName(userToDelete.getUserName()).email(userToDelete.getEmail()).build();
    }

    public UserResponse updateUser(UserRequest request, Integer id) {
        User updateUser = userRepository.findById(id).get();
        updateUser.setUserName(request.getUserName());
        updateUser.setEmail(request.getEmail());
        userRepository.save(updateUser);
        return UserResponse.builder().userName(updateUser.getUserName()).email(updateUser.getEmail()).build();
    }

//    public UserResponse getLoginUser(LoginRequest request) {
//        User user = userRepository.findByEmailAndPassword(request.getEmail(), request.getPassword());
//        return UserResponse.builder().userName(user.getUserName()).email(user.getEmail()).build();
//    }
}
