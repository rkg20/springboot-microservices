package net.javaguides.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    
    
}
