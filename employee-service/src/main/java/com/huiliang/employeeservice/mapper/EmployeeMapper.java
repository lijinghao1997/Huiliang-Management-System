package com.huiliang.employeeservice.mapper;

import entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface EmployeeMapper {

    int insert(Employee record);

    List<Employee> selectAll();

    Employee selectByName(@Param("name") String name);

}
