package net.javaguides.department.mapper;

import net.javaguides.department.dto.DepartmentDto;
import net.javaguides.department.entity.Department;

public class DepartmentMapper {
    
    public static DepartmentDto mapToDeparmentDto(Department department){
        return new DepartmentDto(
            department.getDepartmentId(),
            department.getDepartmentName(),
            department.getDepartmentDescription(),
            department.getDepartmentCode()
        );
    }

    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
            departmentDto.getDepartmentId(),
            departmentDto.getDepartmentName(),
            departmentDto.getDepartmentDescription(),
            departmentDto.getDepartmentCode()
        );
    }
}
