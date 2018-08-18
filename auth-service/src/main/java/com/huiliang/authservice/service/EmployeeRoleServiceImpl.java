package com.huiliang.authservice.service;

import com.huiliang.authservice.domain.EmployeeRole;
import com.huiliang.authservice.mapper.EmployeeRoleMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeRoleServiceImpl implements EmployeeRoleService {
    private Logger logger= LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;
    @Override
    public int add(EmployeeRole employeeRole) {
        return 0;
    }

    @Override
    public String getRoleIdByEmployeeId(String id) {
        if(StringUtils.isEmpty(id)){
            logger.error("id为空无法查询RoleId");
            return null;
        }
        return employeeRoleMapper.getRoleIdByEmployeeId(id);
    }
}
