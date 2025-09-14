package me.huynhducphu.huynhducphu_22653551_bai3.dao;

import jakarta.persistence.EntityManager;
import me.huynhducphu.huynhducphu_22653551_bai3.bean.Product;
import me.huynhducphu.huynhducphu_22653551_bai3.util.JpaUtil;

import java.util.List;

public class ProductDAO {

    public List<Product> getAllProducts() {
        try (EntityManager em = JpaUtil.getEmf()) {
            return em.createQuery("SELECT p FROM Product p", Product.class)
                    .getResultList();
        }
    }

    public Product getProductById(long id) {
        try (EntityManager em = JpaUtil.getEmf()) {
            return em.find(Product.class, (long) id);
        }
    }

}
