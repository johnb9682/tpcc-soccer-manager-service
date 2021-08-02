package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.dto.LoginRequest;
import com.tpcc.soccer.manager.dto.UserRequest;
import com.tpcc.soccer.manager.dto.UserResponse;
import com.tpcc.soccer.manager.entity.User;
import com.tpcc.soccer.manager.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
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

    public UserResponse verifyLoginUser(LoginRequest request) {
        Specification<User> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(request.getEmail())) {
                Expression<String> currentItemDisplayName = root.get("email");
                predicates.add(criteriaBuilder.equal(currentItemDisplayName, request.getEmail()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        User user;
        UserResponse userResponse = new UserResponse();

        try {
            user = userRepository.findAll(specification).get(0);
        }
        catch (Exception e){
            userResponse.setErrorMessage("User doesn't exist!");
            userResponse.setStatusCode(2);
            return userResponse;
        }

        if (request.getPassword().compareTo(user.getPassword()) == 0) {
            userResponse.setErrorMessage("Login Successful!");
            userResponse.setStatusCode(0);
            userResponse.setUserName(user.getUserName());
            userResponse.setEmail(user.getEmail());
        }
        else {
            userResponse.setErrorMessage("User's password doesn't match!");
            userResponse.setStatusCode(1);
        }
        return userResponse;
    }
}
