package com.springbootdemo2.hospitalproject.Repositories;

import com.springbootdemo2.hospitalproject.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
}
