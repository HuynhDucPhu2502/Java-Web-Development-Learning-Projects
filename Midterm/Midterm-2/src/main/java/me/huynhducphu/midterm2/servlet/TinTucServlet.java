package me.huynhducphu.midterm2.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.huynhducphu.midterm2.dao.DanhMucDAO;
import me.huynhducphu.midterm2.dao.TinTucDAO;
import me.huynhducphu.midterm2.model.DanhMuc;
import me.huynhducphu.midterm2.model.TinTuc;

import java.io.IOException;

/**
 * Admin 9/21/2025
 **/
@WebServlet("/tintuc")
public class TinTucServlet extends HttpServlet {

    private TinTucDAO tinTucDAO;
    private DanhMucDAO danhMucDAO;

    public TinTucServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        tinTucDAO = new TinTucDAO();
        danhMucDAO = new DanhMucDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listDanhMuc", danhMucDAO.findAll());

        // Co action qua form
        String action = req.getParameter("action");
        if (action != null) {

            if (action.equals("EDIT")) {
                String idStr = req.getParameter("id");
                TinTuc tinTuc = tinTucDAO.findById(Long.parseLong(idStr));
                req.setAttribute("tinTuc", tinTuc);

            }

            req.getRequestDispatcher("tintuc-form.jsp").forward(req, resp);
            return;
        }


        // Qua trang list
        String tenDanhMucSearch = req.getParameter("tenDanhMucSearch");
        if (tenDanhMucSearch != null && !tenDanhMucSearch.equals("ALL")) {
            req.setAttribute("listTinTuc", tinTucDAO.findByDanhMucName(tenDanhMucSearch));
        } else {
            req.setAttribute("listTinTuc", tinTucDAO.findAll());
        }
        req.getRequestDispatcher("tintuc-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            switch (action) {

                case "DELETE" -> {
                    String idSTr = req.getParameter("id");
                    if (idSTr != null)
                        tinTucDAO.deleteById(Long.parseLong(idSTr));
                    resp.sendRedirect("tintuc");
                }

                case "SAVE" -> {
                    String idStr = req.getParameter("id");
                    String tieuDe = req.getParameter("tieuDe");
                    String noiDungTT = req.getParameter("noiDungTT");
                    String lienKet = req.getParameter("lienKet");

                    String danhMucIdStr = req.getParameter("danhMucId");
                    DanhMuc danhMuc = null;
                    if (danhMucIdStr != null)
                        danhMuc = danhMucDAO.findById(Long.parseLong(danhMucIdStr));


                    Long id = idStr != null || !idStr.isBlank()
                            ? Long.parseLong(idStr)
                            : null;

                    TinTuc tinTuc = new TinTuc(
                            id, tieuDe,
                            noiDungTT, lienKet,
                            danhMuc
                    );

                    tinTucDAO.save(tinTuc);
                    resp.sendRedirect("tintuc");
                }

            }
        }
    }
}
