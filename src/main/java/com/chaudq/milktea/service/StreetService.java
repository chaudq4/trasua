package com.chaudq.milktea.service;

import com.chaudq.milktea.model2.Street;

import java.util.List;

public interface StreetService {
    List<Street> getAllByIDDistrict(String idDistrict);

}
