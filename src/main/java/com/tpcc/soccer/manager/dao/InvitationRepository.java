package com.tpcc.soccer.manager.dao;

import org.springframework.data.repository.CrudRepository;
import com.tpcc.soccer.manager.entity.Invitation;

public interface InvitationRepository extends CrudRepository<Invitation, Integer> {

}