package com.ems.fa.service;

import com.ems.fa.model.Employee;
import com.ems.fa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    // Find all employees
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    // Save or update an employee
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    // Delete an employee by ID
    public void deleteById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    // Find an employee by ID
    public Employee findById(Long employeeId) {
        Optional<Employee> result = employeeRepository.findById(employeeId);
        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        } else {
            // Handle the case where the employee is not found
            throw new RuntimeException("Did not find employee id - " + employeeId);
        }
        return employee;
    }
    // Other business logic methods as needed
}
