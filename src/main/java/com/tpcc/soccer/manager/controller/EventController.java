package com.tpcc.soccer.manager.controller;

import com.tpcc.soccer.manager.dto.*;
import com.tpcc.soccer.manager.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventService teamService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/team")
    public ResponseEntity<EventResponse> getEvent(@RequestHeader("teamId") int id) {
        return new ResponseEntity<>(teamService.getEvent(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/team")
    public ResponseEntity<EventResponse> deleteEvent(@RequestHeader("teamId") int id) {
        return new ResponseEntity<>(teamService.deleteEvent(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/team")
    public ResponseEntity<EventResponse> addEvent(@RequestBody EventRequest eventRequest) {
        return new ResponseEntity<>(teamService.addEvent(eventRequest), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/team")
    public ResponseEntity<EventResponse> updateEvent(@RequestBody UpdateEventRequest eventRequest) {
        return new ResponseEntity<>(teamService.updateEvent(eventRequest, eventRequest.getId()), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getUserEvent")
    public ResponseEntity<EventListResponse> getUserEvent(@RequestHeader("userId") int id) {
        return new ResponseEntity<>(teamService.getUserEvent(id), HttpStatus.OK);
    }
}
