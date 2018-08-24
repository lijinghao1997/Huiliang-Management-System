package com.huiliang.boundaryservice.remote;

import common.ServerResponse;
import entity.SalesStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
@FeignClient("Sales-Service")
@Component
public interface SalesStatusRemote {
    @RequestMapping("/getAll")
    ServerResponse getAll();

    @RequestMapping("/getAll/{date}")
    ServerResponse getAllByDate(@PathVariable("date")Date date);

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    ServerResponse add(SalesStatus salesStatus);

    @RequestMapping("/")
    ServerResponse getByOilIdAndDate(@RequestParam("date")Date date, @RequestParam("oilId")String oilId);

}
