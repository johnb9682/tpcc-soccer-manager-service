package com.tpcc.soccer.manager.dto;

import jdk.jfr.Timestamp;
import lombok.Data;

import javax.persistence.Transient;
import java.sql.Time;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
