package com.godel.employee.service;

import com.godel.employee.api.repository.IEmployeeRepository;
import com.godel.employee.api.service.IEmployeeService;
import com.godel.employee.entity.Employee;
import com.godel.employee.exception.EmployeeNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        log.info("Start method save({})", employee);
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id) {
        log.info("Start method findById({})", id);
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with storeId: " + id));
    }

    public List<Employee> findAll() {
        log.info("Start method findAll()");
        return employeeRepository.findAll();
    }

    public Employee update(Employee employee) {
        log.info("Start method update({})", employee);
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id) {
        log.info("Start method deleteById({})", id);
        employeeRepository.deleteById(id);
    }
}
