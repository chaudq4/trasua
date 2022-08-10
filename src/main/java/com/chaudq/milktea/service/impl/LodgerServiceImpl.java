package com.chaudq.milktea.service.impl;

import com.chaudq.milktea.db2.LodgerDatabase;
import com.chaudq.milktea.model2.Lodger;
import com.chaudq.milktea.service.LodgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LodgerServiceImpl implements LodgerService {
    @Autowired
    private LodgerDatabase lodgerDatabase;
    @Override
    public List<Lodger> searchLodgerByName(String name) {
        return lodgerDatabase.searchLodgerByName(name);
    }
}
