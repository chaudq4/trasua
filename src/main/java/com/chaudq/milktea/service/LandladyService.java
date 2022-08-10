package com.chaudq.milktea.service;

import com.chaudq.milktea.model2.Account;
import com.chaudq.milktea.model2.Landlady;

public interface LandladyService {
    Landlady login(Account account);
    boolean register(Account account);
    boolean updateInfo(Landlady landlady);
}
