package com.appdemo.employeemanager.controller;

import com.appdemo.employeemanager.model.Employee;
import com.appdemo.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllEmployees(){
        return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.findEmployeeById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
