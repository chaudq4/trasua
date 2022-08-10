package com.chaudq.milktea.service.impl;

import com.chaudq.milktea.db2.LandladyDatabase;
import com.chaudq.milktea.model2.Account;
import com.chaudq.milktea.model2.Landlady;
import com.chaudq.milktea.service.LandladyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LandladyServiceImp implements LandladyService {
    @Autowired
    private LandladyDatabase landladyDatabase;
    @Override
    public Landlady login(Account account) {
        return landladyDatabase.login(account);
    }

    @Override
    public boolean register(Account account) {
        return landladyDatabase.register(account);
    }

    @Override
    public boolean updateInfo(Landlady landlady) {
        return landladyDatabase.updateInfo(landlady);
    }
}
