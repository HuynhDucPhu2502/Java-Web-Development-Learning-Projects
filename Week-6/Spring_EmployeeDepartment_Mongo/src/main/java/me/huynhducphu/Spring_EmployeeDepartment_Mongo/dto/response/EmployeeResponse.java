package me.huynhducphu.Spring_EmployeeDepartment_Mongo.dto.response;

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
public class EmployeeResponse {
    private String id;
    private String name;
    private double salary;
    private String departmentName;
    private String departmentId;
    private double age;
}
