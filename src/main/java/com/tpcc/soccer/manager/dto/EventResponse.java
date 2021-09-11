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
    @NotNull
    private String eventName;
    @NotNull
    private int hostId;
    @NotNull
    @jdk.jfr.Timestamp
    @Transient
    private Timestamp eventStartTime;
    @NotNull
    @jdk.jfr.Timestamp
    @Transient
    private Timestamp eventEndTime;
    private String eventLocation;
    private String eventDescription;
    @NotNull
    private Timestamp createTime;
}
