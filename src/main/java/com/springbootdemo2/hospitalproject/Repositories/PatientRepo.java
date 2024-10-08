package com.springbootdemo2.hospitalproject.Repositories;

import com.springbootdemo2.hospitalproject.Entities.Patient;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.loadtime.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import javax.xml.crypto.Data;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {


}
