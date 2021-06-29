package com.tpcc.soccer.manager.dao;

import org.springframework.data.repository.CrudRepository;
import com.tpcc.soccer.manager.entity.Team;

public interface TeamRepository extends CrudRepository<Team, Integer> {

}
