package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.dao.EventParticipantRepository;
import com.tpcc.soccer.manager.dao.UserRepository;
import com.tpcc.soccer.manager.dto.ParticipantListResponse;
import com.tpcc.soccer.manager.dto.UserResponseWithId;
import com.tpcc.soccer.manager.entity.EventParticipant;
import com.tpcc.soccer.manager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventParticipantService {
    @Autowired
    private EventParticipantRepository eventParticipantRepository;
    @Autowired
    private UserRepository userRepository;

    public ParticipantListResponse getParticipant (int id) {
        List<EventParticipant> participants = (List<EventParticipant>) eventParticipantRepository.findAll();
        List<User> users = new ArrayList<>();

        for (EventParticipant ep : participants) {
            if (ep.getEventId() == id) {
                users.add(userRepository.findById(ep.getUserId()).get());
            }
        }

        List<UserResponseWithId> userResponses = new ArrayList<>();
        for (User user : users) {
            userResponses.add(UserResponseWithId.builder().userId(user.getUserId()).
                    userName(user.getUserName()).email(user.getEmail()).build());
        }

        return ParticipantListResponse.builder().userResponses(userResponses).build();
    }
}
