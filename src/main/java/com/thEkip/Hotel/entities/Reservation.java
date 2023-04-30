package com.thEkip.Hotel.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Table(name="reservation")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reservation_id")
    private long reservationId;

    @Column(name="start_date")
    private LocalDateTime startDate;

    @Column (name="end_date")
    private LocalDateTime endDate;

    @ManyToOne
    @Column (name="room_id")
    private Room room;

    @ManyToOne
    @Column(name="reservation_id")
    private Reservation reservation;


}
