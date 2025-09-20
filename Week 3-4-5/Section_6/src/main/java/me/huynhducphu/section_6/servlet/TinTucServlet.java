package me.huynhducphu.section_6.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.huynhducphu.section_6.dao.DanhMucDAO;
import me.huynhducphu.section_6.dao.TinTucDAO;
import me.huynhducphu.section_6.model.DanhMuc;
import me.huynhducphu.section_6.model.TinTuc;

import java.io.IOException;

/**
 * Admin 9/20/2025
 *
 **/
@WebServlet("/tintuc")
public class TinTucServlet extends HttpServlet {

    private DanhMucDAO danhMucDAO;
    private TinTucDAO tinTucDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        danhMucDAO = new DanhMucDAO();
        tinTucDAO = new TinTucDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Cả 2 trang đều dùng danhMucList
        req.setAttribute("danhMucList", danhMucDAO.findAll());

        // Nếu có action thì qua trang form
        String action = req.getParameter("action");
        if (action != null) {
            if (action.equalsIgnoreCase("UPDATE")) {
                Long id = Long.parseLong(req.getParameter("id"));
                TinTuc tinTuc = tinTucDAO.findById(id);
                req.setAttribute("tinTuc", tinTuc);
            }
            req.getRequestDispatcher("tintuc-form.jsp").forward(req, resp);
            return;
        }


        // Không có thì trang list
        String danhMucName = req.getParameter("danhMucName");
        if (danhMucName != null && !danhMucName.equalsIgnoreCase("ALL")) {
            req.setAttribute("danhMucName", danhMucName);
            req.setAttribute("TinTucList", tinTucDAO.findByDanhMucName(danhMucName));
        } else
            req.setAttribute("TinTucList", tinTucDAO.findAll());


        req.getRequestDispatcher("tintuc-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            switch (action) {

                case "DELETE" -> {
                    String maTT = req.getParameter("maTT");
                    tinTucDAO.deleteById(Long.parseLong(maTT));
                    resp.sendRedirect("tintuc");
                }

                case "SAVE" -> {
                    String tinTucIdStr = req.getParameter("tinTucId");
                    Long tinTucId = tinTucIdStr == null ? null : Long.parseLong(tinTucIdStr);

                    String tieuDe = req.getParameter("tieuDe");
                    String noiDungTT = req.getParameter("noiDungTT");
                    String lienKet = req.getParameter("lienKet");

                    Long maDm = Long.parseLong(req.getParameter("danhMucId"));
                    DanhMuc danhMuc = danhMucDAO.findById(maDm);

                    TinTuc tinTuc = new TinTuc(
                            tinTucId, tieuDe,
                            noiDungTT, lienKet,
                            danhMuc
                    );

                    if (danhMuc != null) tinTucDAO.save(tinTuc);

                    resp.sendRedirect("tintuc");
                }


            }
        }
    }
}
