package me.huynhducphu.midterm3.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.huynhducphu.midterm3.bean.Cart;
import me.huynhducphu.midterm3.dao.OrderDAO;
import me.huynhducphu.midterm3.dao.ProductDAO;
import me.huynhducphu.midterm3.model.Order;

import java.io.IOException;

/**
 * Admin 9/23/2025
 **/
@WebServlet("/carts")
public class CartServlet extends HttpServlet {

    private ProductDAO productDAO;
    private OrderDAO orderDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productDAO = new ProductDAO();
        orderDAO = new OrderDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }


        req.setAttribute("cart", cart);
        req.getRequestDispatcher("giohang.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }


        String action = req.getParameter("action");

        if (action != null) {
            switch (action) {
                case "ADD" -> {
                    String idStr = req.getParameter("id");

                    if (idStr != null && !idStr.isBlank()) {
                        Long id = Long.parseLong(idStr);
                        cart.add(productDAO.findById(id));
                        resp.sendRedirect("products");
                    }

                }

                case "REMOVE" -> {
                    String idStr = req.getParameter("id");

                    if (idStr != null && !idStr.isBlank()) {
                        Long id = Long.parseLong(idStr);
                        cart.remove(id);
                        resp.sendRedirect("carts");
                    }
                }

                case "UPDATE-QUANTITY" -> {
                    String idStr = req.getParameter("id");
                    String quantityStr = req.getParameter("quantity");

                    if (idStr != null && !idStr.isBlank()) {
                        Long id = Long.parseLong(idStr);
                        int quantity = Integer.parseInt(quantityStr);
                        cart.updateQuantity(id, quantity);
                        resp.sendRedirect("carts");
                    }

                }

                case "CHECKOUT" -> {
                    String name = req.getParameter("name");
                    String address = req.getParameter("address");

                    Order order = new Order(
                            null, name,
                            address, cart.getTotal()
                    );

                    orderDAO.save(order);

                    session.setAttribute("cart", null);
                    resp.sendRedirect("carts");
                }

            }
        }
    }
}
