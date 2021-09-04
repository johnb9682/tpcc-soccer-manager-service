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

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/event")
    public ResponseEntity<EventResponse> getEvent(@RequestHeader("eventId") int id) {
        return new ResponseEntity<>(eventService.getEvent(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/event")
    public ResponseEntity<EventResponse> deleteEvent(@RequestHeader("eventId") int id) {
        return new ResponseEntity<>(eventService.deleteEvent(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/event")
    public ResponseEntity<EventResponse> addEvent(@RequestBody EventRequest eventRequest) {
        return new ResponseEntity<>(eventService.addEvent(eventRequest), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/event")
    public ResponseEntity<EventResponse> updateEvent(@RequestBody UpdateEventRequest eventRequest) {
        return new ResponseEntity<>(eventService.updateEvent(eventRequest, eventRequest.getId()), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getUserEvent")
    public ResponseEntity<EventListResponse> getUserEvent(@RequestHeader("userId") int id) {
        return new ResponseEntity<>(eventService.getUserEvent(id), HttpStatus.OK);
    }
}
