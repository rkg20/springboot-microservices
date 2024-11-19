package net.javaguides.employee.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import net.javaguides.employee.dto.APIResponseDto;
import net.javaguides.employee.dto.DepartmentDto;
import net.javaguides.employee.dto.EmployeeDto;
import net.javaguides.employee.entity.Employee;
import net.javaguides.employee.exception.ResourceNotFoundException;
import net.javaguides.employee.mapper.EmployeeMapper;
import net.javaguides.employee.repository.EmployeeRepository;
import net.javaguides.employee.service.APIClient;
import net.javaguides.employee.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    
    private EmployeeRepository employeeRepository;

    // private RestTemplate restTemplate;
    // private WebClient webClient;

    private APIClient apiClient;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        
        Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public APIResponseDto getEmployeeById(long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with given Id"+employeeId));

        // ResponseEntity<DepartmentDto> responseEntity=restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);

        // DepartmentDto departmentDto=responseEntity.getBody();

        // DepartmentDto departmentDto=webClient.get()
        //         .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
        //         .retrieve()
        //         .bodyToMono(DepartmentDto.class)
        //         .block();

        DepartmentDto departmentDto=apiClient.getDepartment(employee.getDepartmentCode());

        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setEmployee(EmployeeMapper.maptoEmployeeDto(employee));
        return apiResponseDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees=employeeRepository.findAll();
        
        return employees.stream().map((employee)->EmployeeMapper.maptoEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(long employeeId, EmployeeDto employeeDto) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee Id is not exist"+employeeId));

        employee.setEmployeeFirstName(employeeDto.getEmployeeFirstName());
        employee.setEmployeeLastName(employeeDto.getEmployeeLastName());
        employee.setEmployeeEmail(employeeDto.getEmployeeEmail());

        Employee updatedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(updatedEmployee);
        
    }

    @Override
    public void deleteEmployee(long employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee Id doesn't exist"+employeeId));
        
        employeeRepository.deleteById(employeeId);
        
    }
    
}
