package com.huiliang.boundaryservice.serviceTest;

import com.huiliang.boundaryservice.remote.EmployeeRemote;
import com.huiliang.boundaryservice.service.RoleService;
import com.netflix.discovery.converters.Auto;
import common.ServerResponse;
import entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class roletest {
    @Autowired
    private RoleService roleService;
    @Autowired
    private EmployeeRemote employeeRemote;
    @Test
    public void getRole(){
        ServerResponse serverResponse=employeeRemote.getByName("黎竞豪");
        Map data=(Map)serverResponse.getData();
        System.out.println(data.get("id"));

    }

}
