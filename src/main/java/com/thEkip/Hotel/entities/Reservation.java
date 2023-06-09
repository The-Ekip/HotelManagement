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
    @JoinColumn (name="room_id",nullable=false)
    private Room room;

    @ManyToOne
    @JoinColumn(name="customer_id",nullable=false)
    private Customer customer;


}
