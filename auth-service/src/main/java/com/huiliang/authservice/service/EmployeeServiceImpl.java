package com.huiliang.authservice.service;

import com.huiliang.authservice.domain.Employee;
import com.huiliang.authservice.mapper.EmployeeMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Logger logger= LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public Employee getByName(String name) {
        if(StringUtils.isEmpty(name)){
            logger.error("用户名为空无法查询员工");
            return null;
        }
        return employeeMapper.getByName(name);
    }
}
