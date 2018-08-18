package com.huiliang.authservice.mapper;

import com.huiliang.authservice.domain.Role;
import java.util.List;

public interface RoleMapper {
    int insert(Role record);

    List<Role> selectAll();
}