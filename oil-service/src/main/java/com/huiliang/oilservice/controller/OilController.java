package com.huiliang.oilservice.controller;

import com.huiliang.oilservice.service.OilService;
import common.ServerResponse;
import common.ServerResponseFactory;
import entity.Oil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class OilController {
    @Autowired
    private OilService oilService;
    private Logger logger= LoggerFactory.getLogger(OilController.class);

    @RequestMapping("/oils")
    public ServerResponse getAll(){
        List<Oil> oilList=oilService.getAll();
        ServerResponse serverResponse=ServerResponseFactory.createSuccessResponseByData(oilList);
        return serverResponse;
    }

    @RequestMapping("/name/{name}")
    public ServerResponse getByName(@PathVariable("name") String name){
        Oil oil = oilService.getByOilName(name);
        ServerResponse serverResponse = null;
        if(oil==null) {
            serverResponse = ServerResponseFactory.createNotFound("Can not find oil by name");
        }else {
            serverResponse = ServerResponseFactory.createSuccessResponseByData(oil);
        }
        return serverResponse;
    }

    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public ServerResponse updateByOilNoAndPrice(@RequestParam("no")Short no, @RequestParam("price")BigDecimal price){
        int result=oilService.update(no, price);
        ServerResponse serverResponse=null;
        if(result==0){
            serverResponse=ServerResponseFactory.createError("Insert failed");
        }else {
            serverResponse=ServerResponseFactory.createSuccessResponseByMsg("Insert succeed");
        }
        return serverResponse;
    }

    @RequestMapping("/no/{no}")
    public ServerResponse getByNo(@PathVariable("no")Short no){
        Oil oil=oilService.getByNo(no);
        ServerResponse serverResponse=null;
        if(oil==null){
            serverResponse=ServerResponseFactory.createError("Can not find oil by no");
        }else {
            serverResponse=ServerResponseFactory.createSuccessResponseByData(oil);
        }
        return serverResponse;
    }

}
