package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.dao.TeamMemberRepository;
import com.tpcc.soccer.manager.dao.TeamRepository;
import com.tpcc.soccer.manager.dto.TeamListResponse;
import com.tpcc.soccer.manager.dto.TeamRequest;
import com.tpcc.soccer.manager.dto.TeamResponse;
import com.tpcc.soccer.manager.entity.Team;
import com.tpcc.soccer.manager.entity.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamMemberRepository teamMemberRepository;

    public TeamResponse getTeam(int id){
        Team team = teamRepository.findById(id).get();
        return TeamResponse.builder().team_id(id).team_name(team.getTeamName()).team_description(team.getTeamDescription()).leader_id(team.getUserId()).build();
    }

    public TeamResponse addTeam(TeamRequest tr){
        Team team = Team.builder().teamName(tr.getTeam_name()).teamDescription(tr.getTeam_description()).userId(tr.getLeader_id()).build();
        Team newTeam = teamRepository.save(team);
        return TeamResponse.builder().team_id(newTeam.getTeamId()).team_name(newTeam.getTeamName()).team_description(newTeam.getTeamDescription()).leader_id(team.getUserId()).build();
    }

    public TeamResponse deleteTeam(int id){
        Team team = teamRepository.findById(id).get();
        teamRepository.deleteById(id);
        return TeamResponse.builder().team_id(id).team_name(team.getTeamName()).team_description(team.getTeamDescription()).leader_id(team.getUserId()).build();
    }

    public TeamResponse updateTeam(TeamRequest tr, int id){
        Team team = teamRepository.findById(id).get();
        team.setTeamName(tr.getTeam_name());
        team.setTeamDescription(tr.getTeam_description());
        team.setUserId(tr.getLeader_id());
        teamRepository.save(team);
        return TeamResponse.builder().team_id(id).team_name(team.getTeamName()).team_description(team.getTeamDescription()).leader_id(team.getUserId()).build();
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
            teamResponses.add(TeamResponse.builder().team_name(team.getTeamName()).team_description(team.getTeamDescription()).leader_id(team.getUserId()).build());
        }

        return TeamListResponse.builder().teamResponses(teamResponses).build();
    }



}
