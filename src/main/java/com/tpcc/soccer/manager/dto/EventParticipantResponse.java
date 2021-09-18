package com.tpcc.soccer.manager.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class EventParticipantResponse {
    private int eventParticipantId;
    private int userId;
    private int eventId;
    private int isHost;
}
