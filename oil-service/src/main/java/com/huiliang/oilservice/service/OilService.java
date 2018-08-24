package com.huiliang.oilservice.service;

import entity.Oil;

import java.math.BigDecimal;
import java.util.List;

public interface OilService {
    Oil getByOilName(String name);
    List<Oil> getAll();
    Oil getByNo(Short no);
    int update(Short no, BigDecimal price);
    int addNewOil(Oil oil);

}
