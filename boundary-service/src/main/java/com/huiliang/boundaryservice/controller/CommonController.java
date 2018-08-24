package com.huiliang.boundaryservice.controller;

import com.huiliang.boundaryservice.remote.EmployeeRemote;
import com.huiliang.boundaryservice.service.RoleService;
import common.ServerResponse;
import common.ServerResponseFactory;
import entity.Employee;
import entity.Role;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import util.JWTUtil;
import util.MapToEntityUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@RestController
public class CommonController {
    private Logger logger= LoggerFactory.getLogger(CommonController.class);
    @Autowired
    private EmployeeRemote employeeRemote;
    @Autowired
    private RoleService roleService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ServerResponse login(@RequestParam("username")String username,@RequestParam("password")String password){
        ServerResponse userinfo=employeeRemote.getByName(username);
        ServerResponse response=null;
        Map data=(Map)userinfo.getData();
        String currentPassword=(String)data.get("password");
        if(data==null||data.size()==0){
            logger.error("用户名不存在");
            response= ServerResponseFactory.createNotFound("用户名不存在");
            return response;
        }
        if(!StringUtils.equals(currentPassword,password)){
            logger.error("%s用户密码错误",username);
            response=ServerResponseFactory.createIllegalArgument("密码错误");
            return response;
        }
        String userId=(String)data.get("id");
        Role role=roleService.getByUserId(userId);
        if(role==null){
            logger.error("用户%s无权限",userId);
            response=ServerResponseFactory.createError("该用户无权限");
        }else {
            String token= JWTUtil.sign(username,role.getName(),password);
            logger.info("%s登陆成功");
            response=ServerResponseFactory.createSuccessResponseByDataAndMsg(token,"登陆成功");
        }
        return response;
    }
}

