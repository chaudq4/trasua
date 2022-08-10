package com.chaudq.milktea.controller2;

import com.chaudq.milktea.model2.Fee;
import com.chaudq.milktea.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fee")
public class FeeController {
    @Autowired
    FeeService feeService;

    @PostMapping("/add")
    public boolean addFee(@RequestBody Fee fee) {
        return feeService.addFee(fee);
    }
}
