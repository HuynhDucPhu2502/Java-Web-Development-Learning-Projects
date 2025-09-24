package me.huynhducphu.Spring_EmployeeDepartment_Mongo;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.model.Department;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.model.Employee;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.repository.DepartmentRepository;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Admin 9/21/2025
 *
 **/
@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final DepartmentRepository departmentRepo;
    private final EmployeeRepository employeeRepo;

    @Override
    public void run(String... args) throws Exception {
        if (departmentRepo.count() == 0 && employeeRepo.count() == 0) {
            // Tạo và lưu phòng ban
            Department it = departmentRepo.save(new Department(null, "IT"));
            Department hr = departmentRepo.save(new Department(null, "HR"));
            Department finance = departmentRepo.save(new Department(null, "Finance"));
            Department marketing = departmentRepo.save(new Department(null, "Marketing"));
            Department sales = departmentRepo.save(new Department(null, "Sales"));
            Department operations = departmentRepo.save(new Department(null, "Operations"));

            // Tạo danh sách nhân viên (có tuổi)
            List<Employee> employees = List.of(
                    new Employee(null, "Nguyen Van A", 1200, 25, it),
                    new Employee(null, "Tran Thi B", 1500, 28, it),
                    new Employee(null, "Le Van C", 1000, 30, hr),
                    new Employee(null, "Pham Thi D", 1800, 27, hr),
                    new Employee(null, "Hoang Van E", 2500, 35, finance),
                    new Employee(null, "Vo Thi F", 2300, 29, finance),
                    new Employee(null, "Dang Van G", 2100, 32, marketing),
                    new Employee(null, "Nguyen Thi H", 1950, 26, marketing),
                    new Employee(null, "Phan Van I", 1700, 31, sales),
                    new Employee(null, "Bui Thi J", 1600, 24, sales),
                    new Employee(null, "Do Van K", 2800, 40, operations),
                    new Employee(null, "Trinh Thi L", 2000, 33, operations),
                    new Employee(null, "Nguyen Van M", 900, 22, it),
                    new Employee(null, "Tran Van N", 1400, 29, hr),
                    new Employee(null, "Le Thi O", 2200, 34, finance),
                    new Employee(null, "Pham Van P", 1750, 28, marketing),
                    new Employee(null, "Hoang Thi Q", 1550, 23, sales),
                    new Employee(null, "Vo Van R", 2600, 37, operations),
                    new Employee(null, "Dang Thi S", 1100, 21, it),
                    new Employee(null, "Nguyen Van T", 1350, 27, hr)
            );

            employeeRepo.saveAll(employees);
        }
    }


}
