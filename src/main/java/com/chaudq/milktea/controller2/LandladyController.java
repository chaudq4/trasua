package com.chaudq.milktea.controller2;

import com.chaudq.milktea.model2.Account;
import com.chaudq.milktea.model2.Landlady;
import com.chaudq.milktea.service.LandladyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/landlady")
public class LandladyController {
    @Autowired
    private LandladyService landladyService;

    @PostMapping("/login")
    public Landlady login(@RequestBody Account account) {
        return landladyService.login(account);
    }

    @PostMapping("/register")
    public boolean register(@RequestBody Account account) {
        return landladyService.register(account);
    }

    @PostMapping("/updateinfo")
    public boolean updateInfo(@RequestBody Landlady landlady) {
        return landladyService.updateInfo(landlady);
    }
}
