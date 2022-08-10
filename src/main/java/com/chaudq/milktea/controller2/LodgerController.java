package com.chaudq.milktea.controller2;

import com.chaudq.milktea.model2.Lodger;
import com.chaudq.milktea.service.LodgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lodger")
public class LodgerController {
    @Autowired
    private LodgerService lodgerService;

    @PostMapping("/search")
    public List<Lodger> searchLodgerByName(@RequestBody  String name){
        return lodgerService.searchLodgerByName(name);
    }
}
