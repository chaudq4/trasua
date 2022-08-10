package com.chaudq.milktea.service.impl;

import com.chaudq.milktea.db2.BillDatabase;
import com.chaudq.milktea.model2.Bill;
import com.chaudq.milktea.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillDatabase billDatabase;

    @Override
    public boolean addBill(Bill bill) {
        return billDatabase.addBill(bill);
    }
}
