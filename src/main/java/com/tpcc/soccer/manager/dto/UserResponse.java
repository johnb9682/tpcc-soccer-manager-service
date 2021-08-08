package com.tpcc.soccer.manager.dto;

import lombok.*;

@Data
@Builder
public class UserResponse {
    private String userName;
    private String email;
}
