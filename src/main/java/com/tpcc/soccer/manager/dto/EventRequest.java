package com.tpcc.soccer.manager.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class EventRequest {
    @NotNull
    private String eventName;
    @NotNull
    private int hostId;
    @NotNull
    private int eventStartTime;
    @NotNull
    private int eventEndTime;
    private String eventLocation;
    private String eventDescription;
}