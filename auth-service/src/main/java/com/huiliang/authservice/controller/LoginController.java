package com.huiliang.authservice.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.huiliang.authservice.common.JWTUtil;
import com.huiliang.authservice.common.ResponseCode;
import com.huiliang.authservice.common.ServerResponse;
import com.huiliang.authservice.domain.Employee;
import com.huiliang.authservice.service.EmployeeRoleService;
import com.huiliang.authservice.service.EmployeeService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private Logger logger= LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRoleService employeeRoleService;
    @RequestMapping("/login")
    public ServerResponse login(String username,String password){
        ServerResponse serverResponse=new ServerResponse();
        Employee employee=employeeService.getByName(username);
        if(employee==null){
            serverResponse.setStatus(ResponseCode.NOT_FOUND.getCode());
            logger.error("根据用户名%s无法查找用户",username);
            serverResponse.setMsg("根据用户名无法查找用户");
        }
        if(!StringUtils.equals(password,employee.getPassword())){
            serverResponse.setStatus(ResponseCode.ERROR.getCode());
            logger.error("用户名%s密码错误",username);
            serverResponse.setMsg("密码错误");
        }
        String roleName=employeeRoleService.getRoleNameByEmployeeId(employee.getId());
        String token= JWTUtil.sign(username,roleName,employee.getPassword());
        serverResponse.setStatus(ResponseCode.SUCCESS.getCode());
        serverResponse.setData(token);
        logger.info("用户%s登陆成功",username);
        return serverResponse;
    }

}
