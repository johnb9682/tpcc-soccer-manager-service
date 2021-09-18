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
@Table(name = "event_participant")
@NoArgsConstructor
@AllArgsConstructor
@IdClass(EventParticipantCompositeKey.class)

public class EventParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event_participant")
    @NotNull
    private Integer eventParticipantId;
    @Column(name = "user")
    @Id
    @NotNull
    private Integer userId;
    @Column(name = "event")
    @Id
    @NotNull
    private Integer eventId;
    @Column(name = "is_host")
    @NotNull
    private Integer isHost;
    @Column(name = "create_time")
    @NotNull
    @jdk.jfr.Timestamp
    private Timestamp eventParticipantCreateTime;
}
