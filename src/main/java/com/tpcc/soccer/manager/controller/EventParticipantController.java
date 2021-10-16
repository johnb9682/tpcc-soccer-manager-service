package com.tpcc.soccer.manager.controller;

import com.tpcc.soccer.manager.dto.*;
import com.tpcc.soccer.manager.exceptions.HostException;
import com.tpcc.soccer.manager.service.EventParticipantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class EventParticipantController {
    @Autowired
    private EventParticipantService eventParticipantService;

    @CrossOrigin
    @RequestMapping(method=RequestMethod.GET, value="/eventParticipant")
    public ResponseEntity<ParticipantListResponse> getEventParticipants (@RequestHeader("eventId") int id) {
        return new ResponseEntity<>(eventParticipantService.getParticipant(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method=RequestMethod.DELETE, value="/eventParticipant")
    public ResponseEntity<EventParticipantResponse> deleteParticipant (@RequestHeader("userId") int userId,
                                                                       @RequestHeader("eventId") int eventId) throws HostException {
        return new ResponseEntity<>(eventParticipantService.deleteParticipant(userId, eventId), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method=RequestMethod.POST, value="/eventParticipant")
    public ResponseEntity<EventParticipantResponse> addParticipant (@RequestHeader("userId") int userId, @RequestHeader("eventId") int eventId,
                                                        @RequestHeader("isHost") int isHost) {
        return new ResponseEntity<>(eventParticipantService.addEventParticipant(userId, eventId, isHost), HttpStatus.OK);
    }

}
