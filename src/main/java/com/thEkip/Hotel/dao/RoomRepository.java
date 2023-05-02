package com.thEkip.Hotel.dao;

import com.thEkip.Hotel.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository <Room,Long> {
}
