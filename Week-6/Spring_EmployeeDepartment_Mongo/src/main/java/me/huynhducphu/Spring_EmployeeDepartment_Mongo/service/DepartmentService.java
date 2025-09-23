package me.huynhducphu.Spring_EmployeeDepartment_Mongo.service;

import me.huynhducphu.Spring_EmployeeDepartment_Mongo.dto.request.DepartmentRequest;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.dto.response.DepartmentResponse;

import java.util.List;

/**
 * Admin 9/21/2025
 *
 **/
public interface DepartmentService {
    // CREATE
    DepartmentResponse createDepartment(DepartmentRequest request);

    // READ ALL
    List<DepartmentResponse> getAllDepartments();

    // READ by ID
    DepartmentResponse getDepartmentById(String id);

    // UPDATE
    DepartmentResponse updateDepartment(String id, DepartmentRequest request);

    // DELETE
    void deleteDepartment(String id);
}
