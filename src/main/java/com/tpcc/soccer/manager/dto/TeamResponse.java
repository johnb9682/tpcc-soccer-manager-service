package com.tpcc.soccer.manager.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Builder;

import java.sql.Timestamp;

@Data
@Builder
public class TeamResponse {
    @NotNull
    private int team_id;
    @NotNull
    private String team_description;
    @NotNull
    private String team_name;
    @NotNull
    private int leader_id;
    @NotNull
    @jdk.jfr.Timestamp
    private Timestamp create_time;
}
