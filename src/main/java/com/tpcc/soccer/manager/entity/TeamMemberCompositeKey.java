package com.tpcc.soccer.manager.entity;

import lombok.Data;

@Data
public class TeamMemberCompositeKey {
    private Integer teamMemberId;
    private Integer userId;
    private Integer teamId;
}
