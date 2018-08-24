package com.huiliang.boundaryservice.remote;

import common.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
@FeignClient("Oil-Servce")
@Component
public interface OilRemote {
    @RequestMapping("/oils")
    public ServerResponse getAll();

    @RequestMapping("/name/{name}")
    public ServerResponse getByName(@PathVariable("name") String name);


    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public ServerResponse updateByOilNoAndPrice(@RequestParam("no")Short no, @RequestParam("price")BigDecimal price);

    @RequestMapping("/no/{no}")
    public ServerResponse getByNo(@PathVariable("no")Short no);
}
