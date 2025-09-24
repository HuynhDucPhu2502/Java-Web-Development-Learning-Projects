package me.huynhducphu.query_practice.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.huynhducphu.query_practice.dao.EmployeeDAO;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Admin 9/24/2025
 **/
@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeDAO employeeDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        employeeDAO = new EmployeeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            switch (action) {
                case "findMaxSalaryPerDepartment" -> {
                    req.setAttribute("employees", employeeDAO.findMaxSalaryPerDepartment());
                }

                case "findEmployeesAboveAverageSalary" -> {
                    req.setAttribute("employees", employeeDAO.findEmployeesAboveAverageSalary());
                }
            }
        } else req.setAttribute("employees", employeeDAO.findAll());


        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            switch (action) {
                case "findActiveEmployeesAtDate" -> {
                    String dateStr = req.getParameter("date");
                    LocalDate date = LocalDate.parse(dateStr);
                    req.setAttribute("employees", employeeDAO.findActiveEmployeesAtDate(date));
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
                case "findEmployeesHiredBetween" -> {
                    String dateFromStr = req.getParameter("dateFrom");
                    String dateToStr = req.getParameter("dateTo");

                    LocalDate dateFrom = LocalDate.parse(dateFromStr);
                    LocalDate dateTo = LocalDate.parse(dateToStr);

                    req.setAttribute(
                            "employees",
                            employeeDAO.findEmployeesHiredBetween(dateFrom, dateTo)
                    );
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
                case "findEmployeesWithTenureGreaterThanXYears" -> {
                    String numberOfYearsStr = req.getParameter("numberOfYears");
                    int numberOfYears = Integer.parseInt(numberOfYearsStr);
                    req.setAttribute("employees", employeeDAO.findActiveEmployeesWithTenureGreaterThanXYears(numberOfYears));
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
            }

        }

    }
}
