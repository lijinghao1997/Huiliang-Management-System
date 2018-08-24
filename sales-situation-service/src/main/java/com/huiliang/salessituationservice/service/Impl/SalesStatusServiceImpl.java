package com.huiliang.salessituationservice.service.Impl;

import com.huiliang.salessituationservice.mapper.SalesStatusMapper;
import com.huiliang.salessituationservice.service.SalesStatusService;
import entity.SalesStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class SalesStatusServiceImpl implements SalesStatusService {
    @Autowired
    private SalesStatusMapper salesStatusMapper;
    private Logger logger= LoggerFactory.getLogger(SalesStatusServiceImpl.class);
    @Override
    public List<SalesStatus> getAll() {
        return salesStatusMapper.selectAll();
    }

    @Override
    public List<SalesStatus> getAllByDate(Date date) {
        if(date==null){
            logger.error("can not query because date is null");
            return null;
        }
        return salesStatusMapper.getByDate(date);
    }

    @Override
    public SalesStatus getByOilIdAndDate(Date date, String oilId) {
        if(date==null||oilId==null){
            logger.error("can not query because parameters are illegal");
            return null;
        }
        return salesStatusMapper.getByOilIdAndCreateDate(date,oilId);
    }

    @Override
    public int addStatus(SalesStatus salesStatus) {
        if(salesStatus==null){
            logger.error("can not insert record because record is null");
            return 0;
        }
        return salesStatusMapper.insert(salesStatus);
    }
}
