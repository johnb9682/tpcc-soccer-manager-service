package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.dao.TeamMemberRepository;
import com.tpcc.soccer.manager.dao.TeamRepository;
import com.tpcc.soccer.manager.dao.UserRepository;
import com.tpcc.soccer.manager.dto.TeamListResponse;
import com.tpcc.soccer.manager.dto.TeamMemberResponse;
import com.tpcc.soccer.manager.dto.TeamRequest;
import com.tpcc.soccer.manager.dto.TeamResponse;
import com.tpcc.soccer.manager.entity.Team;
import com.tpcc.soccer.manager.entity.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamMemberRepository teamMemberRepository;
    @Autowired
    private UserRepository userRepository;

    public TeamResponse getTeam(int id){
        Team team = teamRepository.findById(id).get();
        return TeamResponse.builder().teamId(id).teamName(team.getTeamName()).
                teamDescription(team.getTeamDescription()).leaderId(team.getUserId()).build();
    }

    public TeamResponse addTeam(TeamRequest tr){
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        Team team = Team.builder().teamName(tr.getTeamName()).teamDescription(tr.getTeamDescription()).
                userId(tr.getLeaderId()).teamCreateTime(createTime).build();
        Team newTeam = teamRepository.save(team);
        return TeamResponse.builder().teamId(newTeam.getTeamId()).teamName(newTeam.getTeamName()).
                teamDescription(newTeam.getTeamDescription()).leaderId(newTeam.getUserId()).
                createTime(newTeam.getTeamCreateTime()).build();
    }

    public TeamResponse deleteTeam(int id){
        Team team = teamRepository.findById(id).get();
        teamRepository.deleteById(id);
        return TeamResponse.builder().teamId(id).teamName(team.getTeamName()).
                teamDescription(team.getTeamDescription()).leaderId(team.getUserId()).build();
    }

    public TeamResponse updateTeam(TeamRequest tr, int id){
        Team team = teamRepository.findById(id).get();
        team.setTeamName(tr.getTeamName());
        team.setTeamDescription(tr.getTeamDescription());
        team.setUserId(tr.getLeaderId());
        teamRepository.save(team);
        return TeamResponse.builder().teamId(id).teamName(team.getTeamName()).
                teamDescription(team.getTeamDescription()).leaderId(team.getUserId()).build();
    }

    public TeamListResponse getUserTeam(int id) {
        List<TeamMember> teamMembers = (List<TeamMember>) teamMemberRepository.findAll();
        List<Team> teams = new ArrayList<>();
        for (TeamMember teamMember : teamMembers) {
            if (teamMember.getUserId() == id) {
                teams.add(teamRepository.findById(teamMember.getTeamId()).get());
            }
        }

        List<TeamResponse> teamResponses = new ArrayList<>();
        for (Team team : teams) {
            teamResponses.add(TeamResponse.builder().teamName(team.getTeamName()).
                    teamDescription(team.getTeamDescription()).leaderId(team.getUserId()).build());
        }

        return TeamListResponse.builder().teamResponses(teamResponses).build();
    }



}
