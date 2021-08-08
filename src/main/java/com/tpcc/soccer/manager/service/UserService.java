package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.dto.LoginRequest;
import com.tpcc.soccer.manager.dto.UserRequest;
import com.tpcc.soccer.manager.dto.UserResponse;
import com.tpcc.soccer.manager.dto.VerifyLoginResponse;
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
            verifyLoginResponse.setUserName(user.getUserName());
            verifyLoginResponse.setEmail(user.getEmail());
        }
        else {
            verifyLoginResponse.setErrorMessage("User's password doesn't match!");
            verifyLoginResponse.setStatusCode(1);
        }
        return verifyLoginResponse;
    }
}
