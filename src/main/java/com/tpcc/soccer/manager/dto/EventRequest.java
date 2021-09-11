package com.tpcc.soccer.manager.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class EventRequest {
    private String eventName;
    private int hostId;
    private int eventStartTime;
    private int eventEndTime;
    private String eventLocation;
    private String eventDescription;
}