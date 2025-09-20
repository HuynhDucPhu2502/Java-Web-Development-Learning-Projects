package me.huynhducphu.section_6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.huynhducphu.section_6.util.JpaUtil;

import java.util.List;

/**
 * Admin 9/19/2025
 *
 **/
public class GenericDAO<T> {

    private Class<T> type;

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    // Vừa là Save, vừa là Update
    public void save(T t) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            // Nếu id == 0 hoặc null là insert
            // Còn không thì là update
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
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

    public void deleteById(Long id) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            em.getTransaction().begin();
            T entity = em.find(type, id);
            if (entity != null) em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

    }


}
