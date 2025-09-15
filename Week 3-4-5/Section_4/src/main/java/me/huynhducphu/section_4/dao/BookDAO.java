package me.huynhducphu.section_4.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.huynhducphu.section_4.model.Book;
import me.huynhducphu.section_4.util.JpaUtil;

import java.util.List;

/**
 * Admin 9/14/2025
 *
 **/
public class BookDAO {

    public Book getBookById(Long bookId) {
        try (EntityManager em = JpaUtil.getEmf().createEntityManager()) {
            return em.find(Book.class, bookId);
        }
    }

    public List<Book> getBooks() {
        try (EntityManager em = JpaUtil.getEmf().createEntityManager()) {
            TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
            return query.getResultList();
        }
    }

    public List<Book> findByBookByTitle(String bookTitle) {
        try (EntityManager em = JpaUtil.getEmf().createEntityManager()) {
            String jpql = """
                    SELECT b FROM Book b
                    WHERE b.title LIKE :name
                    """;

            TypedQuery<Book> query = em
                    .createQuery(jpql, Book.class)
                    .setParameter("name", "%" + bookTitle + "%");

            return query.getResultList();
        }
    }


}
