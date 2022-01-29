package com.tpcc.soccer.manager.controller;

import com.tpcc.soccer.manager.dto.*;
import com.tpcc.soccer.manager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getUser")
    public ResponseEntity<UserResponseWithId> getUser(@RequestHeader("userId") Integer id) {
        log.info("[UserController] getUser API Request: [{}]", id);
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest request) {
        log.info("[UserController] addUser API Request: [{}]", request);
        return new ResponseEntity<>(userService.addUser(request), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser")
    public ResponseEntity<UserResponse> deleteUser(@RequestHeader("userId") Integer id) {
        log.info("[UserController] deleteUser API Request: [{}]", id);
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/updateUser")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserRequest request) {
        log.info("[UserController] updateUser API Request: [{}]", request);
        return new ResponseEntity<>(userService.updateUser(request, request.getId()), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/verifyLoginUser")
    public ResponseEntity<VerifyLoginResponse> verifyLoginUser(@RequestBody LoginRequest request) {
        log.info("[UserController] verifyLoginUser API Request: [{}]", request);
        return new ResponseEntity<>(userService.verifyLoginUser(request), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/activeUser")
    public ResponseEntity<UserActiveResponse> activeUser(@RequestHeader("userId") Integer id) {
        log.info("[UserController] activeUser API Request: [{}]", id);
        return new ResponseEntity<>(userService.activeUser(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/searchUser")
    public ResponseEntity<UserListResponse> searchUser(@RequestHeader("name") String name) {
        log.info("[UserController] searchUser API Request: [{}]", name);
        return new ResponseEntity<>(userService.searchUser(name), HttpStatus.OK);
    }
}
