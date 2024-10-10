package com.springbootdemo2.hospitalproject.Controller;


import com.springbootdemo2.hospitalproject.Entities.Patient;
import com.springbootdemo2.hospitalproject.Services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientServices patientServices;

    //Return All Patients API
    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients() {
        return patientServices.getAllPatients();
    }

    //Return Patient By Id
    @GetMapping("/getPatientById")
    public Patient getPatientById(@RequestParam int id) {
        return patientServices.getPatientById(id);
    }

    //Add Patient
    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientServices.addPatient(patient);
    }

    //Find Patient By Id
    @GetMapping("/findPatientById")
    public Patient findPatientById(@RequestParam int id) {
        return patientServices.getPatientById(id);
    }

    //Update Patient
    @PutMapping("/updatePatientById")
    public Patient updatePatient(@RequestParam Integer id,@RequestBody Patient patient) {
        return this.patientServices.updatePatientById(patient,id);
    }


    //Delete Patient By Id
    @DeleteMapping("/deletePatientById")
    public void deletePatientById(@RequestParam int id) {
        this.patientServices.deletePatientById(id);
    }
}


