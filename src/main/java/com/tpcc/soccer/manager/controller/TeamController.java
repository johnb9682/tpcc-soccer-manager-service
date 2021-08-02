package com.tpcc.soccer.manager.controller;

import com.tpcc.soccer.manager.dto.TeamRequest;
import com.tpcc.soccer.manager.dto.TeamResponse;
import com.tpcc.soccer.manager.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class TeamController {
    private TeamService teamService;

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
