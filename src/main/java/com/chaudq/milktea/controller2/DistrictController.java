package com.chaudq.milktea.controller2;

import com.chaudq.milktea.model2.District;
import com.chaudq.milktea.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    private DistrictService districtService;
    @GetMapping("/getall")
    public List<District> getAllDistrict(){
        return  districtService.getAll();
    }
}
