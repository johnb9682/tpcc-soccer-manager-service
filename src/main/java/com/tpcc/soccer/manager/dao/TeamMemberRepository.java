package com.tpcc.soccer.manager.dao;

import com.tpcc.soccer.manager.entity.TeamMember;
import com.tpcc.soccer.manager.entity.TeamMemberCompositeKey;
import org.springframework.data.repository.CrudRepository;

public interface TeamMemberRepository extends CrudRepository<TeamMember, TeamMemberCompositeKey> {
}
