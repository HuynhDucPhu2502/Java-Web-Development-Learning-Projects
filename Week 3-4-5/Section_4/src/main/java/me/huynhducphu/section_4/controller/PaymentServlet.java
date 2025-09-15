package me.huynhducphu.section_4.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.huynhducphu.section_4.dao.BookDAO;

import java.io.IOException;

/**
 * Admin 9/15/2025
 *
 **/
@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {

    private BookDAO bookDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("thanhtoan.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String address = req.getParameter("address");
        String paymentMethod = req.getParameter("paymentMethod");

        req.setAttribute("fullname", fullname);
        req.setAttribute("address", address);
        req.setAttribute("paymentMethod", paymentMethod);

        req.getRequestDispatcher("hoadon.jsp").forward(req, resp);

        HttpSession session = req.getSession();
        session.removeAttribute("cart");
    }
}
