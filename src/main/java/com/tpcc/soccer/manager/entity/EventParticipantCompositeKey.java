package com.tpcc.soccer.manager.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class EventParticipantCompositeKey implements Serializable {
    private Integer eventParticipantId;
    private Integer userId;
    private Integer eventId;
}
