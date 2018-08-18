package com.huiliang.authservice.mapper;

import com.huiliang.authservice.domain.EmployeeRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeRoleMapper {
    int insert(EmployeeRole record);

    List<EmployeeRole> selectAll();

    String getRoleIdByEmployeeId(@Param("id")String id);
}