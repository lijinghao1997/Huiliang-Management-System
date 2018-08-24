package com.huiliang.boundaryservice.mapper;

import entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
public interface RoleMapper {
    Role getByUserId(@Param("userId")String userId);

    String getRoleIdByUserId(@Param("userId")String userId);
}
