package com.tpcc.soccer.manager.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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
    @Column(name = "event_name")
    @NotNull
    private String eventName;
    @Column(name = "event_start_time")
    private LocalDate eventStartTime;
    @Column(name = "event_end_time")
    private LocalDate eventEndTime;
    @Column(name = "event_location")
    private String eventLocation;
    @Column(name = "event_description")
    private String eventDescription;
    @Column(name = "event_host")
    @NotNull
    private Integer userId;
}
