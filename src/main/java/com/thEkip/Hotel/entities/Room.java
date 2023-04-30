package com.thEkip.Hotel.entities;

import com.thEkip.Hotel.enums.RoomType;
import jakarta.persistence.*;

@Entity
@Table(name="room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id")
    private long roomId;

    @Column(name="floor")
    private int floor;

    @Column(name="statu")
    private boolean statu;

    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private RoomType type;

}
