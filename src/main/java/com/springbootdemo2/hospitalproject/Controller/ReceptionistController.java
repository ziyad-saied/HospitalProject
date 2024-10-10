package com.springbootdemo2.hospitalproject.Controller;

import com.springbootdemo2.hospitalproject.Entities.Receptionist;
import com.springbootdemo2.hospitalproject.Entities.Records;
import com.springbootdemo2.hospitalproject.Services.ReceptionistServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ReceptionistController {
    @Autowired
    private ReceptionistServices receptionistServices;

    //Add Receptionist
    @PostMapping(path = "/addReceptionist")
    public Receptionist addReceptionist(@RequestBody Receptionist receptionist) {
        return receptionistServices.addReceptionist(receptionist);
    }

    //Get All Receptionist
    @GetMapping(path = "/getAllReceptionist")
    public List<Receptionist> getAllReceptionist() {
        return receptionistServices.getAllReceptionists();
    }

    //Get Receptionist By Id
    @GetMapping(path = "/getReceptionistById")
    public Receptionist getReceptionistById(@RequestParam int id) {
        return receptionistServices.getReceptionistById(id);
    }

    //Update Receptionist
    @PutMapping(path = "/updateReceptionist")
    public Receptionist updateReceptionist(@RequestParam int id, @RequestBody Receptionist receptionist) {
        return receptionistServices.updateReceptionist(id, receptionist);
    }

    //Delete Receptionist By Id
    @DeleteMapping(path = "/deleteReceptionistById")
    public ResponseEntity<String> deleteReceptionistById(@RequestParam int id) {
        return receptionistServices.deleteReceptionist(id);
    }

    //Delete All Receptionist
    @DeleteMapping(path = "/deleteAllReceptionist")
    public ResponseEntity<String> deleteAllReceptionist() {
        return receptionistServices.deleteAllReceptionists();
    }

    //Add Records Ids
    @PostMapping(path = "/addRecordsId")
    public void addRecordsId(@RequestParam int id , Set<Integer> recordsId) {
        receptionistServices.addRecordIds(id, recordsId);
    }
}
