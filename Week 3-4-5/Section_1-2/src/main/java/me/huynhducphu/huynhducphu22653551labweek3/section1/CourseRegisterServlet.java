package me.huynhducphu.huynhducphu22653551labweek3.section1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Admin 8/24/2025
 *
 **/
@WebServlet("/course-register")
public class CourseRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var firstName = req.getParameter("firstName");
        var lastName = req.getParameter("lastName");
        var dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));
        var email = req.getParameter("email");
        var mobileNumber = req.getParameter("mobileNumber");
        var gender = req.getParameter("gender");
        var address = req.getParameter("address");
        var city = req.getParameter("city");
        var pinCode = req.getParameter("pinCode");
        var state = req.getParameter("state");
        var country = req.getParameter("country");
        String[] hobbies = req.getParameterValues("hobbies");
        var course = req.getParameter("course");

        var student = new Student(
                req.getParameter("firstName"),
                req.getParameter("lastName"),
                LocalDate.parse(req.getParameter("dateOfBirth")),
                req.getParameter("email"),
                req.getParameter("mobileNumber"),
                req.getParameter("gender"),
                req.getParameter("address"),
                req.getParameter("city"),
                req.getParameter("pinCode"),
                req.getParameter("state"),
                req.getParameter("country"),
                req.getParameterValues("hobbies"),
                req.getParameter("course")
        );

        req.setAttribute("student", student);
        req.getRequestDispatcher("/section1/Result.jsp").forward(req, resp);
   }
}
