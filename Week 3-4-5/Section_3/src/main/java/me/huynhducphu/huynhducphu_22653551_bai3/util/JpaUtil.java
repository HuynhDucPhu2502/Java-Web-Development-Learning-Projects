package me.huynhducphu.huynhducphu_22653551_bai3.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("default");

    public static EntityManager getEmf() {
        return emf.createEntityManager();
    }

}
