package me.huynhducphu.actualtest_1.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.huynhducphu.actualtest_1.dao.LoaiThuocDAO;
import me.huynhducphu.actualtest_1.dao.ThuocDAO;
import me.huynhducphu.actualtest_1.model.LoaiThuoc;
import me.huynhducphu.actualtest_1.model.Thuoc;

import java.io.IOException;

/**
 * Admin 9/25/2025
 **/
@WebServlet("/thuoc")
public class ThuocServlet extends HttpServlet {

    private ThuocDAO thuocDAO;
    private LoaiThuocDAO loaiThuocDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        thuocDAO = new ThuocDAO();
        loaiThuocDAO = new LoaiThuocDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listLoaiThuoc", loaiThuocDAO.findAll());

        // Co action vao trang form
        String action = req.getParameter("action");
        if (action != null && action.equals("CREATE")) {
            req.getRequestDispatcher("form-thuoc.jsp").forward(req, resp);
            return;
        }

        // Khong action xuong trang list
        String loaiThuocIdStr = req.getParameter("loaiThuocId");
        if (loaiThuocIdStr != null && !loaiThuocIdStr.equals("ALL")) {
            Long loaiThuocId = Long.parseLong(loaiThuocIdStr);
            req.setAttribute("listThuoc", thuocDAO.findByLoaiThuocId(loaiThuocId));
        } else req.setAttribute("listThuoc", thuocDAO.findAll());

        req.getRequestDispatcher("list-thuoc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenThuoc = req.getParameter("tenThuoc");
        String giaStr = req.getParameter("gia");
        String namSXStr = req.getParameter("namSX");
        String loaiThuocIdStr = req.getParameter("loaiThuocId");

        double gia = Double.parseDouble(giaStr);
        int namSX = Integer.parseInt(namSXStr);

        Long loaiThuocId = Long.parseLong(loaiThuocIdStr);
        LoaiThuoc loaiThuoc = loaiThuocDAO.findById(loaiThuocId);

        if (loaiThuoc == null) return;

        thuocDAO.save(new Thuoc(null, tenThuoc, gia, namSX, loaiThuoc));
        resp.sendRedirect("thuoc");
    }
}
