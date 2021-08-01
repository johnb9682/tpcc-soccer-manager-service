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
public class UpdateController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ResponseEntity<User> update(@RequestBody UserRequest request, Integer id) {

        return new ResponseEntity<>(userService.update(request, id), HttpStatus.OK);
    }
}
