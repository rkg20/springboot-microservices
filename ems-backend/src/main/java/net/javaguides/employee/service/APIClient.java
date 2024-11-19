package net.javaguides.employee.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.employee.dto.DepartmentDto;

// @FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
//Adding DEPARTMENT-SERVICE	for load balancer 
@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("/api/departments/{code}")
    public DepartmentDto getDepartment(@PathVariable("code") String departmentCode);

}
