package com.tpcc.soccer.manager.dao;

import com.tpcc.soccer.manager.entity.InvitationEvent;
import org.springframework.data.repository.CrudRepository;

public interface InvitationEventRepository extends CrudRepository<InvitationEvent, Integer> {

}