package com.tpcc.soccer.manager.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventParticipantRequest {
    private int eventId;
    private int userId;
}
