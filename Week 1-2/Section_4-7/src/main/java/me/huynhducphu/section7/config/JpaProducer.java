package me.huynhducphu.section7.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Admin 8/20/2025
 **/
@ApplicationScoped
public class JpaProducer {

    @Produces
    @ApplicationScoped
    public EntityManagerFactory getEntityManagerFactory() {
        var emf = Persistence.createEntityManagerFactory("appPU");

        return emf;
    }

    @Produces
    @RequestScoped
    public EntityManager getEntityManager(EntityManagerFactory emf) {
        return emf.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager em) {
        if (em.isOpen()) em.close();
    }

    public void closeEntityManagerFactory(@Disposes EntityManagerFactory emf) {
        if (emf.isOpen()) emf.close();
    }

}
