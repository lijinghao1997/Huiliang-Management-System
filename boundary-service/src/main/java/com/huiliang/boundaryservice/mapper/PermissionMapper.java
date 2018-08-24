package com.huiliang.boundaryservice.mapper;

import entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface PermissionMapper {
    List<String> getByRoleId(@Param("roleId")String roleId);
}
