package com.tpcc.soccer.manager.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.concurrent.TimeoutException;

@Entity // This tells Hibernate to make a table out of this class
@Data
@Builder
@Table(name = "event")
@NoArgsConstructor
@AllArgsConstructor

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event")
    @NotNull
    private Integer eventId;
    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EventParticipant eventParticipant;
    @Column(name = "event_date")
    @NotNull
    private Date eventDate;
    @Column(name = "event_location")
    private String eventLocation;
    @Column(name = "event_time")
    private Time eventTime;
    @Column(name = "event_description")
    private String eventDescription;
    @Column(name = "event_host")
    @NotNull
    private Integer eventHost;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;
}
