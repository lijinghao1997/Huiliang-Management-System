package com.huiliang.employeeservice.service.impl;

import com.huiliang.employeeservice.mapper.EmployeeMapper;
import com.huiliang.employeeservice.service.EmployeeService;
import entity.Employee;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Logger logger= LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int add(Employee employee) {
        if(employee==null){
            logger.error("EmployeeService无法插入，传入记录为空");
            return 0;
        }
        return employeeMapper.insert(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public Employee getByName(String name) {
        if(StringUtils.isEmpty(name)){
            logger.error("EmployeeService无法查询，用户名为空");
            return null;
        }
        return employeeMapper.selectByName(name);
    }
}
