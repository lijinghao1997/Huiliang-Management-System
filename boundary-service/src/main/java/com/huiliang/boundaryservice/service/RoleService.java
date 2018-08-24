package com.huiliang.boundaryservice.service;

import entity.Role;

public interface RoleService {
    Role getByUserId(String userId);

    String getRoleIdByUserId(String userId);
}
