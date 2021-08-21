package com.tpcc.soccer.manager.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class TeamResponse {
    private int team_id;
    private String team_description;
    private String team_name;
    private int leader_id;
}
