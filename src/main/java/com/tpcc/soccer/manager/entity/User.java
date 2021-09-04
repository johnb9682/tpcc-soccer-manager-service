package com.tpcc.soccer.manager.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
    @Column(name = "name")
    @NotNull
    private String userName;
    @Column(name = "email")
    @NotNull
    private String email;
    @Column(name = "password")
    @NotNull
    private String password;
    @Column(name = "create_time")
    @NotNull
    @Transient
    @jdk.jfr.Timestamp
    private Timestamp userCreateTime;
    @Column(name = "last_active")
    @NotNull
    @Transient
    @jdk.jfr.Timestamp
    private Timestamp userLastActiveTime;

}
