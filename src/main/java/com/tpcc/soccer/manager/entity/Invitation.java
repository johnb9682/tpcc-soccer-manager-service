package com.tpcc.soccer.manager.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity // This tells Hibernate to make a table out of this class
@Data
@Builder
@Table(name = "invitation")
@NoArgsConstructor
@AllArgsConstructor
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invitation")
    @NotNull
    private Integer invitationId;
    @Column(name = "type")
    @NotNull
    private String type; // invitation type can be either 'team' or 'event';
    @Column(name = "team")
    private Integer teamId;
    @Column(name = "event")
    private Integer eventId;
    @Column(name = "sender")
    @NotNull
    private Integer senderId;
    @Column(name = "receiver")
    @NotNull
    private Integer receiverId;
    @Column(name = "status")
    @NotNull
    private Integer status; // 0 is pending; -1 is rejected; 1 is accepted;
    @Column(name = "create_time")
    @NotNull
    @jdk.jfr.Timestamp
    private Timestamp createTime;
    @Column(name = "response_time")
    @jdk.jfr.Timestamp
    private Timestamp responseTime;
}