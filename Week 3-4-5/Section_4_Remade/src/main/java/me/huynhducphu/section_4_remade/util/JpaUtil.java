package me.huynhducphu.section_4_remade.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

/**
 * Admin 9/23/2025
 **/
public class JpaUtil {

    @Getter
    private static EntityManagerFactory emf;

    public static void init() {
        if (emf == null)
            emf = Persistence.createEntityManagerFactory("default");
    }

    public static void destroy() {
        if (emf.isOpen())
            emf.close();
    }

}
