package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.dao.InvitationEventRepository;
import com.tpcc.soccer.manager.dao.InvitationTeamRepository;
import com.tpcc.soccer.manager.dto.*;
import com.tpcc.soccer.manager.entity.InvitationEvent;
import com.tpcc.soccer.manager.entity.InvitationTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvitationService {
    @Autowired
    private InvitationTeamRepository invitationTeamRepository;
    @Autowired
    private InvitationEventRepository invitationEventRepository;

    public InvitationTeamResponse getTeamInvitation(int id) {
        InvitationTeam invitation = invitationTeamRepository.findById(id).get();
        return InvitationTeamResponse.builder().senderId(invitation.getSenderId()).
                receiverId(invitation.getReceiverId()).invitationId(id).
                teamId(invitation.getTeamId()).status(invitation.getStatus()).
                createTime(invitation.getCreateTime()).responseTime(invitation.getResponseTime()).build();
    }
    public InvitationEventResponse getEventInvitation(int id) {
        InvitationEvent invitation = invitationEventRepository.findById(id).get();
        return InvitationEventResponse.builder().senderId(invitation.getSenderId()).
                receiverId(invitation.getReceiverId()).invitationId(id).
                eventId(invitation.getEventId()).status(invitation.getStatus()).
                createTime(invitation.getCreateTime()).responseTime(invitation.getResponseTime()).build();
}

    public InvitationListResponse addTeamInvitation(InvitationTeamPostRequest ir){
        Timestamp createTime = new Timestamp((System.currentTimeMillis()/1000)*1000L);
        List<Integer> receivers = ir.getReceiverIds();
        List<InvitationTeamResponse> invitationTeamResponses = new ArrayList<>();
        for (int receiver : receivers){
            InvitationTeam invitation = InvitationTeam.builder().teamId(ir.getTeamId()).senderId(ir.getSenderId()).
                    receiverId(receiver).status(0).createTime(createTime).build();
            InvitationTeam newInvitation = invitationTeamRepository.save(invitation);
            invitationTeamResponses.add(InvitationTeamResponse.builder().invitationId(newInvitation.getInvitationId()).
                    teamId(newInvitation.getTeamId()).senderId(newInvitation.getSenderId()).
                    receiverId(newInvitation.getReceiverId()).status(newInvitation.getStatus()).
                    createTime(newInvitation.getCreateTime()).build());
        }
        return InvitationListResponse.builder().invitationTeamResponses(invitationTeamResponses).build();
    }

    public InvitationListResponse addEventInvitation(InvitationEventPostRequest ir){
        Timestamp createTime = new Timestamp((System.currentTimeMillis()/1000)*1000L);
        List<Integer> receivers = ir.getReceiverIds();
        List<InvitationEventResponse> invitationEventResponses = new ArrayList<>();
        for (int receiver : receivers){
            InvitationEvent invitation = InvitationEvent.builder().eventId(ir.getEventId()).senderId(ir.getSenderId()).
                    receiverId(receiver).status(0).createTime(createTime).build();
            InvitationEvent newInvitation = invitationEventRepository.save(invitation);
            invitationEventResponses.add(InvitationEventResponse.builder().invitationId(newInvitation.getInvitationId()).
                    eventId(newInvitation.getEventId()).senderId(newInvitation.getSenderId()).
                    receiverId(newInvitation.getReceiverId()).status(newInvitation.getStatus()).
                    createTime(newInvitation.getCreateTime()).build());
        }
        return InvitationListResponse.builder().invitationEventResponses(invitationEventResponses).build();
    }

    public InvitationTeamResponse deleteTeamInvitation(int id){
        InvitationTeam invitation = invitationTeamRepository.findById(id).get();
        invitationTeamRepository.deleteById(id);
        return InvitationTeamResponse.builder().invitationId(id).teamId(invitation.getTeamId()).
                senderId(invitation.getSenderId()).receiverId(invitation.getReceiverId()).
                status(invitation.getStatus()).build();
    }
    public InvitationEventResponse deleteEventInvitation(int id){
        InvitationEvent invitation = invitationEventRepository.findById(id).get();
        invitationEventRepository.deleteById(id);
        return InvitationEventResponse.builder().invitationId(id).eventId(invitation.getEventId()).
                senderId(invitation.getSenderId()).receiverId(invitation.getReceiverId()).
                status(invitation.getStatus()).build();

    }

    public InvitationListResponse getUserReceiverTeamInvitation(int id){
        List<InvitationTeam> invitations = (List<InvitationTeam>) invitationTeamRepository.findAll();
        List<InvitationTeam> invitationList = new ArrayList<>();
        for (InvitationTeam invitation : invitations) {
            if (invitation.getReceiverId() == id) {
                invitationList.add(invitationTeamRepository.findById(invitation.getInvitationId()).get());
            }
        }
        List<InvitationTeamResponse> invitationTeamResponses = new ArrayList<>();
        for (InvitationTeam invitation : invitations){
            invitationTeamResponses.add(InvitationTeamResponse.builder().invitationId(invitation.getInvitationId()).
                    teamId(invitation.getTeamId()).senderId(invitation.getSenderId()).
                    receiverId(invitation.getReceiverId()).status(invitation.getStatus()).
                    createTime(invitation.getCreateTime()).build());
        }
        return InvitationListResponse.builder().invitationTeamResponses(invitationTeamResponses).build();
    }

    public InvitationListResponse getUserReceiverEventInvitation(int id){
        List<InvitationEvent> invitations = (List<InvitationEvent>) invitationEventRepository.findAll();
        List<InvitationEvent> invitationList = new ArrayList<>();
        for (InvitationEvent invitation : invitations) {
            if (invitation.getReceiverId() == id) {
                invitationList.add(invitationEventRepository.findById(invitation.getInvitationId()).get());
            }
        }

        List<InvitationEventResponse> invitationEventResponses = new ArrayList<>();
        for (InvitationEvent invitation : invitations) {
            invitationEventResponses.add(InvitationEventResponse.builder().invitationId(invitation.getInvitationId()).
                    eventId(invitation.getEventId()).senderId(invitation.getSenderId()).
                    receiverId(invitation.getReceiverId()).status(invitation.getStatus()).
                    createTime(invitation.getCreateTime()).build());
        }
        return InvitationListResponse.builder().invitationEventResponses(invitationEventResponses).build();
    }

    public InvitationListResponse getUserSenderTeamInvitation(int id){
        List<InvitationTeam> invitations = (List<InvitationTeam>) invitationTeamRepository.findAll();
        List<InvitationTeam> invitationList = new ArrayList<>();
        for (InvitationTeam invitation : invitations) {
            if (invitation.getSenderId() == id) {
                invitationList.add(invitationTeamRepository.findById(invitation.getInvitationId()).get());
            }
        }
        List<InvitationTeamResponse> invitationTeamResponses = new ArrayList<>();
        for (InvitationTeam invitation : invitations){
            invitationTeamResponses.add(InvitationTeamResponse.builder().invitationId(invitation.getInvitationId()).
                    teamId(invitation.getTeamId()).senderId(invitation.getSenderId()).
                    receiverId(invitation.getReceiverId()).status(invitation.getStatus()).
                    createTime(invitation.getCreateTime()).build());
        }
        return InvitationListResponse.builder().invitationTeamResponses(invitationTeamResponses).build();
    }

    public InvitationListResponse getUserSenderEventInvitation(int id){
        List<InvitationEvent> invitations = (List<InvitationEvent>) invitationEventRepository.findAll();
        List<InvitationEvent> invitationList = new ArrayList<>();
        for (InvitationEvent invitation : invitations) {
            if (invitation.getSenderId() == id) {
                invitationList.add(invitationEventRepository.findById(invitation.getInvitationId()).get());
            }
        }

        List<InvitationEventResponse> invitationEventResponses = new ArrayList<>();
        for (InvitationEvent invitation : invitations) {
            invitationEventResponses.add(InvitationEventResponse.builder().invitationId(invitation.getInvitationId()).
                    eventId(invitation.getEventId()).senderId(invitation.getSenderId()).
                    receiverId(invitation.getReceiverId()).status(invitation.getStatus()).
                    createTime(invitation.getCreateTime()).build());
        }
        return InvitationListResponse.builder().invitationEventResponses(invitationEventResponses).build();
    }


    public InvitationTeamResponse respondTeamInvitation(InvitationTeamResponse request, int respondValue) {
        Timestamp responseTime = new Timestamp((System.currentTimeMillis()/1000)*1000L);
        InvitationTeam invitationToUpdate = invitationTeamRepository.findById(request.getInvitationId()).get();
        invitationToUpdate.setStatus(respondValue);
        invitationToUpdate.setResponseTime(responseTime);
        invitationTeamRepository.save(invitationToUpdate);
        return InvitationTeamResponse.builder().teamId(invitationToUpdate.getTeamId()).invitationId(invitationToUpdate.getInvitationId()).
                senderId(invitationToUpdate.getSenderId()).receiverId(invitationToUpdate.getReceiverId()).
                status(invitationToUpdate.getStatus()).createTime(invitationToUpdate.getCreateTime()).
                responseTime(invitationToUpdate.getResponseTime()).build();
    }

    public InvitationEventResponse respondEventInvitation(InvitationEventResponse request, int respondValue) {
        Timestamp responseTime = new Timestamp((System.currentTimeMillis()/1000)*1000L);
        InvitationEvent invitationToUpdate = invitationEventRepository.findById(request.getInvitationId()).get();
        invitationToUpdate.setStatus(respondValue);
        invitationToUpdate.setResponseTime(responseTime);
        invitationEventRepository.save(invitationToUpdate);
        return InvitationEventResponse.builder().eventId(invitationToUpdate.getEventId()).invitationId(invitationToUpdate.getInvitationId()).
                senderId(invitationToUpdate.getSenderId()).receiverId(invitationToUpdate.getReceiverId()).
                status(invitationToUpdate.getStatus()).createTime(invitationToUpdate.getCreateTime()).
                responseTime(invitationToUpdate.getResponseTime()).build();
    }
}
