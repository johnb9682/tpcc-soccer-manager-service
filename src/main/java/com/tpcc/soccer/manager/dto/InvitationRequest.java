package com.tpcc.soccer.manager.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Transient;
import java.sql.Timestamp;

@Data
public class InvitationRequest {
    private int invitationId;
    private String type; // invitation type can be either 'team' or 'event';
    private int teamId;
    private int eventId;
    private int senderId;
    private int receiverId;
    private int status; // 0 is pending; -1 is rejected; 1 is accepted;
    private int createTime;
    private int responseTime;
}
