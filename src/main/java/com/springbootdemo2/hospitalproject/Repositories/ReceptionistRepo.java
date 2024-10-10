package com.springbootdemo2.hospitalproject.Repositories;

import com.springbootdemo2.hospitalproject.Entities.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionistRepo extends JpaRepository<Receptionist, Integer> {
}
