package me.huynhducphu.spring.dto;

import lombok.Data;

/**
 * Admin 10/4/2025
 *
 **/
@Data
public class EmployeeCreateDto {
    private String name;
    private int age;
    private double salary;
    private Long departmentId;
}