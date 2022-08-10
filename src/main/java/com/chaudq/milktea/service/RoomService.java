package com.chaudq.milktea.service;

import com.chaudq.milktea.model2.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRoomByHostel(String idHostel);

    boolean insertRoom(Room room);
    List<Room> getAllRentingRoom(String idHostel);
}
