package com.chaudq.milktea.service;

import com.chaudq.milktea.model2.Rent;

public interface RentService {
    boolean addRent(Rent rent);
    Rent getRent(String idRoom);
}
