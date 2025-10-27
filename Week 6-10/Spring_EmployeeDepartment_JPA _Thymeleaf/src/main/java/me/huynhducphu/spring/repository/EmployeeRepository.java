package me.huynhducphu.spring.repository;

import me.huynhducphu.spring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Admin 9/16/2025
 *
 **/
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findEmployeeByNameContainingIgnoreCase(String name);

    List<Employee> findEmployeeBySalaryBetween(double salaryAfter, double salaryBefore);

    List<Employee> findByAge(int age);

    List<Employee> findEmployeeByDepartmentId(Long departmentId);

    // 🔍 Tìm kiếm theo tên và phòng ban
    @Query("SELECT e FROM Employee e WHERE " +
            "LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "AND (:deptId IS NULL OR e.department.id = :deptId)")
    List<Employee> searchByNameAndDepartment(@Param("keyword") String keyword,
                                             @Param("deptId") Long deptId);

    // 🔍 Tìm kiếm theo khoảng tuổi và khoảng lương
    @Query("SELECT e FROM Employee e WHERE " +
            "(:minAge IS NULL OR e.age >= :minAge) AND " +
            "(:maxAge IS NULL OR e.age <= :maxAge) AND " +
            "(:minSalary IS NULL OR e.salary >= :minSalary) AND " +
            "(:maxSalary IS NULL OR e.salary <= :maxSalary)")
    List<Employee> searchByAgeAndSalaryRange(@Param("minAge") Integer minAge,
                                             @Param("maxAge") Integer maxAge,
                                             @Param("minSalary") Double minSalary,
                                             @Param("maxSalary") Double maxSalary);

    // 🔍 Tìm kiếm tổng hợp nhiều tiêu chí
    @Query("SELECT e FROM Employee e WHERE " +
            "(:name IS NULL OR LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:age IS NULL OR e.age = :age) AND " +
            "(:minSalary IS NULL OR e.salary >= :minSalary) AND " +
            "(:maxSalary IS NULL OR e.salary <= :maxSalary) AND " +
            "(:deptId IS NULL OR e.department.id = :deptId)")
    List<Employee> advancedSearch(@Param("name") String name,
                                  @Param("age") Integer age,
                                  @Param("minSalary") Double minSalary,
                                  @Param("maxSalary") Double maxSalary,
                                  @Param("deptId") Long deptId);
}
