package com.thEkip.Hotel.api.controllers;

import com.thEkip.Hotel.api.dto.requests.RoomAddRequest;
import com.thEkip.Hotel.entities.Room;
import com.thEkip.Hotel.service.abstracts.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
