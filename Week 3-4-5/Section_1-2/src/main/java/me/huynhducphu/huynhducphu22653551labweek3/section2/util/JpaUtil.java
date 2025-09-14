package me.huynhducphu.huynhducphu22653551labweek3.section2.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class JpaUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("default");

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}
