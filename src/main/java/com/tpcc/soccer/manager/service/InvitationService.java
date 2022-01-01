package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.dao.*;
import com.tpcc.soccer.manager.dto.*;
import com.tpcc.soccer.manager.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvitationService {
    @Autowired
    private InvitationTeamRepository invitationTeamRepository;
    @Autowired
    private InvitationEventRepository invitationEventRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private EventRepository eventRepository;

    public InvitationTeamResponse getTeamInvitation(int id) {
        InvitationTeam invitation = invitationTeamRepository.findById(id).get();
        User sender = userRepository.findById(invitation.getSenderId()).get();
        String senderName = sender.getUserName();
        Team team = teamRepository.findById(invitation.getTeamId()).get();
        String teamName = team.getTeamName();
        User receiver = userRepository.findById(invitation.getReceiverId()).get();
        String receiverName = receiver.getUserName();
        return InvitationTeamResponse.builder().senderId(invitation.getSenderId()).senderName(senderName).
                receiverId(invitation.getReceiverId()).receiverName(receiverName).invitationId(id).
                teamId(invitation.getTeamId()).teamName(teamName).status(invitation.getStatus()).
                createTime(invitation.getCreateTime()).responseTime(invitation.getResponseTime()).build();
    }
    public InvitationEventResponse getEventInvitation(int id) {
        InvitationEvent invitation = invitationEventRepository.findById(id).get();
        User sender = userRepository.findById(invitation.getSenderId()).get();
        String senderName = sender.getUserName();
        Event event = eventRepository.findById(invitation.getEventId()).get();
        String eventName = event.getEventName();
        User receiver = userRepository.findById(invitation.getReceiverId()).get();
        String receiverName = receiver.getUserName();
        return InvitationEventResponse.builder().senderId(invitation.getSenderId()).senderName(senderName).
                receiverId(invitation.getReceiverId()).receiverName(receiverName).invitationId(id).
                eventId(invitation.getEventId()).eventName(eventName).status(invitation.getStatus()).
                createTime(invitation.getCreateTime()).responseTime(invitation.getResponseTime()).build();
}

    public InvitationListResponse addTeamInvitation(InvitationTeamPostRequest ir){
        Timestamp createTime = new Timestamp((System.currentTimeMillis()/1000)*1000L);
        List<Integer> receiverIds = ir.getReceiverIds();
        Integer senderId = ir.getSenderId();
        User sender = userRepository.findById(senderId).get();
        String senderName = sender.getUserName();
        Team team = teamRepository.findById(ir.getTeamId()).get();
        String teamName = team.getTeamName();
        List<InvitationTeamResponse> invitationTeamResponses = new ArrayList<>();
        for (int receiverId : receiverIds){
            User receiver = userRepository.findById(receiverId).get();
            String receiverName = receiver.getUserName();
            InvitationTeam invitation = InvitationTeam.builder().teamId(ir.getTeamId()).senderId(ir.getSenderId()).
                    receiverId(receiverId).status(0).createTime(createTime).build();
            InvitationTeam newInvitation = invitationTeamRepository.save(invitation);
            invitationTeamResponses.add(InvitationTeamResponse.builder().invitationId(newInvitation.getInvitationId()).
                    teamId(newInvitation.getTeamId()).teamName(teamName).senderId(newInvitation.getSenderId()).senderName(senderName).
                    receiverId(newInvitation.getReceiverId()).receiverName(receiverName).status(newInvitation.getStatus()).
                    createTime(newInvitation.getCreateTime()).build());
        }
        return InvitationListResponse.builder().invitationTeamResponses(invitationTeamResponses).build();
    }

    public InvitationListResponse addEventInvitation(InvitationEventPostRequest ir){
        Timestamp createTime = new Timestamp((System.currentTimeMillis()/1000)*1000L);
        List<Integer> receiverIds = ir.getReceiverIds();
        Integer senderId = ir.getSenderId();
        User sender = userRepository.findById(senderId).get();
        String senderName = sender.getUserName();
        Event event = eventRepository.findById(ir.getEventId()).get();
        String eventName = event.getEventName();
        List<InvitationEventResponse> invitationEventResponses = new ArrayList<>();
        for (int receiverId : receiverIds){
            User receiver = userRepository.findById(receiverId).get();
            String receiverName = receiver.getUserName();
            InvitationEvent invitation = InvitationEvent.builder().eventId(ir.getEventId()).senderId(ir.getSenderId()).
                    receiverId(receiverId).status(0).createTime(createTime).build();
            InvitationEvent newInvitation = invitationEventRepository.save(invitation);
            invitationEventResponses.add(InvitationEventResponse.builder().invitationId(newInvitation.getInvitationId()).
                    eventId(newInvitation.getEventId()).eventName(eventName).senderId(newInvitation.getSenderId()).senderName(senderName).
                    receiverId(newInvitation.getReceiverId()).receiverName(receiverName).status(newInvitation.getStatus()).
                    createTime(newInvitation.getCreateTime()).build());
        }
        return InvitationListResponse.builder().invitationEventResponses(invitationEventResponses).build();
    }

    public InvitationTeamResponse deleteTeamInvitation(int id){
        InvitationTeam invitation = invitationTeamRepository.findById(id).get();
        User sender = userRepository.findById(invitation.getSenderId()).get();
        String senderName = sender.getUserName();
        Team team = teamRepository.findById(invitation.getTeamId()).get();
        String teamName = team.getTeamName();
        User receiver = userRepository.findById(invitation.getReceiverId()).get();
        String receiverName = receiver.getUserName();
        invitationTeamRepository.deleteById(id);
        return InvitationTeamResponse.builder().invitationId(id).teamId(invitation.getTeamId()).teamName(teamName).
                senderId(invitation.getSenderId()).senderName(senderName).receiverId(invitation.getReceiverId()).receiverName(receiverName).
                status(invitation.getStatus()).build();
    }
    public InvitationEventResponse deleteEventInvitation(int id){
        InvitationEvent invitation = invitationEventRepository.findById(id).get();
        User sender = userRepository.findById(invitation.getSenderId()).get();
        String senderName = sender.getUserName();
        Event event = eventRepository.findById(invitation.getEventId()).get();
        String eventName = event.getEventName();
        User receiver = userRepository.findById(invitation.getReceiverId()).get();
        String receiverName = receiver.getUserName();
        invitationEventRepository.deleteById(id);
        return InvitationEventResponse.builder().invitationId(id).eventId(invitation.getEventId()).eventName(eventName).
                senderId(invitation.getSenderId()).senderName(senderName).receiverId(invitation.getReceiverId()).receiverName(receiverName).
                status(invitation.getStatus()).build();

    }

    public InvitationListResponse getUserReceiverTeamInvitation(int id){
        User receiver = userRepository.findById(id).get();
        String receiverName = receiver.getUserName();
        List<InvitationTeam> invitations = (List<InvitationTeam>) invitationTeamRepository.findAll();
        List<InvitationTeam> invitationList = new ArrayList<>();
        for (InvitationTeam invitation : invitations) {
            if (invitation.getReceiverId() == id) {
                invitationList.add(invitationTeamRepository.findById(invitation.getInvitationId()).get());
            }
        }
        List<InvitationTeamResponse> invitationTeamResponses = new ArrayList<>();
        for (InvitationTeam invitation : invitationList){
            User sender = userRepository.findById(invitation.getSenderId()).get();
            String senderName = sender.getUserName();
            Team team = teamRepository.findById(invitation.getTeamId()).get();
            String teamName = team.getTeamName();
            invitationTeamResponses.add(InvitationTeamResponse.builder().invitationId(invitation.getInvitationId()).
                    teamId(invitation.getTeamId()).teamName(teamName).senderId(invitation.getSenderId()).senderName(senderName).
                    receiverId(invitation.getReceiverId()).receiverName(receiverName).status(invitation.getStatus()).
                    createTime(invitation.getCreateTime()).build());
        }
        return InvitationListResponse.builder().invitationTeamResponses(invitationTeamResponses).build();
    }

    public InvitationListResponse getUserReceiverEventInvitation(int id){
        User receiver = userRepository.findById(id).get();
        String receiverName = receiver.getUserName();
        List<InvitationEvent> invitations = (List<InvitationEvent>) invitationEventRepository.findAll();
        List<InvitationEvent> invitationList = new ArrayList<>();
        for (InvitationEvent invitation : invitations) {
            if (invitation.getReceiverId() == id) {
                invitationList.add(invitationEventRepository.findById(invitation.getInvitationId()).get());
            }
        }

        List<InvitationEventResponse> invitationEventResponses = new ArrayList<>();
        for (InvitationEvent invitation : invitationList) {
            User sender = userRepository.findById(invitation.getSenderId()).get();
            String senderName = sender.getUserName();
            Event event = eventRepository.findById(invitation.getEventId()).get();
            String eventName = event.getEventName();
            invitationEventResponses.add(InvitationEventResponse.builder().invitationId(invitation.getInvitationId()).
                    eventId(invitation.getEventId()).eventName(eventName).senderId(invitation.getSenderId()).senderName(senderName).
                    receiverId(invitation.getReceiverId()).receiverName(receiverName).status(invitation.getStatus()).
                    createTime(invitation.getCreateTime()).build());
        }
        return InvitationListResponse.builder().invitationEventResponses(invitationEventResponses).build();
    }

    public InvitationListResponse getUserSenderTeamInvitation(int id){
        User sender = userRepository.findById(id).get();
        String senderName = sender.getUserName();
        List<InvitationTeam> invitations = (List<InvitationTeam>) invitationTeamRepository.findAll();
        List<InvitationTeam> invitationList = new ArrayList<>();
        for (InvitationTeam invitation : invitations) {
            if (invitation.getSenderId() == id) {
                invitationList.add(invitationTeamRepository.findById(invitation.getInvitationId()).get());
            }
        }
        List<InvitationTeamResponse> invitationTeamResponses = new ArrayList<>();
        for (InvitationTeam invitation : invitationList){
            User receiver = userRepository.findById(invitation.getReceiverId()).get();
            String receiverName = receiver.getUserName();
            Team team = teamRepository.findById(invitation.getTeamId()).get();
            String teamName = team.getTeamName();
            invitationTeamResponses.add(InvitationTeamResponse.builder().invitationId(invitation.getInvitationId()).
                    teamId(invitation.getTeamId()).teamName(teamName).senderId(invitation.getSenderId()).senderName(senderName).
                    receiverId(invitation.getReceiverId()).receiverName(receiverName).status(invitation.getStatus()).
                    createTime(invitation.getCreateTime()).build());
        }
        return InvitationListResponse.builder().invitationTeamResponses(invitationTeamResponses).build();
    }

    public InvitationListResponse getUserSenderEventInvitation(int id){
        User sender = userRepository.findById(id).get();
        String senderName = sender.getUserName();
        List<InvitationEvent> invitations = (List<InvitationEvent>) invitationEventRepository.findAll();
        List<InvitationEvent> invitationList = new ArrayList<>();
        for (InvitationEvent invitation : invitations) {
            if (invitation.getSenderId() == id) {
                invitationList.add(invitationEventRepository.findById(invitation.getInvitationId()).get());
            }
        }

        List<InvitationEventResponse> invitationEventResponses = new ArrayList<>();
        for (InvitationEvent invitation : invitationList) {
            User receiver = userRepository.findById(invitation.getReceiverId()).get();
            String receiverName = receiver.getUserName();
            Event event = eventRepository.findById(invitation.getEventId()).get();
            String eventName = event.getEventName();
            invitationEventResponses.add(InvitationEventResponse.builder().invitationId(invitation.getInvitationId()).
                    eventId(invitation.getEventId()).eventName(eventName).senderId(invitation.getSenderId()).senderName(senderName).
                    receiverId(invitation.getReceiverId()).receiverName(receiverName).status(invitation.getStatus()).
                    createTime(invitation.getCreateTime()).build());
        }
        return InvitationListResponse.builder().invitationEventResponses(invitationEventResponses).build();
    }


    public InvitationTeamResponse respondTeamInvitation(InvitationTeamResponse request, int respondValue) {
        Timestamp responseTime = new Timestamp((System.currentTimeMillis()/1000)*1000L);
        InvitationTeam invitationToUpdate = invitationTeamRepository.findById(request.getInvitationId()).get();
        User receiver = userRepository.findById(invitationToUpdate.getReceiverId()).get();
        String receiverName = receiver.getUserName();
        Team team = teamRepository.findById(invitationToUpdate.getTeamId()).get();
        String teamName = team.getTeamName();
        User sender = userRepository.findById(invitationToUpdate.getSenderId()).get();
        String senderName = sender.getUserName();
        invitationToUpdate.setStatus(respondValue);
        invitationToUpdate.setResponseTime(responseTime);
        invitationTeamRepository.save(invitationToUpdate);
        return InvitationTeamResponse.builder().teamId(invitationToUpdate.getTeamId()).teamName(teamName).invitationId(invitationToUpdate.getInvitationId()).
                senderId(invitationToUpdate.getSenderId()).senderName(senderName).receiverId(invitationToUpdate.getReceiverId()).receiverName(receiverName).
                status(invitationToUpdate.getStatus()).createTime(invitationToUpdate.getCreateTime()).
                responseTime(invitationToUpdate.getResponseTime()).build();
    }

    public InvitationEventResponse respondEventInvitation(InvitationEventResponse request, int respondValue) {
        Timestamp responseTime = new Timestamp((System.currentTimeMillis()/1000)*1000L);
        InvitationEvent invitationToUpdate = invitationEventRepository.findById(request.getInvitationId()).get();
        User receiver = userRepository.findById(invitationToUpdate.getReceiverId()).get();
        String receiverName = receiver.getUserName();
        Event event = eventRepository.findById(invitationToUpdate.getEventId()).get();
        String eventName = event.getEventName();
        User sender = userRepository.findById(invitationToUpdate.getSenderId()).get();
        String senderName = sender.getUserName();
        invitationToUpdate.setStatus(respondValue);
        invitationToUpdate.setResponseTime(responseTime);
        invitationEventRepository.save(invitationToUpdate);
        return InvitationEventResponse.builder().eventId(invitationToUpdate.getEventId()).eventName(eventName).invitationId(invitationToUpdate.getInvitationId()).
                senderId(invitationToUpdate.getSenderId()).senderName(senderName).receiverId(invitationToUpdate.getReceiverId()).receiverName(receiverName).
                status(invitationToUpdate.getStatus()).createTime(invitationToUpdate.getCreateTime()).
                responseTime(invitationToUpdate.getResponseTime()).build();
    }
}
