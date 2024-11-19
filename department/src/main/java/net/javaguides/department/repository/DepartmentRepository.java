package net.javaguides.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.department.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department,Long>{
    Department findByDepartmentCode(String departmentCode);
}
