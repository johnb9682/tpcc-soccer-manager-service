package com.tpcc.soccer.manager.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class TeamRequest {
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
