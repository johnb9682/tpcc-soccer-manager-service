package com.tpcc.soccer.manager.dto;

import lombok.*;

import javax.persistence.Transient;
import java.sql.Timestamp;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class VerifyLoginResponse extends APIErrorResponse {
    private Integer userId;
    private String userName;
    private String email;
}
