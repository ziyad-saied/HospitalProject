package com.springbootdemo2.hospitalproject.Services;

import com.springbootdemo2.hospitalproject.Entities.TestReport;
import com.springbootdemo2.hospitalproject.Repositories.TestReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestReportServices {

    @Autowired
    private TestReportRepo testReportRepo;

    //Add Report
    public TestReport addTestReport(TestReport testReport) {
        return testReportRepo.save(testReport);
    }

    //Get All Reports
    public List<TestReport> getAllTestReports() {
        return testReportRepo.findAll();
    }

    //Get Report By Patient Id
    public TestReport getTestReportById(int id) {
        return testReportRepo.findById(id).get();
    }

    //Update Report By Id
    public TestReport updateTestReport(int id, TestReport testReport) {
        Optional<TestReport> testReportOptional = testReportRepo.findById(id);
        if(testReportOptional.isPresent()) {
            TestReport testReport1 = testReportOptional.get();
            if(testReport.getPId()!=null)
                testReport1.setPId(testReport.getPId());
            if(testReport.getTest_type()!=null)
                testReport1.setTest_type(testReport.getTest_type());
            if(testReport.getResult()!=null)
                testReport1.setResult(testReport.getResult());
            return testReportRepo.save(testReport1);
        }
        else
            return null;
    }

    //Delete Report By Id
    public void deleteTestReport(int id) {
        testReportRepo.deleteById(id);
    }

    //Delete All Reports
    public void deleteAllReports(){
        this.testReportRepo.deleteAll();
    }
}
