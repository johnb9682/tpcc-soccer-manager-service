package com.tpcc.soccer.manager.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity // This tells Hibernate to make a table out of this class
@Builder
@Data
@Table(name = "team")
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team")
    @NotNull
    private Integer teamId;
    @Column(name = "team_name")
    @NotNull
    private String teamName;
    @Column(name = "team_leader")
    @NotNull
    private int userId;
    @Column(name = "team_description")
    @NotNull
    private String teamDescription;
    @Column(name = "create_time")
    @NotNull
    @jdk.jfr.Timestamp
    private Timestamp teamCreateTime;
}
