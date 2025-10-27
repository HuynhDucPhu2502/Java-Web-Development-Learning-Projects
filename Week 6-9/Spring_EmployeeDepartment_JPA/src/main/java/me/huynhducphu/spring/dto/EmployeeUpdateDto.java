package me.huynhducphu.spring.dto;

import lombok.Data;

/**
 * Admin 10/4/2025
 *
 **/
@Data
public class EmployeeUpdateDto {
    private String name;
    private Integer age;
    private Double salary;
    private Long departmentId;
}