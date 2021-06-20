package com.tpcc.soccer.manager.controller;

import com.tpcc.soccer.manager.dto.UserRequest;
import com.tpcc.soccer.manager.dto.UserResponse;
import com.tpcc.soccer.manager.entity.User;

import com.tpcc.soccer.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/getUser")
    public ResponseEntity<User> getUser() {

        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest request) {

        return new ResponseEntity<>(userService.addUser(request), HttpStatus.OK);
    }
}
