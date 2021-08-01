package com.tpcc.soccer.manager.controller;

import com.tpcc.soccer.manager.dto.TeamRequest;
import com.tpcc.soccer.manager.dto.TeamResponse;
import com.tpcc.soccer.manager.dto.UserRequest;
import com.tpcc.soccer.manager.dto.UserResponse;
import com.tpcc.soccer.manager.entity.Team;
import com.tpcc.soccer.manager.entity.User;

import com.tpcc.soccer.manager.service.TeamService;
import com.tpcc.soccer.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Autowired
    private UserService userService;
    private TeamService teamService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getUser")
    public ResponseEntity<UserResponse> getUser(int id) {

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
    @RequestMapping(method = RequestMethod.GET, value = "/team")
    public ResponseEntity<TeamResponse> getTeam(int id) {
        return new ResponseEntity<>(teamService.getTeam(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/team")
    public ResponseEntity<TeamResponse> deleteTeam(int id) {
        return new ResponseEntity<>(teamService.deleteTeam(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/team")
    public ResponseEntity<TeamResponse> addTeam(@RequestBody TeamRequest tr) {
        return new ResponseEntity<>(teamService.addTeam(tr), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/team")
    public ResponseEntity<TeamResponse> updateTeam(@RequestBody TeamRequest tr, int id) {
        return new ResponseEntity<>(teamService.updateTeam(tr, id), HttpStatus.OK);
    }
}
