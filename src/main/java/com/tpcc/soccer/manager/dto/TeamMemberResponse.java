package com.tpcc.soccer.manager.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class TeamMemberResponse {
    private int teamMemberId;
    private int userId;
    private int teamId;
    private boolean isLeader;
    private boolean isManager;
}
