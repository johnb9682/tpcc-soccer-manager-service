package com.tpcc.soccer.manager.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Data
@Builder
@Table(name = "team_member")
@NoArgsConstructor
@AllArgsConstructor
@IdClass(TeamMemberCompositeKey.class)

public class TeamMember {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team_member")
    @NotNull
    private int teamMemberId;
    @Column(name = "user")
    @NotNull
    @Id
    private Integer userId;
    @Column(name = "team")
    @NotNull
    @Id
    private Integer teamId;
    @Column(name = "is_leader")
    @NotNull
    private Integer isLeader;
    @Column(name = "is_manager")
    @NotNull
    private Integer isManager;
    @Column(name = "create_time")
    @jdk.jfr.Timestamp
    private Timestamp createTime;
}
