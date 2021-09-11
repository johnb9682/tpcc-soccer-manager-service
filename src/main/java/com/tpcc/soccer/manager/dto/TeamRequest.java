package com.tpcc.soccer.manager.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class TeamRequest {
    private String teamDescription;
    private String teamName;
    private int leaderId;
}
