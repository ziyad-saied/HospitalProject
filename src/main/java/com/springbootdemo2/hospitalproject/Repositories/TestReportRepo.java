package com.springbootdemo2.hospitalproject.Repositories;

import com.springbootdemo2.hospitalproject.Entities.TestReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestReportRepo extends JpaRepository<TestReport, Integer> {

}
