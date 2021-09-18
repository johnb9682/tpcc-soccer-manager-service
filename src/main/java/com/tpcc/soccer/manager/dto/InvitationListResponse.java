package com.tpcc.soccer.manager.dto;

import com.tpcc.soccer.manager.entity.InvitationTeam;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InvitationListResponse {
    List<InvitationTeamResponse> invitationTeamResponses;
    List<InvitationEventResponse> invitationEventResponses;
}
