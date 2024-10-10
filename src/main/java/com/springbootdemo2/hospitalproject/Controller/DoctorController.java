package com.springbootdemo2.hospitalproject.Controller;

import com.springbootdemo2.hospitalproject.Entities.Doctor;
import com.springbootdemo2.hospitalproject.Services.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
