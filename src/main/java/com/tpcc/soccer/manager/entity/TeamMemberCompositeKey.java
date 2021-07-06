package com.tpcc.soccer.manager.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeamMemberCompositeKey implements Serializable {
    private Integer teamMemberId;
    private Integer userId;
    private Integer teamId;
}
