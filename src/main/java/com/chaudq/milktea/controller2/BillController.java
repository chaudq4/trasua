package com.chaudq.milktea.controller2;

import com.chaudq.milktea.model2.Bill;
import com.chaudq.milktea.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    BillService billService;

    @PostMapping("/add")
    public boolean addBill(@RequestBody Bill bill) {
        return billService.addBill(bill);
    }
}
