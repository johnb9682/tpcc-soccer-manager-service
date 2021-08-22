package com.tpcc.soccer.manager.dto;

import lombok.Data;

@Data
public class UserRequestWithoutPw {
    private String userName;
    private String email;
}
