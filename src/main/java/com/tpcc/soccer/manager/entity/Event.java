package com.tpcc.soccer.manager.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @Column(name = "event_date")
    @NotNull
    private LocalDate eventDate;
    @Column(name = "event_location")
    private String eventLocation;
    @Column(name = "event_time")
    private LocalDateTime eventTime;
    @Column(name = "event_description")
    private String eventDescription;
    @Column(name = "event_host")
    @NotNull
    private Integer userId;
}
