package com.huiliang.employeeservice.controller;

import com.huiliang.employeeservice.service.EmployeeService;
import common.ResponseCode;
import common.ServerResponse;
import common.ServerResponseFactory;
import entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {
    private Logger logger= LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public ServerResponse add(@RequestBody Employee employee){
        ServerResponse serverResponse=new ServerResponse();
        int result=employeeService.add(employee);
        if(result>0){
            serverResponse.setStatus(ResponseCode.SUCCESS.getCode());
            serverResponse.setMsg("新增雇员成功");
        }else {
            serverResponse.setStatus(ResponseCode.ERROR.getCode());
            serverResponse.setMsg("新增雇员失败");
            logger.error("新增雇员插入失败");
        }
        return serverResponse;
    }

    @RequestMapping(value = "/employees")
    public ServerResponse getAll(){
        List<Employee> employeeList=employeeService.getAll();
        ServerResponse serverResponse= ServerResponseFactory.createSuccessResponseByData(employeeList);
        return serverResponse;
    }

    @RequestMapping(value = "/")
    public ServerResponse getByName(@RequestParam("name") String name){
        ServerResponse serverResponse=new ServerResponse();
        Employee employee=employeeService.getByName(name);
        if(employee==null){
            serverResponse.setStatus(ResponseCode.NOT_FOUND.getCode());
            serverResponse.setMsg("根据用户名无法查找用户");
            logger.error("根据用户%s无法查找用户");
            return serverResponse;
        }
        serverResponse.setStatus(ResponseCode.SUCCESS.getCode());
        serverResponse.setData(employee);
        return serverResponse;
    }

}
