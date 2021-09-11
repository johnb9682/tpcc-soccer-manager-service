package com.tpcc.soccer.manager.dto;

import lombok.Data;

@Data
public class TeamMemberRequest {
    private int userId;
    private int teamId;
}
