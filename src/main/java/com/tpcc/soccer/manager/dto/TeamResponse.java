package com.tpcc.soccer.manager.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Builder;

import java.sql.Timestamp;

@Data
@Builder
public class TeamResponse {
    private int teamId;
    private String teamDescription;
    private String teamName;
    private int leaderId;
    private Timestamp createTime;
}
