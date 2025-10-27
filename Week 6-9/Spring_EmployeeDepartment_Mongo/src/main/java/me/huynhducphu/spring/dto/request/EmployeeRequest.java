package me.huynhducphu.spring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Admin 9/21/2025
 *
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeRequest {

    private String name;
    private double salary;
    private String departmentId;

}
