package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.dao.InvitationRepository;
import com.tpcc.soccer.manager.dto.InvitationListResponse;
import com.tpcc.soccer.manager.dto.InvitationRequest;
import com.tpcc.soccer.manager.dto.InvitationResponse;
import com.tpcc.soccer.manager.dto.UpdateInvitationRequest;
import com.tpcc.soccer.manager.entity.Invitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvitationService {
    @Autowired
    private InvitationRepository invitationRepository;

    public InvitationResponse getInvitation(int id){
        Invitation invitation = invitationRepository.findById(id).get();
        if (invitation.getType() == "team"){
            return InvitationResponse.builder().senderId(invitation.getSenderId()).
                    receiverId(invitation.getReceiverId()).type(invitation.getType()).
                    teamId(invitation.getTeamId()).status(invitation.getStatus()).
                    createTime(invitation.getCreateTime()).responseTime(invitation.getResponseTime()).build();
        }
        else {
            return InvitationResponse.builder().senderId(invitation.getSenderId()).
                    receiverId(invitation.getReceiverId()).type(invitation.getType()).
                    eventId(invitation.getEventId()).status(invitation.getStatus()).
                    createTime(invitation.getCreateTime()).responseTime(invitation.getResponseTime()).build();
        }
    }

    public InvitationResponse addInvitation(InvitationRequest ir){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Invitation invitation = Invitation.builder().type(ir.getType()).senderId(ir.getSenderId()).
                receiverId(ir.getReceiverId()).status(0).createTime(timestamp).build();
        Invitation newInvitation = invitationRepository.save(invitation);
        return InvitationResponse.builder().invitation_id(newInvitation.getInvitationId()).
                type(newInvitation.getType()).senderId(newInvitation.getSenderId()).
                receiverId(newInvitation.getReceiverId()).status(newInvitation.getStatus()).
                createTime(newInvitation.getCreateTime()).build();
    }

    public InvitationResponse deleteInvitation(int id){
        Invitation invitation = invitationRepository.findById(id).get();
        invitationRepository.deleteById(id);
        return InvitationResponse.builder().invitation_id(id).type(invitation.getType()).
                senderId(invitation.getSenderId()).receiverId(invitation.getReceiverId()).
                status(invitation.getStatus()).build();

    }

    public InvitationListResponse getUserInvitation(int id){
        List<Invitation> invitations = (List<Invitation>) invitationRepository.findAll();
        List<Invitation> invitationList = new ArrayList<>();
        for (Invitation invitation : invitations) {
            if (invitation.getSenderId() == id) {
                invitationList.add(invitationRepository.findById(invitation.getInvitationId()).get());
            }
            if (invitation.getReceiverId() == id) {
                invitationList.add(invitationRepository.findById(invitation.getInvitationId()).get());
            }
        }

        List<InvitationResponse> invitationResponses = new ArrayList<>();
        for (Invitation invitation : invitations){
            if (invitation.getType() == "event")
            {
                invitationResponses.add(InvitationResponse.builder().type(invitation.getType()).
                        eventId(invitation.getEventId()).senderId(invitation.getSenderId()).
                        receiverId(invitation.getReceiverId()).status(invitation.getStatus()).
                        createTime(invitation.getCreateTime()).build());
            }
            if (invitation.getType() == "team")
            {
                invitationResponses.add(InvitationResponse.builder().type(invitation.getType()).
                        teamId(invitation.getTeamId()).senderId(invitation.getSenderId()).
                        receiverId(invitation.getReceiverId()).status(invitation.getStatus()).
                        createTime(invitation.getCreateTime()).build());
            }
        }
        return InvitationListResponse.builder().invitationResponses(invitationResponses).build();
    }

    public InvitationResponse updateInvitation(UpdateInvitationRequest request) {
        Invitation invitationToUpdate = invitationRepository.findById(request.getInvitationId()).get();
        invitationToUpdate.setStatus(request.getStatus());
        invitationRepository.save(invitationToUpdate);
        return InvitationResponse.builder().type(invitationToUpdate.getType()).teamId(invitationToUpdate.getTeamId()).
                senderId(invitationToUpdate.getSenderId()).receiverId(invitationToUpdate.getReceiverId()).
                status(invitationToUpdate.getStatus()).createTime(invitationToUpdate.getCreateTime()).build();
    }

}
