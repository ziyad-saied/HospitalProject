package com.springbootdemo2.hospitalproject.Repositories;

import com.springbootdemo2.hospitalproject.Entities.Records;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepo extends JpaRepository<Records, Integer> {
}
