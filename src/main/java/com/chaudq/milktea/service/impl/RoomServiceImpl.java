package com.chaudq.milktea.service.impl;

import com.chaudq.milktea.db2.RoomDatabase;
import com.chaudq.milktea.model2.Room;
import com.chaudq.milktea.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDatabase roomDatabase;

    @Override
    public List<Room> getAllRoomByHostel(String idHostel) {
        return roomDatabase.getAllRoomByHostelID(idHostel);
    }

    @Override
    public boolean insertRoom(Room room) {
        return roomDatabase.insertRoom(room);
    }

    @Override
    public List<Room> getAllRentingRoom(String idHostel) {
        List<Room> rooms = new ArrayList<>();
        List<Room> all = roomDatabase.getAllRoomByHostelID(idHostel);
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getStatus().equalsIgnoreCase("Có"))
                rooms.add(all.get(i));
        }
        return rooms;
    }
}
