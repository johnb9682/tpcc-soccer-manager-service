package com.tpcc.soccer.manager.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MemberListResponse {
    private List<UserResponseWithId> userResponses;
}
