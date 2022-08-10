package com.chaudq.milktea.controller2;

import com.chaudq.milktea.model2.Rent;
import com.chaudq.milktea.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rent")
public class RentController {
    @Autowired
    RentService rentService;

    @PostMapping("/add")
    public boolean addRent(@RequestBody Rent rent) {
        return rentService.addRent(rent);
    }

    @PostMapping("/get")
    public Rent getRent(@RequestBody String idRoom) {
        return rentService.getRent(idRoom);
    }
}
