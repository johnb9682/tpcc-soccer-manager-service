package com.tpcc.soccer.manager.dto;

import lombok.Data;

@Data
public class UpdateInvitationRequest {
    private int invitationId;
    private int entityId;
    private int receiverId;
    private int status;
}
