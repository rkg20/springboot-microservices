package net.javaguides.department.service;

import java.util.List;

import net.javaguides.department.dto.DepartmentDto;

public interface DepartmentService {
    public DepartmentDto createDepartment(DepartmentDto departmentDto);
    public DepartmentDto getDepartmentByCode(String departmentCode);
    public List<DepartmentDto> getAllDepartment();
    public DepartmentDto updateDepartment(long departmentId,DepartmentDto departmentDto);
    public void deleteDepartment(long departmentId);
    
}
