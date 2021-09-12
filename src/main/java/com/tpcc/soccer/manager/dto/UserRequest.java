package com.tpcc.soccer.manager.dto;

import lombok.Data;

import javax.persistence.Transient;
import java.sql.Timestamp;

@Data
public class UserRequest {
    private String userName;
    private String email;
    private String password;
}

