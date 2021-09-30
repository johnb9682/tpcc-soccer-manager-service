package com.tpcc.soccer.manager.dto;

import lombok.*;

import javax.persistence.Transient;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Builder
public class UserResponse {
    private String userName;
    private String email;
    @jdk.jfr.Timestamp
    @Transient
    private Timestamp userLastActiveTime;
    @jdk.jfr.Timestamp
    @Transient
    private Timestamp userCreateTime;
}
