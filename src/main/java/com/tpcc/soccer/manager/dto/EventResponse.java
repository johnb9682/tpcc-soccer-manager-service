package com.tpcc.soccer.manager.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class EventResponse {
    private String event_description;
    private String event_name;
    private int creater_id;
}
