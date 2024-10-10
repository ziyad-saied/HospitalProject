package com.springbootdemo2.hospitalproject.Controller;

import com.springbootdemo2.hospitalproject.Entities.Doctor;
import com.springbootdemo2.hospitalproject.Entities.Patient;
import com.springbootdemo2.hospitalproject.Services.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    private DoctorServices doctorServices;

    //Add Doctor
    @PostMapping("/addDoctor")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorServices.addDoctor(doctor);
    }

    //Get All Doctors
    @GetMapping("/getAllDoctors")
    public List<Doctor> getAllDoctors() {
        return doctorServices.getAllDoctors();
    }

    //Get Doctor By ID
    @GetMapping("/getDoctorById")
    public Doctor getDoctorById(@RequestParam int id) {
        return doctorServices.getDoctorById(id);
    }

    //Update Doctor
    @PatchMapping("/updateDoctor")
    public Doctor updateDoctor(@RequestParam Integer id,@RequestBody Doctor doctor) {
        return doctorServices.updateDoctor(id, doctor);
    }

    //Delete Doctor By Id
    @DeleteMapping("/deleteDoctorById")
    public void deleteDoctorById(@RequestParam int id) {
        doctorServices.deleteDoctorById(id);
    }

    //Delete All Doctor
    @DeleteMapping("/deleteAllDoctor")
    public void deleteAllDoctors() {
        doctorServices.deleteAllDoctors();
    }

    //Set Doctors To Patients
    @PostMapping("/setDoctorsToPatients")
    public ResponseEntity<String> setDoctorsToPatients(@RequestParam Integer docId,@RequestBody Set<Integer> patientsId){
        doctorServices.setPatientsToDoctors(docId,patientsId);
        return ResponseEntity.ok("Success");
    }
}
