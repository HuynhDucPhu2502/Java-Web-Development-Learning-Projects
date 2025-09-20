package me.huynhducphu.section_6.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.huynhducphu.section_6.dao.DanhMucDAO;
import me.huynhducphu.section_6.model.DanhMuc;

import java.io.IOException;

/**
 * Admin 9/20/2025
 *
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
        if (action == null) action = "";

        switch (action.toUpperCase()) {
            case "UPDATE":
                Long id = Long.parseLong(req.getParameter("id"));
                req.setAttribute("danhMuc", danhMucDAO.findById(id));
                req.getRequestDispatcher("danhmuc-form.jsp").forward(req, resp);
                break;

            default:
                req.setAttribute("DanhMucList", danhMucDAO.findAll());
                req.getRequestDispatcher("danhmuc-list.jsp").forward(req, resp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            switch (action) {

                case "DELETE" -> {
                    String maDm = req.getParameter("maDm");
                    danhMucDAO.deleteById(Long.parseLong(maDm));
                    resp.sendRedirect("danhmuc");
                }

                case "SAVE" -> {
                    String danhMucIdStr = req.getParameter("danhMucId");
                    Long danhMucId = danhMucIdStr == null ? null : Long.parseLong(danhMucIdStr);

                    String tenDanhMuc = req.getParameter("tenDanhMuc");
                    String nguoiQuanLy = req.getParameter("nguoiQuanLy");
                    String ghiChu = req.getParameter("ghiChu");

                    DanhMuc danhMuc = new DanhMuc(
                            danhMucId, tenDanhMuc,
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
