package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.dao.EventParticipantRepository;
import com.tpcc.soccer.manager.dao.EventRepository;
import com.tpcc.soccer.manager.dto.*;
import com.tpcc.soccer.manager.entity.Event;
import com.tpcc.soccer.manager.entity.EventParticipant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventParticipantRepository eventParticipantRepository;

    public EventResponse getEvent(int id) {
        Event event = eventRepository.findById(id).get();
        return EventResponse.builder().eventName(event.getEventName()).eventId(event.getEventId()).
                eventDescription(event.getEventDescription()).hostId(event.getUserId()).eventStartTime(event.getEventStartTime()).
                eventEndTime(event.getEventEndTime()).eventLocation(event.getEventLocation()).createTime(event.getEventCreateTime()).build();
    }

    public EventResponse addEvent(EventRequest eventRequest){
        Timestamp createTime = new Timestamp((System.currentTimeMillis()/1000)*1000L);
        Timestamp eventStartTime = new Timestamp(eventRequest.getEventStartTime()* 1000L);
        Timestamp eventEndTime = new Timestamp(eventRequest.getEventStartTime()* 1000L);
        Event event = Event.builder().eventName(eventRequest.getEventName()).userId(eventRequest.getHostId()).
                eventStartTime(eventStartTime).eventEndTime(eventEndTime).
                eventLocation(eventRequest.getEventLocation()).
                eventDescription(eventRequest.getEventDescription()).eventCreateTime(createTime).build();
        Event newEvent = eventRepository.save(event);
        return EventResponse.builder().eventName(newEvent.getEventName()).
                eventDescription(newEvent.getEventDescription()).eventStartTime(newEvent.getEventStartTime()).
                eventEndTime(newEvent.getEventEndTime()).eventLocation(newEvent.getEventLocation()).
                createTime(newEvent.getEventCreateTime()).hostId(event.getUserId()).eventId(event.getEventId()).build();
    }

    public EventResponse deleteEvent(int id){
        Event event = eventRepository.findById(id).get();
        eventRepository.deleteById(id);
        return EventResponse.builder().eventName(event.getEventName()).eventId(event.getEventId()).
                eventDescription(event.getEventDescription()).hostId(event.getUserId()).eventStartTime(event.getEventStartTime()).
                eventEndTime(event.getEventEndTime()).eventLocation(event.getEventLocation()).createTime(event.getEventCreateTime()).build();
    }

    public EventResponse updateEvent(EventRequest eventRequest, int id){
        Timestamp eventStartTime = new Timestamp(eventRequest.getEventStartTime()* 1000L);
        Timestamp eventEndTime = new Timestamp(eventRequest.getEventStartTime()* 1000L);
        Event event = eventRepository.findById(id).get();
        event.setEventName(eventRequest.getEventName());
        event.setEventStartTime(eventStartTime);
        event.setEventEndTime(eventEndTime);
        event.setEventLocation(eventRequest.getEventLocation());
        event.setEventDescription(eventRequest.getEventDescription());
        event.setUserId(eventRequest.getHostId());
        eventRepository.save(event);
        return EventResponse.builder().eventName(event.getEventName()).eventId(event.getEventId()).
                eventDescription(event.getEventDescription()).hostId(event.getUserId()).eventStartTime(event.getEventStartTime()).
                eventEndTime(event.getEventEndTime()).eventLocation(event.getEventLocation()).createTime(event.getEventCreateTime()).build();
    }

    public EventListResponse getUserEvent(int id) {
        List<EventParticipant> eventParticipants = (List<EventParticipant>) eventParticipantRepository.findAll();
        List<Event> events = new ArrayList<>();
        for (EventParticipant eventParticipant : eventParticipants) {
            if (eventParticipant.getUserId() == id) {
                events.add(eventRepository.findById(eventParticipant.getEventId()).get());
            }
        }

        List<EventResponse> eventResponses = new ArrayList<>();
        for (Event event : events) {
            eventResponses.add(EventResponse.builder().eventName(event.getEventName()).eventId(event.getEventId()).
                    eventDescription(event.getEventDescription()).hostId(event.getUserId()).eventStartTime(event.getEventStartTime()).
                    eventEndTime(event.getEventEndTime()).eventLocation(event.getEventLocation()).createTime(event.getEventCreateTime()).build());
        }

        return EventListResponse.builder().eventResponses(eventResponses).build();
    }
}
