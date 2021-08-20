package com.tpcc.soccer.manager.controller;

import com.tpcc.soccer.manager.dto.TeamListResponse;
import com.tpcc.soccer.manager.dto.TeamRequest;
import com.tpcc.soccer.manager.dto.TeamResponse;
import com.tpcc.soccer.manager.dto.UpdateTeamRequest;
import com.tpcc.soccer.manager.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/team")
    public ResponseEntity<TeamResponse> getTeam(@RequestHeader("teamId") int id) {
        return new ResponseEntity<>(teamService.getTeam(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/team")
    public ResponseEntity<TeamResponse> deleteTeam(@RequestHeader("teamId") int id) {
        return new ResponseEntity<>(teamService.deleteTeam(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/team")
    public ResponseEntity<TeamResponse> addTeam(@RequestBody TeamRequest tr) {
        return new ResponseEntity<>(teamService.addTeam(tr), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/team")
    public ResponseEntity<TeamResponse> updateTeam(@RequestBody UpdateTeamRequest tr) {
        return new ResponseEntity<>(teamService.updateTeam(tr, tr.getId()), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getUserTeam")
    public ResponseEntity<TeamListResponse> getUserTeam(@RequestHeader("userId") int id) {
        return new ResponseEntity<>(teamService.getUserTeam(id), HttpStatus.OK);
    }
}
