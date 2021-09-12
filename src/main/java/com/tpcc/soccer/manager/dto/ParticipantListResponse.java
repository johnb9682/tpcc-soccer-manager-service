package com.tpcc.soccer.manager.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ParticipantListResponse {
    private List<UserResponseWithId> userResponses;
}
