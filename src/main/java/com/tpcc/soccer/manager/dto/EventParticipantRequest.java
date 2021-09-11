package com.tpcc.soccer.manager.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventParticipantRequest {
    private int eventParticipantId;
    private int eventId;
    private int userId;
    private boolean isHost;
}
