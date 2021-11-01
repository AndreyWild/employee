package com.godel.employee.api.service;

import com.godel.employee.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee save(Employee employee);

    Employee findById(Long id);

    List<Employee> findAll();

    Employee update(Employee employee);

    void deleteById(Long id);
}
