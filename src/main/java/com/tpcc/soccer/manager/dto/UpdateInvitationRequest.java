package com.tpcc.soccer.manager.dto;

import lombok.Data;

@Data
public class UpdateInvitationRequest {
    private int invitationId;
    private int status;
    private int responseTime;
}
