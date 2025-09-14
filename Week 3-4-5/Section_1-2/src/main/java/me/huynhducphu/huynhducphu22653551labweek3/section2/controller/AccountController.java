package me.huynhducphu.huynhducphu22653551labweek3.section2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.huynhducphu.huynhducphu22653551labweek3.section2.model.Account;
import me.huynhducphu.huynhducphu22653551labweek3.section2.repository.AccountRepository;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/accounts/*")
public class AccountController extends HttpServlet {

    private final AccountRepository repo = new AccountRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        if (path == null || "/".equals(path)) {
            req.setAttribute("accounts", repo.findAll());
            req.getRequestDispatcher("/section2/UserList.jsp").forward(req, resp);
        } else if ("/add".equals(path)) {
            req.getRequestDispatcher("/section2/UserRegister.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        if ("/add".equals(path)) {
            req.setCharacterEncoding("UTF-8");

            String firstName  = req.getParameter("firstName");
            String lastName   = req.getParameter("lastName");
            String email      = req.getParameter("email");
            String password   = req.getParameter("password");
            String dobStr     = req.getParameter("dateOfBirth");

            LocalDate dob = LocalDate.parse(dobStr);

            Account acc = new Account(null, firstName, lastName, email, password, dob);
            repo.save(acc);

            resp.sendRedirect(req.getContextPath() + "/accounts");
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
