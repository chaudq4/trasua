package com.chaudq.milktea.controller2;

import com.chaudq.milktea.model2.Hostel;
import com.chaudq.milktea.model2.Landlady;
import com.chaudq.milktea.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hostel")

public class HostelController {
    @Autowired
    private HostelService hostelService;

    @PostMapping("/landlady")
    public List<Hostel> getAllHostel(@RequestBody Landlady landlady) {
        return hostelService.getAllHostel(landlady);
    }

    @PostMapping("/insert")
    public boolean insertHostel(@RequestBody Hostel hostel) {
        return hostelService.insertHostel(hostel);
    }
}
