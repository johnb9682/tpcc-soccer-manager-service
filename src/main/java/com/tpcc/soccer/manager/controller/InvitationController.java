package com.tpcc.soccer.manager.controller;

import com.tpcc.soccer.manager.dto.*;
import com.tpcc.soccer.manager.service.EventParticipantService;
import com.tpcc.soccer.manager.service.InvitationService;
import com.tpcc.soccer.manager.service.TeamMemberService;
import io.swagger.models.Response;
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
    @Autowired
    private TeamMemberService teamMemberService;
    @Autowired
    private EventParticipantService eventParticipantService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getTeamInvitation")
    public ResponseEntity<InvitationTeamResponse> getTeamInvitation(@RequestHeader("invitationId") int id) {
        return new ResponseEntity<>(invitationService.getTeamInvitation(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getEventInvitation")
    public ResponseEntity<InvitationEventResponse> getEventInvitation(@RequestHeader("invitationId") int id) {
        return new ResponseEntity<>(invitationService.getEventInvitation(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteTeamInvitation")
    public ResponseEntity<InvitationTeamResponse> deleteTeamInvitation(@RequestHeader("invitationTeamId") int id) {
        return new ResponseEntity<>(invitationService.deleteTeamInvitation(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteEventInvitation")
    public ResponseEntity<InvitationEventResponse> deleteEventInvitation(@RequestHeader("invitationEventId") int id) {
        return new ResponseEntity<>(invitationService.deleteEventInvitation(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/addTeamInvitation")
    public ResponseEntity<InvitationListResponse> addEventInvitation(@RequestBody InvitationTeamPostRequest ir) {
        return new ResponseEntity<>(invitationService.addTeamInvitation(ir), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/addEventInvitation")
    public ResponseEntity<InvitationListResponse> addEventInvitation(@RequestBody InvitationEventPostRequest ir) {
        return new ResponseEntity<>(invitationService.addEventInvitation(ir), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getUserReceiverTeamInvitation")
    public ResponseEntity<InvitationListResponse> getUserReceiverTeamInvitation(@RequestHeader("userId") int id) {
        return new ResponseEntity<>(invitationService.getUserReceiverTeamInvitation(id), HttpStatus.OK);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getUserReceiverEventInvitation")
    public ResponseEntity<InvitationListResponse> getUserReceiverEventInvitation(@RequestHeader("userId") int id) {
        return new ResponseEntity<>(invitationService.getUserReceiverEventInvitation(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getUserSenderTeamInvitation")
    public ResponseEntity<InvitationListResponse> getUserSenderTeamInvitation(@RequestHeader("userId") int id) {
        return new ResponseEntity<>(invitationService.getUserSenderTeamInvitation(id), HttpStatus.OK);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getUserSenderEventInvitation")
    public ResponseEntity<InvitationListResponse> getUserSenderEventInvitation(@RequestHeader("userId") int id) {
        return new ResponseEntity<>(invitationService.getUserSenderEventInvitation(id), HttpStatus.OK);
    }

    //@CrossOrigin
    //@RequestMapping(method = RequestMethod.PUT, value = "/updateTeamInvitation")
    //public ResponseEntity<InvitationTeamResponse> updateTeamInvitation(@RequestBody UpdateInvitationRequest request) {
        //return new ResponseEntity<>(invitationService.updateTeamInvitation(request), HttpStatus.OK);
    //}

    //@CrossOrigin
    //@RequestMapping(method = RequestMethod.PUT, value = "/updateEventInvitation")
    //public ResponseEntity<InvitationEventResponse> updateEventInvitation(@RequestBody UpdateInvitationRequest request) {
        //return new ResponseEntity<>(invitationService.updateEventInvitation(request), HttpStatus.OK);
    //}

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/respondTeamInvitation")
    public ResponseEntity<InvitationTeamResponse> respondTeamInvitation(@RequestHeader int id,
                                                                        @RequestHeader int respondValue) {
        InvitationTeamResponse response = invitationService.getTeamInvitation(id);
        if (respondValue == 1){
            teamMemberService.addTeamMember(response.getReceiverId(), response.getTeamId(), 0, 0);
        }
        return new ResponseEntity<>(invitationService.respondTeamInvitation(response, respondValue), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/respondEventInvitation")
    public ResponseEntity<InvitationEventResponse> respondEventInvitation(@RequestHeader int id,
                                                                          @RequestHeader int respondValue) {
        InvitationEventResponse response = invitationService.getEventInvitation(id);
        if (respondValue == 1){
            eventParticipantService.addEventParticipant(response.getReceiverId(), response.getEventId(), 0);
        }
        return new ResponseEntity<>(invitationService.respondEventInvitation(response, respondValue), HttpStatus.OK);
    }


}
