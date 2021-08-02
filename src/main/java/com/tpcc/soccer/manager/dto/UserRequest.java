package com.tpcc.soccer.manager.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String userName;
    private String email;
    private String password;
}

