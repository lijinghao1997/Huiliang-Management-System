package com.huiliang.employeeservice.service;

import entity.Employee;

import java.util.List;

public interface EmployeeService {
    int add(Employee employee);
    List<Employee> getAll();
    Employee getByName(String name);
}
