package com.tpcc.soccer.manager.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
public class EventResponse {
    @NotNull
    private String event_name;
    @NotNull
    private int host_id;
    @NotNull
    @DateTimeFormat
    private LocalDateTime event_start_time;
    @NotNull
    @DateTimeFormat
    private LocalDateTime event_end_time;
    private String event_location;
    private String event_description;
    @NotNull
    private LocalDateTime create_time;
}
