package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.dto.*;
import com.tpcc.soccer.manager.entity.User;
import com.tpcc.soccer.manager.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponseWithId getUser(Integer id) {
        User user = userRepository.findById(id).get();
        return UserResponseWithId.builder().userId(user.getUserId()).userName(user.getUserName()).email(user.getEmail()).build();
    }

    public UserResponse addUser(UserRequest request) {
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        User user = User.builder().userName(request.getUserName()).email(request.getEmail()).password(request.getPassword()).userCreateTime(createTime).userLastActiveTime(createTime).build();
        User newUser = userRepository.save(user);
        return UserResponse.builder().userName(newUser.getUserName()).email(newUser.getEmail()).build();
    }

    public UserResponse deleteUser(Integer id) {
        User userToDelete = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return UserResponse.builder().userName(userToDelete.getUserName()).email(userToDelete.getEmail()).build();
    }

    public UserResponse updateUser(UserRequestWithoutPw request, Integer id) {
        User updateUser = userRepository.findById(id).get();
        updateUser.setUserName(request.getUserName());
        updateUser.setEmail(request.getEmail());
        userRepository.save(updateUser);
        return UserResponse.builder().userName(updateUser.getUserName()).email(updateUser.getEmail()).build();
    }

    public VerifyLoginResponse verifyLoginUser(LoginRequest request) {
        Specification<User> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(request.getEmail())) {
                Expression<String> currentItemDisplayName = root.get("email");
                predicates.add(criteriaBuilder.equal(currentItemDisplayName, request.getEmail()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        User user;
        VerifyLoginResponse verifyLoginResponse = new VerifyLoginResponse();

        try {
            user = userRepository.findAll(specification).get(0);
        }
        catch (Exception e){
            verifyLoginResponse.setErrorMessage("User doesn't exist!");
            verifyLoginResponse.setStatusCode(2);
            return verifyLoginResponse;
        }

        if (request.getPassword().compareTo(user.getPassword()) == 0) {
            verifyLoginResponse.setErrorMessage("Login Successful!");
            verifyLoginResponse.setStatusCode(0);
            verifyLoginResponse.setUserId(user.getUserId());
            verifyLoginResponse.setUserName(user.getUserName());
            verifyLoginResponse.setEmail(user.getEmail());
        }
        else {
            verifyLoginResponse.setErrorMessage("User's password doesn't match!");
            verifyLoginResponse.setStatusCode(1);
        }
        return verifyLoginResponse;
    }

    public UserResponse activeUser(UpdateUserRequest request, Integer id) {
        User activeUser = userRepository.findById(id).get();
        Timestamp timestamp = new Timestamp((System.currentTimeMillis()));
        activeUser.setUserLastActiveTime(timestamp);
        userRepository.save(activeUser);
        return UserResponse.builder().lastActive(activeUser.getUserLastActiveTime()).build();
    }

    public UserListResponse searchUser(String name) {
        List<User> users = userRepository.findAll();
        List<User> usersFound = new ArrayList<>();
        for (User user : users) {
            if (user.getUserName().toLowerCase().contains(name.toLowerCase())) {
                usersFound.add(user);
            }
        }

        List<UserResponseWithId> userResponses = new ArrayList<>();
        for (User user : usersFound) {
            userResponses.add(UserResponseWithId.builder().userId(user.getUserId()).userName(user.getUserName()).
                    email(user.getEmail()).build());
        }

        return UserListResponse.builder().userResponses(userResponses).build();
    }
}