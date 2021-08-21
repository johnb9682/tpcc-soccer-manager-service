package com.tpcc.soccer.manager.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class TeamMemberResponse {
    private int teamMember_id;
    private int user_id;
    private int team_id;
    private boolean is_leader;
    private boolean is_manager;
}
