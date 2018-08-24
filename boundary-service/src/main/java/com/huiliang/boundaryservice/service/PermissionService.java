package com.huiliang.boundaryservice.service;

import entity.Permission;

import java.util.List;

public interface PermissionService {
    List<String> getByRoleId(String roleId);
}
