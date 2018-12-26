package com.wadedwyane.www.impl;

import com.wadedwyane.www.entity.Employee;

public interface IEmployeeService {

    void insertEmployee(Employee employee);

    void deleteEmployeeById(Long id);
}
