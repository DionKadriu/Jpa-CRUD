package com.luv2code.springboot.cruddemo.restController;


import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //quick and dirt injection of the employee dao
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //expose the endpoint that return all the employees

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new EmployeeNotFound("Employee with id " + employeeId + "was not found");
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }

    //add mapping for updating an employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteById(@PathVariable int employeeId) {
        Employee tempEmoloyee = employeeService.findById(employeeId);
        if (tempEmoloyee == null) {
            throw new EmployeeNotFound("the employee does not exist in the database");
        }
        employeeService.deleteById(employeeId);
        return "deleted the customer with the employee id of " + employeeId;
    }
}
