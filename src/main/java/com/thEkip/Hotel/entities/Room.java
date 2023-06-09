package com.thEkip.Hotel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thEkip.Hotel.enums.RoomType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="room")
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id")
    private long roomId;

    @Column(name="floor")
    private int floor;

    @Column(name="statu")
    private boolean statu;

    @Column(name="description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private RoomType type;

    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;

}
