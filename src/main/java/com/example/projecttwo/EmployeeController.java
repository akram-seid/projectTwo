package com.example.projecttwo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getEmployees(){
        return new ResponseEntity<>(employeeService.findLaptops(),HttpStatus.OK);
    }

   }
