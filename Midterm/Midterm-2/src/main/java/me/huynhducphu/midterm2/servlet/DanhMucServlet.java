package me.huynhducphu.midterm2.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.huynhducphu.midterm2.dao.DanhMucDAO;
import me.huynhducphu.midterm2.model.DanhMuc;

import java.io.IOException;

/**
 * Admin 9/21/2025
 **/
@WebServlet("/danhmuc")
public class DanhMucServlet extends HttpServlet {

    private DanhMucDAO danhMucDAO;


    @Override
    public void init(ServletConfig config) throws ServletException {
        danhMucDAO = new DanhMucDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        // Nêếu action ton tai la qua trang form
        if (action != null) {
            String idStr = req.getParameter("id");

            DanhMuc danhMuc = danhMucDAO.findById(Long.parseLong(idStr));
            req.setAttribute("danhMuc", danhMuc);

            req.getRequestDispatcher("danhmuc-form.jsp").forward(req, resp);
            return;
        }

        // Qua trang list
        req.setAttribute("listDanhMuc", danhMucDAO.findAll());
        req.getRequestDispatcher("danhmuc-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            switch (action) {

                case "DELETE" -> {
                    String idSTr = req.getParameter("id");
                    if (idSTr != null)
                        danhMucDAO.deleteById(Long.parseLong(idSTr));
                    resp.sendRedirect("danhmuc");
                }

                case "SAVE" -> {
                    String idStr = req.getParameter("id");
                    String tenDanhMuc = req.getParameter("tenDanhMuc");
                    String nguoiQuanLy = req.getParameter("nguoiQuanLy");
                    String ghiChu = req.getParameter("ghiChu");

                    Long id = idStr != null || !idStr.isBlank()
                            ? Long.parseLong(idStr)
                            : null;

                    DanhMuc danhMuc = new DanhMuc(
                            id, tenDanhMuc,
                            nguoiQuanLy, ghiChu,
                            null
                    );

                    danhMucDAO.save(danhMuc);
                    resp.sendRedirect("danhmuc");
                }

            }
        }


    }
}
