package com.thEkip.Hotel.service.abstracts;

import com.thEkip.Hotel.api.dto.requests.RoomAddRequest;
import com.thEkip.Hotel.entities.Room;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface RoomService {

    Room createOneRoom(RoomAddRequest request);
    Room getOneRoomById(long roomId);
    List<Room> findAvailableRooms(LocalDateTime localDateTime);
    List<Room> findAllRooms();
}
