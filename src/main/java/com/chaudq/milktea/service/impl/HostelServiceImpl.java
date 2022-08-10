package com.chaudq.milktea.service.impl;

import com.chaudq.milktea.db2.HostelDatabase;
import com.chaudq.milktea.model2.Hostel;
import com.chaudq.milktea.model2.Landlady;
import com.chaudq.milktea.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelServiceImpl implements HostelService {
    @Autowired
    private HostelDatabase hostelDatabase;

    @Override
    public List<Hostel> getAllHostel(Landlady landlady) {
        return hostelDatabase.getAllHostel(landlady);
    }

    @Override
    public boolean insertHostel(Hostel hostel) {
        return hostelDatabase.insertHostel(hostel);
    }
}
