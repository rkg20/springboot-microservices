package net.javaguides.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
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
import net.javaguides.department.dto.DepartmentDto;
import net.javaguides.department.service.DepartmentService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;


    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto createdDepartmentDto=departmentService.createDepartment(departmentDto);
        return new ResponseEntity<DepartmentDto>(createdDepartmentDto, HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("code") String departmentCode){
        DepartmentDto departmentDto=departmentService.getDepartmentByCode(departmentCode);
        return ResponseEntity.ok(departmentDto);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
        List<DepartmentDto> departmentDtos=departmentService.getAllDepartment();
        return ResponseEntity.ok(departmentDtos);
    }
    
    @PutMapping("/{Id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("Id") long departmentId,@RequestBody DepartmentDto departmentDto){
        DepartmentDto updatedDepartment=departmentService.updateDepartment(departmentId,departmentDto);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("Id") long departmentId){
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<String>("Department "+departmentId+" deleted Sucessfully", HttpStatus.OK);

    }
}
