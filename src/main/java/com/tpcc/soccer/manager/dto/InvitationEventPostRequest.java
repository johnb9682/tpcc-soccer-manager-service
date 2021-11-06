package com.tpcc.soccer.manager.dto;

import lombok.Data;
import java.util.List;

@Data
public class InvitationEventPostRequest {
    private int eventId;
    private int senderId;
    private List<Integer> receiverIds;
}
