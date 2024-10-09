package com.springbootdemo2.hospitalproject.Controller;

import com.springbootdemo2.hospitalproject.Entities.Rooms;
import com.springbootdemo2.hospitalproject.Services.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rooms")
public class RoomController {
    @Autowired
    private RoomServices roomServices;

    //Add Room
    @PostMapping("/addRoom")
    public Rooms addRoom(@RequestBody Rooms room) {
        return roomServices.addRoom(room);
    }
    //Get All Rooms
    @GetMapping("/getAllRooms")
    public List<Rooms> getAllRooms() {
        return roomServices.getAllRooms();
    }

    //Get Room By Id
    @GetMapping("/getRoomById")
    public Rooms getRoomById(@RequestParam int id) {
        return roomServices.getRoomById(id);
    }

    //Update Room
    @PutMapping("/updateRoom")
    public Rooms updateRoom(@RequestParam Integer id,@RequestBody Rooms room) {
        return this.roomServices.updateRoom(id,room);
    }

    //Delete Room By Id
    @DeleteMapping("/deleteRoomById")
    public void deleteRoomById(@RequestParam int id) {
        this.roomServices.deleteRoomById(id);
    }

    //Delete All Rooms
    @DeleteMapping("/deleteAllRooms")
    public void deleteAllRooms() {
        roomServices.deleteAllRooms();
    }



}
