package com.huiliang.salessituationservice.controller;

import com.huiliang.salessituationservice.service.SalesStatusService;
import common.ServerResponse;
import common.ServerResponseFactory;
import entity.SalesStatus;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class SalesStatusController {
    @Autowired
    private SalesStatusService salesStatusService;
    private Logger logger= LoggerFactory.getLogger(SalesStatusController.class);
    @RequestMapping("/getAll")
    public ServerResponse getAll(){
        List<SalesStatus> salesStatusList=salesStatusService.getAll();
        ServerResponse serverResponse= ServerResponseFactory.createSuccessResponseByData(salesStatusList);
        return serverResponse;
    }

    @RequestMapping("/getAll/{date}")
    public ServerResponse getAllByDate(@PathVariable("date")Date date){
        List<SalesStatus> salesStatuses=salesStatusService.getAllByDate(date);
        ServerResponse serverResponse=ServerResponseFactory.createSuccessResponseByData(salesStatuses);
        return serverResponse;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ServerResponse add(SalesStatus salesStatus){
        ServerResponse serverResponse=null;
        int result=salesStatusService.addStatus(salesStatus);
        if(result>0){
            serverResponse=ServerResponseFactory.createSuccessResponseByMsg("insert succeed");
        }else {
            serverResponse=ServerResponseFactory.createError("insert failed");
        }
        return serverResponse;
    }

    @RequestMapping("/")
    public ServerResponse getByOilIdAndDate(@RequestParam("date")Date date,@RequestParam("oilId")String oilId){
        ServerResponse serverResponse=null;
        if(date==null|| StringUtils.isEmpty(oilId)){
            serverResponse=ServerResponseFactory.createIllegalArgument("illegal arguments");
            return serverResponse;
        }
        SalesStatus salesStatus=salesStatusService.getByOilIdAndDate(date,oilId);
        if(salesStatus==null){
            serverResponse=ServerResponseFactory.createNotFound("can not find sales status");
        }else {
            serverResponse=ServerResponseFactory.createSuccessResponseByData(salesStatus);
        }
        return serverResponse;
    }
}
