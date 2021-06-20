package com.tpcc.soccer.manager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String userName;
    private String organization;
}
