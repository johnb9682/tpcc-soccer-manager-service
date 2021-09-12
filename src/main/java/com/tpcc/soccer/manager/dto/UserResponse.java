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
    private String password;
    @jdk.jfr.Timestamp
    @Transient
    private Timestamp lastActive;
    @jdk.jfr.Timestamp
    @Transient
    private Timestamp createTime;
}
