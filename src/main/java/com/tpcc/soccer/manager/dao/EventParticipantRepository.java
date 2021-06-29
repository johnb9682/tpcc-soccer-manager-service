package com.tpcc.soccer.manager.dao;

import com.tpcc.soccer.manager.entity.EventParticipant;
import com.tpcc.soccer.manager.entity.EventParticipantCompositeKey;
import org.springframework.data.repository.CrudRepository;

public interface EventParticipantRepository extends CrudRepository<EventParticipant, EventParticipantCompositeKey> {

}
