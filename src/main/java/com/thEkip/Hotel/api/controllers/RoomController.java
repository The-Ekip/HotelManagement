package com.thEkip.Hotel.api.controllers;

import com.thEkip.Hotel.api.dto.requests.RoomAddRequest;
import com.thEkip.Hotel.entities.Room;
import com.thEkip.Hotel.service.abstracts.RoomService;
import com.thEkip.Hotel.utilities.response.SuccessDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public ResponseEntity createOneRoom(@RequestBody RoomAddRequest request) {
        Room room = roomService.createOneRoom(request);
        return ResponseEntity.ok(room);
    }

    @GetMapping("/{localDateTime}")
    public ResponseEntity getAvailableRoomsAtDate(@PathVariable(value ="localDateTime") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime localDateTime)
    {
        List<Room> rooms = roomService.findAvailableRooms(localDateTime);

        return ResponseEntity.ok(rooms);
    }
    @GetMapping()
    public ResponseEntity getAllRooms()
    {
        List<Room> rooms = roomService.findAllRooms();
        return ResponseEntity.ok(new SuccessDataResponse("Rooms listed",rooms));
    }
}
