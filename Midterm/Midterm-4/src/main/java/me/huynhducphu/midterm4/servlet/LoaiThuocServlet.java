package me.huynhducphu.midterm4.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.huynhducphu.midterm4.dao.LoaiThuocDAO;

import java.io.IOException;

/**
 * Admin 9/25/2025
 **/
@WebServlet("/loaithuoc")
public class LoaiThuocServlet extends HttpServlet {

    private LoaiThuocDAO loaiThuocDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        loaiThuocDAO = new LoaiThuocDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listLoaiThuoc", loaiThuocDAO.findAll());
        req.getRequestDispatcher("loaithuoc-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
