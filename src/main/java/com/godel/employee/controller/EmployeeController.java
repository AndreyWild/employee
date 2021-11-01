package com.godel.employee.controller;

import com.godel.employee.api.service.IEmployeeService;
import com.godel.employee.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        log.info("Start method showAllEmployees()");
        List<Employee> allEmployees = employeeService.findAll();
        model.addAttribute("allEmployees", allEmployees);

        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        log.info("Start method addNewEmployee()");
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        log.info("Start method saveEmployee()");
        employeeService.save(employee);

        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") Long id, Model model) {
        log.info("Start method updateEmployee()");
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") Long id) {
        log.info("Start method deleteEmployee()");
        employeeService.deleteById(id);

        return "redirect:/";
    }
}
