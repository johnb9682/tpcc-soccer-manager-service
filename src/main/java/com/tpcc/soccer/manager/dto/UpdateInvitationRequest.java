package com.tpcc.soccer.manager.dto;

import lombok.Data;

@Data
public class UpdateInvitationRequest {
    private Integer invitationId;
    private Integer status;
}
