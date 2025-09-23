package me.huynhducphu.midterm3.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.huynhducphu.midterm3.dao.ProductDAO;

import java.io.IOException;

/**
 * Admin 9/23/2025
 **/
@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        if (idStr != null) {
            Long id = Long.parseLong(idStr);
            req.setAttribute("p", productDAO.findById(id));
            req.getRequestDispatcher("sanpham-chitiet.jsp").forward(req, resp);
        } else {
            req.setAttribute("productList", productDAO.findAll());
            req.getRequestDispatcher("sanpham-list.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
