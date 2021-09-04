package com.tpcc.soccer.manager.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Transient;
import java.sql.Timestamp;

@Data
@Builder
public class InvitationResponse
{
    @NotNull
    private int invitation_id;
    @NotNull
    private String type; // invitation type can be either 'team' or 'event';
    private int teamId;
    private int eventId;
    @NotNull
    private int senderId;
    @NotNull
    private int receiverId;
    @NotNull
    private int status; // 0 is pending; -1 is rejected; 1 is accepted;
    @NotNull
    @Transient
    @jdk.jfr.Timestamp
    private Timestamp createTime;
    @Transient
    @jdk.jfr.Timestamp
    private Timestamp responseTime;
}
