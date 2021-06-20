package com.tpcc.soccer.manager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String userName;
    private String email;
}
