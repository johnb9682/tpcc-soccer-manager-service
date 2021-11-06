package com.tpcc.soccer.manager.dto;


import lombok.Data;

import java.util.List;

@Data
public class InvitationTeamPostRequest {
    private int teamId;
    private int senderId;
    private List<Integer> receiverIds;
}
