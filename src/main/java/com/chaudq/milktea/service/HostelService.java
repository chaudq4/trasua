package com.chaudq.milktea.service;

import com.chaudq.milktea.model2.Hostel;
import com.chaudq.milktea.model2.Landlady;

import java.util.List;

public interface HostelService {
    List<Hostel> getAllHostel(Landlady landlady);
    boolean insertHostel(Hostel hostel);
}
