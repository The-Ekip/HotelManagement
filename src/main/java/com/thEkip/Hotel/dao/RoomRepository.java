package com.thEkip.Hotel.dao;

import com.thEkip.Hotel.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository <Room,Long> {

    @Query("SELECT r from  Room r left  join  Reservation re on r.roomId=re.room.roomId where re.reservationId is null or re.startDate>?2 or  re.endDate<?1")
    List<Room> findAvailableRooms(LocalDateTime startDate, LocalDateTime endDate);

}
