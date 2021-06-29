package com.tpcc.soccer.manager.entity;

import lombok.Data;

@Data
public class EventParticipantCompositeKey {
    private Integer eventParticipantId;
    private Integer userId;
    private Integer eventId;
}
