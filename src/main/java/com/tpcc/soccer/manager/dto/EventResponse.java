package com.tpcc.soccer.manager.dto;

import lombok.Data;
import lombok.Builder;
import java.sql.Timestamp;

@Data
@Builder
public class EventResponse {
    private String eventName;
    private int hostId;
    private Timestamp eventStartTime;
    private Timestamp eventEndTime;
    private String eventLocation;
    private String eventDescription;
    private Timestamp createTime;
}
