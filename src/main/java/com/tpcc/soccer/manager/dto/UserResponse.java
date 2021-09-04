package com.tpcc.soccer.manager.dto;

import lombok.*;

import javax.persistence.Transient;
import java.sql.Timestamp;

@Data
@Builder
public class UserResponse {
    private String userName;
    private String email;
    private String password;
    @Transient
    @jdk.jfr.Timestamp
    private Timestamp lastActive;
    @Transient
    @jdk.jfr.Timestamp
    private Timestamp createTime;
}
