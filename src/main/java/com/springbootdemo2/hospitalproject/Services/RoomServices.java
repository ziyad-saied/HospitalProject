package com.springbootdemo2.hospitalproject.Services;

import com.springbootdemo2.hospitalproject.Entities.Rooms;
import com.springbootdemo2.hospitalproject.Repositories.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServices {

    @Autowired
    private RoomRepo roomRepo;

    //Add Room
    public Rooms addRoom(Rooms room) {
        return roomRepo.save(room);
    }

    //Get All Rooms
    public List<Rooms> getAllRooms() {
        return roomRepo.findAll();
    }

    //Get A Room By Id
    public Rooms getRoomById(int id) {
        return roomRepo.findById(id).get();
    }

    //Update A Room
    public Rooms updateRoom(Integer id,Rooms room) {
        Optional<Rooms> optionalRoom = roomRepo.findById(id);
        if (optionalRoom.isPresent()) {
            Rooms rooms1 = optionalRoom.get();
            if(room.getType()!=null)
                rooms1.setType(room.getType());
            if(room.getCapacity()!=null)
                rooms1.setCapacity(room.getCapacity());
            if(room.isAvailability()!=false)
                rooms1.setAvailability(room.isAvailability());
            return roomRepo.save(rooms1);
        }
        else
            return null;
    }

    //Delete Room By Id
    public void deleteRoomById(int id) {
        roomRepo.deleteById(id);
    }

    //Delete All Room
    public void deleteAllRooms() {
        roomRepo.deleteAll();
    }
}
