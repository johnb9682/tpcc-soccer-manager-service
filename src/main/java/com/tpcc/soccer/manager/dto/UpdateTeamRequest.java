package com.tpcc.soccer.manager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateTeamRequest extends TeamRequest {
    private Integer id;
}
