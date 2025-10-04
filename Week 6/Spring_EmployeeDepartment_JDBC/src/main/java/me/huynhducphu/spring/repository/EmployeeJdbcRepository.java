package me.huynhducphu.spring.repository;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.spring.model.Department;
import me.huynhducphu.spring.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Admin 10/4/2025
 *
 **/
@Repository
@RequiredArgsConstructor
public class EmployeeJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Employee> mapper = (rs, rowNum) -> {
        Employee e = new Employee();
        e.setId(rs.getLong("id"));
        e.setName(rs.getString("name"));
        e.setAge(rs.getInt("age"));
        e.setSalary(rs.getDouble("salary"));

        Department d = new Department();
        d.setId(rs.getLong("department_id"));
        e.setDepartment(d);
        return e;
    };

    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employees", mapper);
    }

    public Optional<Employee> findById(Long id) {
        var result = jdbcTemplate.query("SELECT * FROM employees WHERE id=?", mapper, id);
        return result.stream().findFirst();
    }

    public int save(Employee e) {
        return jdbcTemplate.update(
                "INSERT INTO employees(name, age, salary, department_id) VALUES(?,?,?,?)",
                e.getName(), e.getAge(), e.getSalary(),
                e.getDepartment() != null ? e.getDepartment().getId() : null
        );
    }

    public int update(Employee e) {
        return jdbcTemplate.update(
                "UPDATE employees SET name=?, age=?, salary=?, department_id=? WHERE id=?",
                e.getName(), e.getAge(), e.getSalary(),
                e.getDepartment() != null ? e.getDepartment().getId() : null,
                e.getId()
        );
    }

    public List<Employee> findByName(String name) {
        return jdbcTemplate.query(
                "SELECT * FROM employees WHERE LOWER(name) LIKE LOWER(?)",
                mapper,
                "%" + name + "%"
        );
    }

    public List<Employee> findByAge(int age) {
        return jdbcTemplate.query(
                "SELECT * FROM employees WHERE age=?",
                mapper,
                age
        );
    }

    public List<Employee> findByDepartmentId(Long deptId) {
        return jdbcTemplate.query(
                "SELECT * FROM employees WHERE department_id=?",
                mapper,
                deptId
        );
    }

    public List<Employee> findBySalaryBetween(double min, double max) {
        return jdbcTemplate.query(
                "SELECT * FROM employees WHERE salary BETWEEN ? AND ?",
                mapper,
                min, max
        );
    }
}
