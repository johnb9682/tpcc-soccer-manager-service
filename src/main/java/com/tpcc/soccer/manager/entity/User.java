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
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    @NotNull
    private Integer userId;
    private String teamId;
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Team team;
    private Event event;
    private TeamMember teamMember;
    private EventParticipant eventParticipant;
    @Column(name = "name")
    @NotNull
    private String userName;
    @Column(name = "email")
    @NotNull
    private String email;
    @Column(name = "password")
    @NotNull
    private String password;

}
