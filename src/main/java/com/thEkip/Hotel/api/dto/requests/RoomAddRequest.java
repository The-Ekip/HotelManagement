package com.thEkip.Hotel.api.dto.requests;

import com.thEkip.Hotel.entities.Customer;
import com.thEkip.Hotel.entities.Room;
import com.thEkip.Hotel.enums.RoomType;
import lombok.Data;

@Data
public class RoomAddRequest {

    private int floor;
    private boolean statu;
    private RoomType type;

    public Room createOneRoom() {
        Room newRoom = new Room();
        newRoom.setFloor(this.floor);
        newRoom.setStatu(this.statu);
        newRoom.setType(this.type);
        return newRoom;
    }


}
