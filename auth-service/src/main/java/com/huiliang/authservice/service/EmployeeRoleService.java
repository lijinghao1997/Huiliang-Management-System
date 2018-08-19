package com.huiliang.authservice.service;

import com.huiliang.authservice.domain.EmployeeRole;

public interface EmployeeRoleService {
    int add(EmployeeRole employeeRole);
    String getRoleIdByEmployeeId(String id);
    String getRoleNameByEmployeeId(String id);
}
