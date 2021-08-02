package com.tpcc.soccer.manager.controller;

import com.tpcc.soccer.manager.dto.LoginRequest;
import com.tpcc.soccer.manager.dto.UserRequest;
import com.tpcc.soccer.manager.dto.UserResponse;
import com.tpcc.soccer.manager.entity.User;
import com.tpcc.soccer.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getUser")
    public ResponseEntity<UserResponse> getUser(Integer id) {

        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest request) {

        return new ResponseEntity<>(userService.addUser(request), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser")
    public ResponseEntity<UserResponse> deleteUser(Integer id) {

        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/updateUser")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest request, Integer id) {

        return new ResponseEntity<>(userService.updateUser(request, id), HttpStatus.OK);
    }

//    @CrossOrigin
//    @RequestMapping(method = RequestMethod.GET, value = "/getLoginUser")
//    public ResponseEntity<UserResponse> getLoginUser(@RequestBody LoginRequest request) {
//
//        return new ResponseEntity<>(userService.getLoginUser(request), HttpStatus.OK);
//    }
}
