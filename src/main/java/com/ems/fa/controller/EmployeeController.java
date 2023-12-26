package com.ems.fa.controller;

import com.ems.fa.model.Employee;
import com.ems.fa.model.Employee.Department;
import com.ems.fa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Method to display landing page
    @GetMapping("/")	
    public String showHomePage() {
    	return "index";
    }
    
    // Method to display the list of employees
    @GetMapping("/employees")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees"; 
    }

    // Method to display the form for adding a new employee
    @GetMapping("/add-employee")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", getDepartmentDisplayNames());
        return "add-employee"; 
    }  

    // Method to handle the submission of the add employee form
    @PostMapping("/add-employee")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees"; // Redirect after POST to prevent duplicate submissions
    }

    @PostMapping("/save-employee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "add-employee";
        }
        employeeService.save(employee);
        return "redirect:/employees";
    }  

    // Method to handle the deletion of an employee
    @GetMapping("/delete-employee")
    public String deleteEmployee(@RequestParam("employeeId") Long employeeId) {
        employeeService.deleteById(employeeId);
        return "redirect:/employees"; // Redirect to refresh the list
    }
    @GetMapping("/edit-employee")
    public String showEditEmployeeForm(@RequestParam("employeeId") Long employeeId, Model model) {
        Employee employee = employeeService.findById(employeeId);
        model.addAttribute("employee", employee);
        model.addAttribute("departments", getDepartmentDisplayNames());
        return "edit-employee";
    }
    @PostMapping("/edit-employee")
    public String editEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee); // Assuming save method handles both add and update operations
        return "redirect:/employees"; 
    }
    @GetMapping("/employee-info/{employeeId}")
    public String showEmployeeInfo(@PathVariable Long employeeId, Model model) {
        Employee employee = employeeService.findById(employeeId);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employee-info";
        } else {
            // Handle the case where the employee is not found
            // Redirect
            return "redirect:/employees";
        }
    }
    // Utility method to get department display names
    private List<String> getDepartmentDisplayNames() {
        return Arrays.stream(Employee.Department.values())
                     .map(Employee.Department::getDisplayName)
                     .collect(Collectors.toList());
    }
    
    // Other methods
}
