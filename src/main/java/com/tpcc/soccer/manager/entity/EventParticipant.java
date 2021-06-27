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
@Table(name = "event_participant")
@NoArgsConstructor
@AllArgsConstructor

public class EventParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event_participant")
    @NotNull
    private Integer eventParticipantId;
    @Column(name = "user")
    @NotNull
    private Integer user;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User eventParticipant;
    @Column(name = "event")
    @NotNull
    private Integer event;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_event")
    private Event currentEvent;
    @Column(name = "is_host")
    @NotNull
    private Boolean isHost;
}
