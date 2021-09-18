package com.tpcc.soccer.manager.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Transient;
import java.sql.Timestamp;

@Data
@Builder
public class InvitationTeamResponse
{
    private int invitation_id;
    private int teamId;
    private int senderId;
    private int receiverId;
    private int status; // 0 is pending; -1 is rejected; 1 is accepted;
    private Timestamp createTime;
    private Timestamp responseTime;
}
