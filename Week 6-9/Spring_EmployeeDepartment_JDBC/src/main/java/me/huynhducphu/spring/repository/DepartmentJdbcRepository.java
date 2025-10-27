package me.huynhducphu.spring.repository;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.spring.model.Department;
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
public class DepartmentJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Department> mapper = (rs, rowNum) -> {
        Department d = new Department();
        d.setId(rs.getLong("id"));
        d.setName(rs.getString("name"));
        return d;
    };

    public Optional<Department> findById(Long id) {
        var result = jdbcTemplate.query("SELECT * FROM department WHERE id=?", mapper, id);
        return result.stream().findFirst();
    }

    public List<Department> findAll() {
        return jdbcTemplate.query("SELECT * FROM department", mapper);
    }
}
