package me.huynhducphu.section_5.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

/**
 * Admin 9/16/2025
 **/
public class JpaUtil {

    @Getter
    private static EntityManagerFactory emf;

    public static void init() {
        if (emf == null)
            emf = Persistence.createEntityManagerFactory("default");
    }

    public static void close() {
        if (emf.isOpen())
            emf.close();
    }

}
