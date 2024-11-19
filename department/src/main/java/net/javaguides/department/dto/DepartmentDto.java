package net.javaguides.department.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentDto {

    private long departmentId;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

}
