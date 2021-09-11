package com.tpcc.soccer.manager.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Builder;

import javax.persistence.Transient;
import java.sql.Date;
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
