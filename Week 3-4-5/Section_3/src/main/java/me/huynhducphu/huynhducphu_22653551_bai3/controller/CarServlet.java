package me.huynhducphu.huynhducphu_22653551_bai3.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.huynhducphu.huynhducphu_22653551_bai3.bean.CartBean;
import me.huynhducphu.huynhducphu_22653551_bai3.bean.Product;
import me.huynhducphu.huynhducphu_22653551_bai3.dao.ProductDAO;

import java.io.IOException;

@WebServlet("/cart")
public class CarServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/cart.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        CartBean cart = (CartBean) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartBean();
            session.setAttribute("cart", cart);
        }

        String action = req.getParameter("action");
        if (action == null) action = "";

        try {
            switch (action) {
                case "add": {
                    // chấp nhận id hoặc productId; qty hoặc quantity
                    String idStr = firstNonNull(req.getParameter("productId"), req.getParameter("id"));
                    String qtyStr = firstNonNull(req.getParameter("qty"), req.getParameter("quantity"));
                    long id = Long.parseLong(idStr);
                    int qty = parseQty(qtyStr, 1);

                    Product p = productDAO.getProductById(id);
                    if (p == null) throw new ServletException("Product not found: " + id);

                    // add N lần (đơn giản) hoặc bạn có thể thêm method addProduct(product, qty)
                    for (int i = 0; i < qty; i++) {
                        cart.addProduct(p);
                    }
                    break;
                }
                case "update": {
                    long id = Long.parseLong(firstNonNull(req.getParameter("productId"), req.getParameter("id")));
                    int qty = parseQty(firstNonNull(req.getParameter("quantity"), req.getParameter("qty")), 1);
                    cart.updateQuantity(id, qty);
                    break;
                }
                case "remove": {
                    long id = Long.parseLong(firstNonNull(req.getParameter("productId"), req.getParameter("id")));
                    cart.removeProduct(id);
                    break;
                }
                case "clear": {
                    cart.clear();
                    break;
                }
                default:
                    // không làm gì
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }

        resp.sendRedirect(req.getContextPath() + "/cart");
    }

    private static String firstNonNull(String a, String b) {
        return (a != null && !a.isBlank()) ? a : b;
    }

    private static int parseQty(String s, int defVal) {
        try {
            int q = Integer.parseInt(s);
            return q < 1 ? 1 : q;
        } catch (Exception e) {
            return defVal;
        }
    }
}
