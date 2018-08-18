package com.huiliang.authservice.service;

import com.huiliang.authservice.domain.Employee;

public interface EmployeeService {
    Employee getByName(String name);
}
