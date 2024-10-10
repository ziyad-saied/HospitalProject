package com.springbootdemo2.hospitalproject.Services;

import com.springbootdemo2.hospitalproject.Entities.Doctor;
import com.springbootdemo2.hospitalproject.Entities.Patient;
import com.springbootdemo2.hospitalproject.Repositories.DoctorRepo;
import com.springbootdemo2.hospitalproject.Repositories.PatientRepo;
import jakarta.persistence.SecondaryTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DoctorServices {
    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private PatientRepo patientRepo;
    //Add Doctor
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    //Get All Doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    //Get Doctor By Id
    public Doctor getDoctorById(int id) {
        return doctorRepo.findById(id).get();
    }

    //Update Doctor
    public Doctor updateDoctor(Integer id,Doctor doctor) {
        Optional<Doctor> doctorOptional = doctorRepo.findById(id);
        if (doctorOptional.isPresent()) {
            Doctor doc = doctorOptional.get();
            if(doctor.getName()!=null)
                doc.setName(doctor.getName());
            if(doctor.getAge()!=null)
                doc.setAge(doctor.getAge());
            if(doctor.getGender()!=null)
                doc.setGender(doctor.getGender());
            if(doctor.getSalary()!=0.0)
                doc.setSalary(doctor.getSalary());
            if(doctor.getMobile()!=null)
                doc.setMobile(doctor.getMobile());
            if(doctor.getDepartment()!=null)
                doc.setDepartment(doctor.getDepartment());
            if(doctor.getQualification()!=null)
                doc.setQualification(doctor.getQualification());
            if(doctor.getState()!=null)
                doc.setState(doctor.getState());
            if(doctor.getCity()!=null)
                doc.setCity(doctor.getCity());
            if(doctor.getPinno()!=null)
                doc.setPinno(doctor.getPinno());
            return doctorRepo.save(doc);
        }
        else
            return null;
    }

    //Delete Doctor By Id
    public void deleteDoctorById(int id) {
        doctorRepo.deleteById(id);
    }

    //Delete All Doctor
    public void deleteAllDoctors() {
        doctorRepo.deleteAll();
    }

    //Set Patients To Doctors
    public void setPatientsToDoctors(Integer doctorId, Set<Integer> patientId){
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));

        Set<Patient> patients = new HashSet<>();
        for(Integer patientIds : patientId){
            Patient patient = patientRepo.findById(patientIds).orElseThrow(() -> new RuntimeException("Patient not found"));
            patients.add(patient);
        }
        doctor.setPatients(patients);
        doctorRepo.save(doctor);
    }
}
