package net.javaguides.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private long employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeEmail;
    private String departmentCode;
}
