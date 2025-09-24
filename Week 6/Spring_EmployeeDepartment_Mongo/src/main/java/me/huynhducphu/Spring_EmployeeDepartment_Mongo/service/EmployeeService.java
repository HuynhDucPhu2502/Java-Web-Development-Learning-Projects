package me.huynhducphu.Spring_EmployeeDepartment_Mongo.service;

import me.huynhducphu.Spring_EmployeeDepartment_Mongo.dto.request.EmployeeRequest;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.dto.response.EmployeeResponse;

import java.util.List;

/**
 * Admin 9/21/2025
 *
 **/
public interface EmployeeService {
    // CREATE
    EmployeeResponse createEmployee(EmployeeRequest request);

    // READ ALL
    List<EmployeeResponse> getAllEmployees();

    // READ by ID
    EmployeeResponse getEmployeeById(String id);

    // UPDATE
    EmployeeResponse updateEmployee(String id, EmployeeRequest request);

    // DELETE
    void deleteEmployee(String id);

    List<EmployeeResponse> getHighestSalaryOrAge();
}
