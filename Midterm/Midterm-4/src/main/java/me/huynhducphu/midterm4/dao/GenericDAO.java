package me.huynhducphu.midterm4.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.huynhducphu.midterm4.util.JpaUtil;

import java.util.List;

/**
 * Admin 9/25/2025
 **/
public class GenericDAO<T> {

    private Class<T> type;

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    public List<T> findAll() {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            String jpql = """
                    SELECT e FROM %s e
                    """.formatted(type.getSimpleName());

            TypedQuery<T> query = em.createQuery(jpql, type);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }

    public T findById(Long id) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            return em.find(type, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }

    public void save(T entity) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(entity);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

}
