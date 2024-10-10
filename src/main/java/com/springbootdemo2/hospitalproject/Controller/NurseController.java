package com.springbootdemo2.hospitalproject.Controller;

import com.springbootdemo2.hospitalproject.Entities.Nurse;
import com.springbootdemo2.hospitalproject.Services.NurseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/nurse")
public class NurseController {

    @Autowired
    private NurseServices nurseServices;

    //Add Nurse
    @PostMapping("/addNurse")
    public Nurse addNurse(@RequestBody Nurse nurse) {
        return nurseServices.addNurse(nurse);
    }

    //Get All Nurse
    @GetMapping("/getAllNurses")
    public List<Nurse> getAllNurses() {
        return nurseServices.getAllNurses();
    }

    //Get Nurse By ID
    @GetMapping("/getNurseById")
    public Nurse getNurseById(@RequestParam int id) {
        return nurseServices.getNurseById(id);
    }

    //Update Nurse
    @PatchMapping("/updateNurse")
    public Nurse updateNurse(@RequestParam Integer id,@RequestBody Nurse nurse) {
        return nurseServices.updateNurse(id, nurse);
    }

    //Delete Nurse By Id
    @DeleteMapping("/deleteNurseById")
    public void deleteNurseById(@RequestParam int id) {
        nurseServices.deleteNurseById(id);
    }

    //Delete All Nurses
    @DeleteMapping("/deleteAllNurse")
    public void deleteAllNurses() {
        nurseServices.deleteAllNurses();
    }

    @PostMapping("/assignNurseToRooms")
    public ResponseEntity<String> assignNurseToRooms(@RequestParam int nurseId, @RequestBody Set<Integer>courseId) {
        nurseServices.assignNursesToRooms(nurseId, courseId);
        return ResponseEntity.ok("Success");
    }
}
