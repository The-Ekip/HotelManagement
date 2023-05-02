package com.thEkip.Hotel.service.concretes;

import com.thEkip.Hotel.api.dto.requests.RoomAddRequest;
import com.thEkip.Hotel.dao.RoomRepository;
import com.thEkip.Hotel.entities.Room;
import com.thEkip.Hotel.exceptionHandler.hotelExceptions.EntityNotFoundException;
import com.thEkip.Hotel.service.abstracts.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoomManager implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public Room createOneRoom(RoomAddRequest request) {
        Room room = new Room();
        room.setFloor(request.getFloor());
        room.setType(request.getType());
        room.setStatu(request.isStatu());
        return roomRepository.save(room);
    }

    @Override
    public Room getOneRoomById(long roomId) {
        return roomRepository.findById(roomId).orElseThrow(()-> new EntityNotFoundException("room"));
    }
}
