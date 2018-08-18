package com.huiliang.authservice.mapper;

import com.huiliang.authservice.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int insert(Employee record);
    List<Employee> selectAll();

    Employee getByName(@Param("name")String name);
}