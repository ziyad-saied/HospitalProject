package com.springbootdemo2.hospitalproject.Services;

import com.springbootdemo2.hospitalproject.Entities.Nurse;
import com.springbootdemo2.hospitalproject.Entities.Rooms;
import com.springbootdemo2.hospitalproject.Repositories.NurseRepo;
import com.springbootdemo2.hospitalproject.Repositories.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class NurseServices {
    @Autowired
    private NurseRepo nurseRepo;

    @Autowired
    private RoomRepo roomRepo;
    //Add Nurse
    public Nurse addNurse(Nurse nurse) {
        return nurseRepo.save(nurse);
    }

    //Get All Nurses
    public List<Nurse> getAllNurses() {
        return nurseRepo.findAll();
    }

    //Get Nurse By Id
    public Nurse getNurseById(int id) {
        return nurseRepo.findById(id).get();
    }

    //Update Nurse
    public Nurse updateNurse(Integer id, Nurse nurse) {
        Optional<Nurse> nurseOptional = nurseRepo.findById(id);
        if (nurseOptional.isPresent()) {
            Nurse nurse1 = nurseOptional.get();
            if(nurse.getName()!=null)
                nurse1.setName(nurse.getName());
            if(nurse.getAge()!=null)
                nurse1.setAge(nurse.getAge());
            if(nurse.getGender()!=null)
                nurse1.setGender(nurse.getGender());
            if(nurse.getSalary()!=0.0)
                nurse1.setSalary(nurse.getSalary());
            if(nurse.getMobile()!=null)
                nurse1.setMobile(nurse.getMobile());
            if(nurse.getState()!=null)
                nurse1.setState(nurse.getState());
            if(nurse.getCity()!=null)
                nurse1.setCity(nurse.getCity());
            if(nurse.getPinno()!=null)
                nurse1.setPinno(nurse.getPinno());
            return nurseRepo.save(nurse1);
        }
        else
            return null;
    }

    //Delete Nurse By Id
    public void deleteNurseById(int id) {
        nurseRepo.deleteById(id);
    }

    //Delete All Nurses
    public void deleteAllNurses() {
        nurseRepo.deleteAll();
    }

    //Assign Nurses To Rooms
    public void assignNursesToRooms(int nurseId,Set<Integer> roomsId){
        Nurse nurse = nurseRepo.findById(nurseId).orElseThrow(() -> new RuntimeException("Nurse not found"));
        Set<Rooms> rooms =new HashSet<>();
        for(Integer roomId : roomsId){
            Rooms rooms1 = roomRepo.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
            rooms.add(rooms1);
        }
        nurse.setRooms(rooms);
        nurseRepo.save(nurse);
    }
}


