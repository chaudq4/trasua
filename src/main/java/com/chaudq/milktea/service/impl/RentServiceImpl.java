package com.chaudq.milktea.service.impl;

import com.chaudq.milktea.db2.RentDatabase;
import com.chaudq.milktea.model2.Rent;
import com.chaudq.milktea.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentServiceImpl implements RentService {
    @Autowired
    RentDatabase rentDatabase;

    @Override
    public boolean addRent(Rent rent) {
        return rentDatabase.addRent(rent);
    }

    @Override
    public Rent getRent(String idRoom) {
        return rentDatabase.getRent(idRoom);
    }
}
