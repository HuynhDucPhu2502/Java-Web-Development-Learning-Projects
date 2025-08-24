package me.huynhducphu.section7.web;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.huynhducphu.section7.model.Contact;
import me.huynhducphu.section7.service.ContactService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Admin 8/20/2025
 **/
@WebServlet("/contacts")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 10
)
public class ContactServlet extends HttpServlet {

    @Inject
    private ContactService contactService;

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        resp.setContentType("text/html");

        var firstName = req.getParameter("firstName");
        var lastName = req.getParameter("lastName");

        var avatarPart = req.getPart("avatarImg");
        var avatarBytes = avatarPart.getInputStream().readAllBytes(); // Lưu vào DB

        Contact contact = new Contact(
                null,
                firstName,
                lastName,
                avatarBytes
        );
        contactService.createContact(contact);

        var writer = resp.getWriter();
        var avatarContentType = avatarPart.getContentType(); // Cần xác định rõ PNG, JPG, ...
        var avatarBase64 = Base64.getEncoder().encodeToString(avatarBytes); // mã hóa byte thành base64

        resp.setStatus(HttpServletResponse.SC_CREATED);
        writer.println("<h1>Thông tin danh bạ</h1>");
        writer.println("<p>Họ: " + lastName + "</p>");
        writer.println("<p>Tên: " + firstName + "</p>");
        writer.println("<p>Ảnh đại diện: <img src='data:" + avatarContentType + ";base64," + avatarBase64 + "' alt='Avatar' /></p>");

    }
}
