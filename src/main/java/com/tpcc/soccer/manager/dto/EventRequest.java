package com.tpcc.soccer.manager.dto;

import lombok.Data;

@Data
public class EventRequest {
    private String event_description;
    private String event_name;
    private int creater_id;
}
