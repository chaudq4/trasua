package com.chaudq.milktea.service;

import com.chaudq.milktea.model2.Lodger;

import java.util.List;

public interface LodgerService {
    List<Lodger> searchLodgerByName(String name);
}
