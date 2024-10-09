package com.springbootdemo2.hospitalproject.Repositories;

import com.springbootdemo2.hospitalproject.Entities.Bills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillsRepo extends JpaRepository<Bills, Integer> {
}
