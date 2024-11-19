package net.javaguides.employee.controller;

import java.util.List;
import java.lang.String;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import net.javaguides.employee.dto.APIResponseDto;
import net.javaguides.employee.dto.EmployeeDto;
import net.javaguides.employee.service.EmployeeService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;



    // Add Employee Rest API
    @PostMapping
    public ResponseEntity<EmployeeDto>  createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<EmployeeDto>(savedEmployeeDto, HttpStatus.CREATED);
    }
    
    // Get Employee By Id  
    @GetMapping("/{Id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("Id") long Id){
        APIResponseDto apiResponseDto=employeeService.getEmployeeById(Id);
        return ResponseEntity.ok(apiResponseDto);
    }

    // Get All Employees 
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employeeDtos=employeeService.getAllEmployee();
        return new ResponseEntity<List<EmployeeDto>>(employeeDtos,HttpStatus.OK);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("Id") long employeeId, @RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedEmployeeDto=employeeService.updateEmployee(employeeId, employeeDto);
        return ResponseEntity.ok(updatedEmployeeDto);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("Id") long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully");
    }
}
