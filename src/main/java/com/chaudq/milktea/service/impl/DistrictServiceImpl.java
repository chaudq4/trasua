package com.chaudq.milktea.service.impl;

import com.chaudq.milktea.db2.DistrictDatabase;
import com.chaudq.milktea.model2.District;
import com.chaudq.milktea.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictDatabase districtDatabase;

    @Override
    public List<District> getAll() {
        return districtDatabase.getAll();
    }
}
