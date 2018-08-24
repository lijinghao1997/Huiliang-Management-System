package com.huiliang.boundaryservice.remote;

import common.ServerResponse;
import entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("Employee-Service")
@Component
public interface EmployeeRemote {
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    ServerResponse add(Employee employee);

    @RequestMapping(value = "/employees")
    ServerResponse getAll();

    @RequestMapping(value = "/")
    ServerResponse getByName(@RequestParam("name") String name);

}
