package com.tpcc.soccer.manager.service;


import com.tpcc.soccer.manager.dao.TeamMemberRepository;
import com.tpcc.soccer.manager.dao.UserRepository;
import com.tpcc.soccer.manager.dto.MemberListResponse;
import com.tpcc.soccer.manager.dto.TeamMemberResponse;
import com.tpcc.soccer.manager.dto.UserResponse;
import com.tpcc.soccer.manager.dto.UserResponseWithId;
import com.tpcc.soccer.manager.entity.TeamMemberCompositeKey;
import com.tpcc.soccer.manager.entity.User;
import com.tpcc.soccer.manager.exceptions.LeaderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tpcc.soccer.manager.entity.TeamMember;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TeamMemberService {
    @Autowired
    private TeamMemberRepository teamMemberRepository;
    @Autowired
    private UserRepository userRepository;

    public MemberListResponse getMember(int id){
        List<TeamMember> members = (List<TeamMember>) teamMemberRepository.findAll();
        List<User> users = new ArrayList<>();
        for (TeamMember tm : members){
            if (tm.getTeamId() == id){
                users.add(userRepository.findById(tm.getUserId()).get());
            }
        }
        List<UserResponseWithId> userResponses = new ArrayList<>();
        for (User user: users){
            userResponses.add(UserResponseWithId.builder().userId(user.getUserId()).userName(user.getUserName()).email(user.getEmail()).build());
        }

        return MemberListResponse.builder().userResponses(userResponses).build();
    }

    public TeamMemberResponse deleteMemberFromTeam(int userId, int teamId) throws LeaderException {
        List<TeamMember> members = (List<TeamMember>) teamMemberRepository.findAll();
        int id = -1;
        TeamMember member = new TeamMember();
        for (TeamMember tm: members){
            if (tm.getUserId() == userId && tm.getTeamId() == teamId) {
                if (tm.getIsLeader() == 1){
                    throw new LeaderException();
                }
                id = tm.getTeamMemberId();
                member = tm;
                break;
            }
        }
        if (id == -1 ) {
            return null;
        }
        TeamMemberCompositeKey ck = new TeamMemberCompositeKey();
        ck.setTeamId(teamId);
        ck.setTeamMemberId(id);
        ck.setUserId(userId);
        teamMemberRepository.deleteById(ck);
        return TeamMemberResponse.builder().teamMemberId(member.getTeamMemberId()).userId(member.getUserId()).teamId(member.getTeamId()).isLeader(member.getIsLeader()).isManager(member.getIsManager()).build();
    }

    public TeamMemberResponse addTeamMember(int userId, int teamId, int isLeader, int isManager) {
        Timestamp createTime = new Timestamp((System.currentTimeMillis()/1000)*1000L);
        Random r = new Random();
        int id = r.nextInt(99999999) + 1;
        TeamMember tm = TeamMember.builder().createTime(createTime).isLeader(isLeader).isManager(isManager).
                teamId(teamId).userId(userId).teamMemberId(id).build();
        TeamMember result = teamMemberRepository.save(tm);
        return TeamMemberResponse.builder().isLeader(isLeader).isManager(isManager).teamId(teamId).userId(userId).teamMemberId(id).build();
    }


}
