package com.huiliang.authservice.mapper;

import com.huiliang.authservice.domain.RolePermission;
import java.util.List;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    List<RolePermission> selectAll();
}