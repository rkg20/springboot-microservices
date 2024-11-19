package net.javaguides.department.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.department.dto.DepartmentDto;
import net.javaguides.department.entity.Department;
import net.javaguides.department.exception.ResourceNotFoundException;
import net.javaguides.department.mapper.DepartmentMapper;
import net.javaguides.department.repository.DepartmentRepository;
import net.javaguides.department.service.DepartmentService;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department=DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment=departmentRepository.save(department);
        return DepartmentMapper.mapToDeparmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department=departmentRepository.findByDepartmentCode(departmentCode);
        return DepartmentMapper.mapToDeparmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {

        List<Department> departments=departmentRepository.findAll();
        return departments.stream().map((department)-> DepartmentMapper.mapToDeparmentDto(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(long departmentId,DepartmentDto departmentDto){
        Department department=departmentRepository.findById(departmentId).orElseThrow(()-> new ResourceNotFoundException("Department Id not exist"+departmentId));

        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        department.setDepartmentCode(departmentDto.getDepartmentCode());

        Department savedDepartment=departmentRepository.save(department);
        return DepartmentMapper.mapToDeparmentDto(savedDepartment);
    }

    public void deleteDepartment(long departmentId){

        departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Deparment is not exits"+departmentId));

        departmentRepository.deleteById(departmentId);

    }


}
