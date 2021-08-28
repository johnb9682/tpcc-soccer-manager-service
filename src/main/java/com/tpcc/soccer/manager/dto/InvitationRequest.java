package com.tpcc.soccer.manager.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Transient;
import java.sql.Timestamp;

@Data
public class InvitationRequest {
    @NotNull
    private Integer invitationId;
    @NotNull
    private String type; // invitation type can be either 'team' or 'event';
    private Integer teamId;
    private Integer eventId;
    @NotNull
    private Integer senderId;
    @NotNull
    private Integer receiverId;
    @NotNull
    private Integer status; // 0 is pending; -1 is rejected; 1 is accepted;
    @NotNull
    @Transient
    @jdk.jfr.Timestamp
    private Timestamp createTime;
    @Transient
    @jdk.jfr.Timestamp
    private Timestamp responseTime;
}
