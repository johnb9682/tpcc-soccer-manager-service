package com.tpcc.soccer.manager.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventParticipantRequest {
    private int event_participant_id;
    private int event_id;
    private int user_id;
    private boolean is_host;
}
