package com.tpcc.soccer.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIErrorResponse {
    private Integer statusCode;
    private String errorMessage;
}
