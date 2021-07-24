package com.tpcc.soccer.manager.service;

import com.tpcc.soccer.manager.dao.TeamRepository;
import com.tpcc.soccer.manager.dto.TeamRequest;
import com.tpcc.soccer.manager.dto.TeamResponse;
import com.tpcc.soccer.manager.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team getTeam(int id){
        return teamRepository.findById(id).get();
    }

    public TeamResponse addTeam(TeamRequest tr){
        Team team = Team.builder().teamName(tr.getTeam_name()).teamDescription(tr.getTeam_description()).userId(tr.getLeader_id()).build();
        Team newTeam = teamRepository.save(team);
        return TeamResponse.builder().team_name(newTeam.getTeamName()).team_description(newTeam.getTeamDescription()).leader_id(team.getUserId()).build();
    }

    public Team deleteTeam(int id){
        Team team = teamRepository.findById(id).get();
        teamRepository.deleteById(id);
        return team;
    }

    public TeamResponse updateTeam(TeamRequest tr, int id){
        Team team = Team.builder().teamName(tr.getTeam_name()).teamDescription(tr.getTeam_description()).userId(tr.getLeader_id()).teamId(id).build();
        teamRepository.save(team);
        return TeamResponse.builder().team_name(team.getTeamName()).team_description(team.getTeamDescription()).leader_id(team.getUserId()).build();
    }

}
