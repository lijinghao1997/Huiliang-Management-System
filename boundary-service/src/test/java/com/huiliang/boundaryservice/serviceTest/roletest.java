package com.huiliang.boundaryservice.serviceTest;

import com.huiliang.boundaryservice.service.RoleService;
import entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class roletest {
    @Autowired
    private RoleService roleService;
    @Test
    public void getRole(){
        Role role=roleService.getByUserId("cc64b4fa-9789-11e8-a1b8-4053df655da2");
        System.out.println(role.toString());
    }
}
