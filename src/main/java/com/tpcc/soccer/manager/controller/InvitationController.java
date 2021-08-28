package com.tpcc.soccer.manager.controller;

import com.tpcc.soccer.manager.dto.*;
import com.tpcc.soccer.manager.entity.Invitation;
import com.tpcc.soccer.manager.service.InvitationService;
import com.tpcc.soccer.manager.service.TeamService;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class InvitationController {
    @Autowired
    private InvitationService invitationService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/invitation")
    public ResponseEntity<InvitationResponse> getInvitation(@RequestHeader("invitationId") int id) {
        return new ResponseEntity<>(invitationService.getInvitation(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/invitation")
    public ResponseEntity<InvitationResponse> deleteInvitation(@RequestHeader("invitationId") int id) {
        return new ResponseEntity<>(invitationService.deleteInvitation(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/invitation")
    public ResponseEntity<InvitationResponse> addInvitation(@RequestBody InvitationRequest ir) {
        return new ResponseEntity<>(invitationService.addInvitation(ir), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getUserInvitation")
    public ResponseEntity<InvitationListResponse> getUserInvitation(@RequestHeader("invitationId") int id) {
        return new ResponseEntity<>(invitationService.getUserInvitation(id), HttpStatus.OK);
    }
}
