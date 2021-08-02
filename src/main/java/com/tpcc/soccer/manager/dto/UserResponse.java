package com.tpcc.soccer.manager.dto;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends APIErrorResponse {
    private String userName;
    private String email;
}
