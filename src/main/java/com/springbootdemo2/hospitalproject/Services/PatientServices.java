package com.springbootdemo2.hospitalproject.Services;

import com.springbootdemo2.hospitalproject.Entities.Patient;
import com.springbootdemo2.hospitalproject.Repositories.PatientRepo;
import com.springbootdemo2.hospitalproject.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServices {
    @Autowired
    private PatientRepo patientRepo;

    //Return All Patient
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }
    //Return The Patient By ID
    public Patient getPatientById(int id) {
        return patientRepo.findById(id).get();
    }
    //Add Patient To DB
    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    //Find Patient By Id
    public Patient findById(int id) {
        return patientRepo.findById(id).get();
    }

    //Update Patient
    public Patient updatePatientById(Patient patient,Integer id) {
        Optional<Patient> optionalPatient = this.patientRepo.findById(id);
        if(optionalPatient.isPresent()) {
            Patient existingPatient=optionalPatient.get();
            if(patient.getName()!=null)
                existingPatient.setName(patient.getName());
            if(patient.getAge()!=null)
                existingPatient.setAge(patient.getAge());
            if(patient.getGender()!=null)
                existingPatient.setGender(patient.getGender());
            if(patient.getDob()!=null)
                existingPatient.setDob(patient.getDob());
            if (patient.getMobile()!=null)
                existingPatient.setMobile(patient.getMobile());
            return patientRepo.save(existingPatient);
        }
        else {
            throw new ResourceNotFoundException("Patient not found, please enter a valid id");
        }
    }

    //Delete Patient By Id
    public void deletePatientById(int id){
        this.patientRepo.deleteById(id);
    }
}