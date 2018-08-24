package com.huiliang.boundaryservice.controller;

import com.huiliang.boundaryservice.remote.EmployeeRemote;
import common.ServerResponse;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRemote employeeRemote;
    @RequestMapping("/getAll")
    public ServerResponse getAll(){
        return employeeRemote.getAll();
    }
    @RequestMapping("/employee")
    public ServerResponse add(Employee employee){
        return employeeRemote.add(employee);
    }
    @RequestMapping("/")
    public ServerResponse getByName(@RequestParam("name")String name){
        return employeeRemote.getByName(name);
    }
}
