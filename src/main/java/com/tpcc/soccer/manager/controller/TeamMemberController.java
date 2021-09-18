package com.tpcc.soccer.manager.controller;


import com.tpcc.soccer.manager.dto.MemberListResponse;
import com.tpcc.soccer.manager.dto.TeamMemberResponse;
import com.tpcc.soccer.manager.exceptions.LeaderException;
import com.tpcc.soccer.manager.service.TeamMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
public class TeamMemberController {
    @Autowired
    TeamMemberService teamMemberService;

    @CrossOrigin
    @RequestMapping(method=RequestMethod.GET, value="/teamMembers")
    public ResponseEntity<MemberListResponse> getTeamMembers(@RequestHeader("teamId") int id) {
        return new ResponseEntity<>(teamMemberService.getMember(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method=RequestMethod.DELETE, value="/teamMember")
    public ResponseEntity<TeamMemberResponse> deleteMember(@RequestHeader("userId") int userId,
                                                           @RequestHeader("teamId") int teamId) throws LeaderException {
        return new ResponseEntity<>(teamMemberService.deleteMemberFromTeam(userId, teamId), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method=RequestMethod.POST, value="/teamMember")
    public ResponseEntity<TeamMemberResponse> addMember(@RequestHeader("userId") int userId, @RequestHeader("teamId") int teamId,
                                                       @RequestHeader("isLeader") int isLeader, @RequestHeader("isManager") int isManager) {
        return new ResponseEntity<>(teamMemberService.addTeamMember(userId, teamId, isLeader, isManager), HttpStatus.OK);
    }
}
