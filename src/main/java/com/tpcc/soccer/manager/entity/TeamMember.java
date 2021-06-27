package com.tpcc.soccer.manager.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Data
@Builder
@Table(name = "team_member")
@NoArgsConstructor
@AllArgsConstructor

public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team_member")
    @NotNull
    private Integer teamMemberId;
    @Column(name = "user")
    @NotNull
    private Integer user;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User teamMember;
    @Column(name = "team")
    @NotNull
    private Integer team;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_team")
    private Team currentTeam;
    @Column(name = "is_leader")
    @NotNull
    private Boolean isLeader;
    @Column(name = "is_manager")
    @NotNull
    private Boolean isManager;
}
