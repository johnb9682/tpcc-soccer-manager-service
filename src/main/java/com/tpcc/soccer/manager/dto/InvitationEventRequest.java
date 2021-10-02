package com.tpcc.soccer.manager.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Transient;
import java.sql.Timestamp;

@Data
public class InvitationEventRequest {
    private int eventId;
    private int senderId;
    private int receiverId;
}
