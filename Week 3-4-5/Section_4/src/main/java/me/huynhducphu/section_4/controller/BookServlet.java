package me.huynhducphu.section_4.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.huynhducphu.section_4.dao.BookDAO;
import me.huynhducphu.section_4.model.Book;

import java.io.IOException;
import java.util.List;

/**
 * Admin 9/14/2025
 *
 **/
@WebServlet("/books")
public class BookServlet extends HttpServlet {

    // book hoặc books
    // web/books lấy full
    // web/books?id=3 lấy chi tiết

    private BookDAO bookDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Trường hợp có truyền tham số Id => Lấy chi tiết Book
        String idStr = req.getParameter("id");
        if (idStr != null) {
            try {
                Long id = Long.parseLong(idStr);

                var book = bookDAO.getBookById(id);

                if (book == null)
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                else {
                    req.setAttribute("book", book);
                    req.getRequestDispatcher("chitietsach.jsp").forward(req, resp);
                }

                return;
            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
        }

        // Trường hợp có truyền tham số search => Lấy Book theo search
        String searchQueryStr = req.getParameter("search");
        List<Book> books;
        if (searchQueryStr != null)
            books = bookDAO.findByBookByTitle(searchQueryStr);
        else
            books = bookDAO.getBooks();

        req.setAttribute("books", books);
        req.getRequestDispatcher("danhsach.jsp").forward(req, resp);
    }
}
