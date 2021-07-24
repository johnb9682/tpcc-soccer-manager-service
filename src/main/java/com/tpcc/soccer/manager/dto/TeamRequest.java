package com.tpcc.soccer.manager.dto;

import lombok.Data;


@Data
public class TeamRequest {
    private String team_description;
    private String team_name;
    private int leader_id;
}
