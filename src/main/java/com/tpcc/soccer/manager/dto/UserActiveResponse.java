package com.tpcc.soccer.manager.dto;

import lombok.*;

import javax.persistence.Transient;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Builder
public class UserActiveResponse {
    @jdk.jfr.Timestamp
    private Timestamp userLastActiveTime;
}
