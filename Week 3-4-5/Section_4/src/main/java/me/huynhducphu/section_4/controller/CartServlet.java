package me.huynhducphu.section_4.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.huynhducphu.section_4.bean.Cart;
import me.huynhducphu.section_4.dao.BookDAO;
import me.huynhducphu.section_4.model.Book;

import java.io.IOException;

/**
 * Admin 9/14/2025
 *
 **/
@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private BookDAO bookDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy Cart Session
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        // Lấy thông tin từ Form
        String action = req.getParameter("action");
        if (action == null) action = "";

        try {
            switch (action) {

                // Thêm sản phầm vào giỏ hàng
                case "add" -> {
                    Long id = Long.parseLong(req.getParameter("productId"));
                    int quantity = Integer.parseInt(req.getParameter("qty"));

                    Book book = bookDAO.getBookById(id);
                    if (book == null) throw new ServletException("Không tìm thấy sách");

                    for (int i = 1; i <= quantity; ++i) {
                        cart.addProduct(book);
                    }
                }

                // Xóa toàn bộ item có trong giỏ hàng
                case "clear" -> {
                    cart.clearItems();
                    resp.sendRedirect("cart");
                    return;
                }

                // Update số lượng item có trong giỏ hàng
                case "update" -> {
                    Long id = Long.parseLong(req.getParameter("productId"));
                    int quantity = Integer.parseInt(req.getParameter("quantity"));

                    cart.updateItemQuantity(id, quantity);
                    resp.sendRedirect("cart");
                    return;
                }

                // Loại bỏ item khỏi giỏ hàng
                case "remove" -> {
                    Long id = Long.parseLong(req.getParameter("productId"));
                    cart.removeProduct(id);

                    resp.sendRedirect("cart");
                    return;
                }


            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

        resp.sendRedirect("books");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("giohang.jsp").forward(req, resp);
    }
}
