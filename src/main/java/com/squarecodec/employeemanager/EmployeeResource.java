package com.squarecodec.employeemanager;

import com.squarecodec.employeemanager.model.Employee;
import com.squarecodec.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(
                employeeService.findAllEmployee(),
                HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> findEmployeeById(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(
                employeeService.findEmployeeById(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(
            @RequestBody Employee employee
    ) {
        return new ResponseEntity<>(
                employeeService.addEmployee(employee),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(
            @RequestBody Employee employee
    ) {
        return new ResponseEntity<>(
                employeeService.updateEmployee(employee),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
