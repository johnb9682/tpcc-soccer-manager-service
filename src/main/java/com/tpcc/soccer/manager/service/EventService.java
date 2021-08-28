package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.dao.EventParticipantRepository;
import com.tpcc.soccer.manager.dao.EventRepository;
import com.tpcc.soccer.manager.dto.EventListResponse;
import com.tpcc.soccer.manager.dto.EventRequest;
import com.tpcc.soccer.manager.dto.EventResponse;
import com.tpcc.soccer.manager.entity.Event;
import com.tpcc.soccer.manager.entity.EventParticipant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventParticipantRepository eventParticipantRepository;

    public EventResponse getEvent(int id) {
        Event event = eventRepository.findById(id).get();
        return EventResponse.builder().event_name(event.getEventName()).
                event_description(event.getEventDescription()).creater_id(event.getUserId()).build();
    }

    public EventResponse addEvent(EventRequest eventRequest){
        Event event = Event.builder().eventName(eventRequest.getEvent_name()).
                eventDescription(eventRequest.getEvent_description()).userId(eventRequest.getHost_id()).build();
        Event newEvent = eventRepository.save(event);
        return EventResponse.builder().event_name(newEvent.getEventName()).
                event_description(newEvent.getEventDescription()).creater_id(event.getUserId()).build();
    }

    public EventResponse deleteEvent(int id){
        Event event = eventRepository.findById(id).get();
        eventRepository.deleteById(id);
        return EventResponse.builder().event_name(event.getEventName()).
                event_description(event.getEventDescription()).creater_id(event.getUserId()).build();
    }

    public EventResponse updateEvent(EventRequest eventRequest, int id){
        Event event = eventRepository.findById(id).get();
        event.setEventName(eventRequest.getEvent_name());
        event.setEventDescription(eventRequest.getEvent_description());
        event.setUserId(eventRequest.getHost_id());
        eventRepository.save(event);
        return EventResponse.builder().event_name(event.getEventName()).
                event_description(event.getEventDescription()).creater_id(event.getUserId()).build();
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
            eventResponses.add(EventResponse.builder().event_name(event.getEventName()).
                    event_description(event.getEventDescription()).creater_id(event.getUserId()).build());
        }

        return EventListResponse.builder().eventResponses(eventResponses).build();
    }
}
