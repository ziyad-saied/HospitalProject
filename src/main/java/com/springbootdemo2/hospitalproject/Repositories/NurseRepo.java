package com.springbootdemo2.hospitalproject.Repositories;

import com.springbootdemo2.hospitalproject.Entities.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepo extends JpaRepository<Nurse, Integer> {
}
