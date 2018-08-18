package com.huiliang.authservice.mapper;

import com.huiliang.authservice.domain.Permission;
import java.util.List;

public interface PermissionMapper {
    int insert(Permission record);

    List<Permission> selectAll();
}