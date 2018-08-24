package com.huiliang.salessituationservice.service;

import entity.SalesStatus;

import java.util.Date;
import java.util.List;

public interface SalesStatusService {
    List<SalesStatus> getAll();
    List<SalesStatus> getAllByDate(Date date);
    SalesStatus getByOilIdAndDate(Date date, String oilId);
    int addStatus(SalesStatus salesStatus);
}
