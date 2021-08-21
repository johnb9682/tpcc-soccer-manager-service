package com.tpcc.soccer.manager.dto;

import lombok.Data;

@Data
public class TeamMemberRequest {
    private int user_id;
    private int team_id;
}
