package com.tpcc.soccer.manager.dto;

import lombok.Data;

@Data
public class EventRequest {
    private String eventName;
    private int hostId;
    private int eventStartTime;
    private int eventEndTime;
    private String eventLocation;
    private String eventDescription;
}