package net.javaguides.employee.service;

import java.util.List;

import net.javaguides.employee.dto.APIResponseDto;
import net.javaguides.employee.dto.EmployeeDto;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public APIResponseDto getEmployeeById(long employeeId);
    public List<EmployeeDto> getAllEmployee();
    public EmployeeDto updateEmployee(long employeeId,EmployeeDto employeeDto);
    public void deleteEmployee(long employeeId);
}
