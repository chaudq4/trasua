package com.chaudq.milktea.controller2;

import com.chaudq.milktea.model2.Room;
import com.chaudq.milktea.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/all")
    public List<Room> getAllRoomByHostel(@RequestBody String idHostel) {
        return roomService.getAllRoomByHostel(idHostel);
    }

    @PostMapping("/insert")
    public boolean insertRoom(@RequestBody Room room) {
        return roomService.insertRoom(room);
    }
    @PostMapping("/renting")
    public List<Room> getAllRentingRoom(@RequestBody String idHostel){
        return roomService.getAllRentingRoom(idHostel);
    }
}
