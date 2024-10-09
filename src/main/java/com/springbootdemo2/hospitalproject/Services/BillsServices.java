package com.springbootdemo2.hospitalproject.Services;
import com.springbootdemo2.hospitalproject.Entities.Bills;
import com.springbootdemo2.hospitalproject.Repositories.BillsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillsServices {

    @Autowired
    private BillsRepo billsRepo;

    //Get All Bills
    public List<Bills> getAllBills() {
        return billsRepo.findAll();
    }
    //Get Bill By Id
    public Bills getBillById(int id) {
        return billsRepo.findById(id).get();
    }
    //Delete A Bill By Id
    public void DeleteBillById(int id) {
        billsRepo.deleteById(id);
    }
    //Insert Bill
    public Bills AddBill(Bills bills) {
        return billsRepo.save(bills);

    }
    //Update Bill By Id
    public Bills updateBill(Integer id,Bills bills) {
        Optional<Bills> optionalBills = billsRepo.findById(id);
        if (optionalBills.isPresent()) {
            Bills bills1 = optionalBills.get();
            if(bills.getPid()!=null)
                bills1.setPid(bills.getPid());
            if(bills.getBid()!=null)
                bills1.setBid(bills.getBid());
            if(bills.getAmount()!=0.0)
                bills1.setAmount(bills.getAmount());
            return billsRepo.save(bills1);
        }
        else {
            return null;
        }
    }
}
