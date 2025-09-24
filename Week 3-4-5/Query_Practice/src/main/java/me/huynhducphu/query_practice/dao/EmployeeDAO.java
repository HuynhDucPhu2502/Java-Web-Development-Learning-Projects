package me.huynhducphu.query_practice.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.huynhducphu.query_practice.model.Employee;
import me.huynhducphu.query_practice.util.JpaUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Admin 9/24/2025
 **/
public class EmployeeDAO {

    public List<Employee> findAll() {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            String jpql = """
                    SELECT e FROM Employee e
                    """;

            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }

    //    Câu 1: Tìm nhân viên có lương cao nhất trong từng phòng ban
    public List<Employee> findMaxSalaryPerDepartment() {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            String jpql = """
                    SELECT e FROM Employee e
                    WHERE e.salary = (
                        SELECT MAX(e2.salary) FROM Employee e2 
                        WHERE e.department = e2.department
                    )
                    """;

            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }

    //    Câu 2: Tìm tất cả nhân viên đang còn làm việc tại một ngày cụ thể (active employees)
    public List<Employee> findActiveEmployeesAtDate(LocalDate date) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            String jpql = """
                    SELECT e FROM Employee e
                    WHERE e.hireDate <= :date 
                        AND (e.terminationDate IS NULL OR e.terminationDate > :date)
                    """;

            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
            query.setParameter("date", date);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }

    //    Câu 3: Tìm những nhân viên có mức lương cao hơn mức lương trung bình của phòng ban họ
    public List<Employee> findEmployeesAboveAverageSalary() {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            String jpql = """
                    SELECT e FROM Employee e
                    WHERE e.salary >= (
                    SELECT AVG(e2.salary) FROM Employee e2
                    WHERE e.department = e2.department
                    )
                    """;

            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }

    //    Câu 4: Tìm nhân viên được tuyển dụng trong khoảng ngày từ ngày from dến ngày to
    public List<Employee> findEmployeesHiredBetween(LocalDate from, LocalDate to) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            String jpql = """
                    SELECT e FROM Employee e
                    WHERE e.hireDate BETWEEN :from AND :to
                    """;

            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
            query.setParameter("from", from);
            query.setParameter("to", to);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }

    //    Câu 5: Tìm nhân viên đang làm việc có thâm niên lớn hơn hoặc bằng x năm tại
    public List<Employee> findActiveEmployeesWithTenureGreaterThanXYears(int year) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            String jpql = """
                    SELECT e FROM Employee e
                    WHERE YEAR(CURRENT_DATE) - YEAR(e.hireDate) >= :years
                        AND (e.terminationDate IS NULL)
                    """;

            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
            query.setParameter("years", year);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }

}
