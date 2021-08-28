package com.tpcc.soccer.manager.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // This tells Hibernate to make a table out of this class
@Data
@Builder
@Table(name = "team_member")
@NoArgsConstructor
@AllArgsConstructor
@IdClass(TeamMemberCompositeKey.class)

public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team_member")
    @NotNull
    private Integer teamMemberId;
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
    private Boolean isLeader;
    @Column(name = "is_manager")
    @NotNull
    private Boolean isManager;
    @Column(name = "create_time")
    @NotNull
    private LocalDateTime teamMemberCreateTime;
}
