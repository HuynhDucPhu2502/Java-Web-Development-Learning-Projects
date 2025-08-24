package me.huynhducphu.huynhducphu22653551labweek2.section1;

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

        req.setAttribute("firstName", firstName);
        req.setAttribute("lastName", lastName);
        req.setAttribute("dateOfBirth", dateOfBirth);
        req.setAttribute("email", email);
        req.setAttribute("mobileNumber", mobileNumber);
        req.setAttribute("gender", gender);
        req.setAttribute("address", address);
        req.setAttribute("city", city);
        req.setAttribute("pinCode", pinCode);
        req.setAttribute("state", state);
        req.setAttribute("country", country);
        req.setAttribute("hobbies", hobbies);
        req.setAttribute("course", course);

        req.getRequestDispatcher("/section1/Result.jsp").forward(req, resp);
    }
}
