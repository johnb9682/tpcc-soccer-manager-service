package com.tpcc.soccer.manager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseWithId {
    private Integer userId;
    private String userName;
    private String email;
}
