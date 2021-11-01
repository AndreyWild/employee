package com.godel.employee.service;

import com.godel.employee.api.repository.IEmployeeRepository;
import com.godel.employee.api.service.IEmployeeService;
import com.godel.employee.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeServiceTest {

    @Mock
    private IEmployeeRepository employeeRepository;

    @InjectMocks
    private IEmployeeService employeeService = new EmployeeService();

    private Employee employee;

    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setId(8L);
        employees = new ArrayList<>();
        employees.add(employee);
    }

    @Test
    void save() {
        when(employeeRepository.save(ArgumentMatchers.any(Employee.class))).thenReturn(employee);
        Employee result = employeeService.save(new Employee());
        assertEquals(result.getId(), 8L);
        verify(employeeRepository).save(ArgumentMatchers.any(Employee.class));
    }

    @Test
    void findById() {
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.ofNullable(employee));
        Employee result = employeeService.findById(8L);
        assertEquals(result.getId(), 8L);
        verify(employeeRepository).findById(anyLong());
    }

    @Test
    void findAll() {
        when(employeeRepository.findAll()).thenReturn(employees);
        List<Employee> result = employeeService.findAll();
        assertEquals(result.get(0).getId(), 8L);
        verify(employeeRepository).findAll();
    }

    @Test
    void update() {
        when(employeeRepository.save(ArgumentMatchers.any(Employee.class))).thenReturn(employee);
        Employee result = employeeService.update(new Employee());
        assertEquals(result.getId(), 8L);
        verify(employeeRepository).save(ArgumentMatchers.any(Employee.class));
    }

    @Test
    void deleteById() {
        employeeService.deleteById(1L);
        verify(employeeRepository).deleteById(anyLong());
    }
}