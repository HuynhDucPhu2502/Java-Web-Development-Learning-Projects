package me.huynhducphu.section4;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Admin 8/7/2025
 **/
@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        response.setContentType("text/html");

        String firstName = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String bio = request.getParameter("bio");

        var writer = response.getWriter();
        writer.println("<a href=\"RegisterPage.jsp\">Quay lại</a>");
        writer.println("<h2>Đăng ký thành congg6!</h2>");
        writer.println("<p>First Name: " + firstName + "</p>");
        writer.println("<p>Last Name: " + lastName + "</p>");
        writer.println("<p>Username: " + username + "</p>");
        writer.println("<p>Email: " + email + "</p>");
        writer.println("<p>Password: " + password + "</p>");
        writer.println("<p>Bio: " + bio + "</p>");
    }
}
