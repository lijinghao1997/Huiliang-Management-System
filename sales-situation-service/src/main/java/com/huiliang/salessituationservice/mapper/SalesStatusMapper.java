package com.huiliang.salessituationservice.mapper;

import entity.SalesStatus;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SalesStatusMapper {

    int insert(SalesStatus record);

    List<SalesStatus> selectAll();

    List<SalesStatus> getByDate(@Param("date") Date date);

    SalesStatus getByOilIdAndCreateDate(@Param("date") Date date, String oilId);


}
