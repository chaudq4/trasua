package com.chaudq.milktea.service.impl;

import com.chaudq.milktea.db2.FeeDatabase;
import com.chaudq.milktea.model2.Fee;
import com.chaudq.milktea.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeeServiceImpl implements FeeService {
    @Autowired
    FeeDatabase feeDatabase;

    @Override
    public boolean addFee(Fee fee) {
        return feeDatabase.addFee(fee);
    }
}
