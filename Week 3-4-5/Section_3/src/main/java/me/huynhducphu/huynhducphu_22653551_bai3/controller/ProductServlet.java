package me.huynhducphu.huynhducphu_22653551_bai3.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.huynhducphu.huynhducphu_22653551_bai3.bean.Product;
import me.huynhducphu.huynhducphu_22653551_bai3.dao.ProductDAO;

import java.io.IOException;
import java.util.List;

@WebServlet({"/products", "/product"})
public class ProductServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idstr = req.getParameter("id");

        if (idstr != null) {
            try {
                int id = Integer.parseInt(idstr);
                Product product = productDAO.getProductById(id);
                if (product != null) {
                    req.setAttribute("product", product);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/productdetail.jsp");
                    dispatcher.forward(req, resp);
                    return;
                } else {
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
                    return;
                }
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product id");
                return;
            }
        }

        List<Product> products = productDAO.getAllProducts();
        req.setAttribute("products", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/productlist.jsp");
        dispatcher.forward(req, resp);
    }
}
