package com.tpcc.soccer.manager.service;


import com.tpcc.soccer.manager.dao.TeamMemberRepository;
import com.tpcc.soccer.manager.dao.UserRepository;
import com.tpcc.soccer.manager.dto.MemberListResponse;
import com.tpcc.soccer.manager.dto.TeamMemberResponse;
import com.tpcc.soccer.manager.dto.UserResponse;
import com.tpcc.soccer.manager.dto.UserResponseWithId;
import com.tpcc.soccer.manager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tpcc.soccer.manager.entity.TeamMember;
import java.util.ArrayList;
import java.util.List;

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

    public TeamMemberResponse deleteMemberFromTeam(int userId, int teamId){
        List<TeamMember> members = (List<TeamMember>) teamMemberRepository.findAll();
        int id = -1;
        TeamMember member = new TeamMember();
        for (TeamMember tm: members){
            if (tm.getUserId() == userId && tm.getTeamId() == teamId) {
                id = tm.getTeamMemberId();
                member = tm;
                break;
            }
        }
        if (id == -1) {
            return null;
        }
        return TeamMemberResponse.builder().teamMemberId(member.getTeamMemberId()).userId(member.getUserId()).teamId(member.getTeamId()).isLeader(member.getIsLeader()).isManager(member.getIsManager()).build();
    }


}
