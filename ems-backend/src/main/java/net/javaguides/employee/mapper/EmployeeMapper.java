package net.javaguides.employee.mapper;

import net.javaguides.employee.dto.EmployeeDto;
import net.javaguides.employee.entity.Employee;

public class EmployeeMapper {
    
    public static EmployeeDto maptoEmployeeDto(Employee employee){
        return new EmployeeDto(
            employee.getEmployeeId(),
            employee.getEmployeeFirstName(),
            employee.getEmployeeLastName(),
            employee.getEmployeeEmail(),
            employee.getDepartmentCode()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
            employeeDto.getEmployeeId(),
            employeeDto.getEmployeeFirstName(),
            employeeDto.getEmployeeLastName(),
            employeeDto.getEmployeeEmail(),
            employeeDto.getDepartmentCode()
        );
    }
}
