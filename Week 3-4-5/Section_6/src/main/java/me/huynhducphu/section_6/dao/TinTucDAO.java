package me.huynhducphu.section_6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.huynhducphu.section_6.model.TinTuc;
import me.huynhducphu.section_6.util.JpaUtil;

import java.util.List;

/**
 * Admin 9/19/2025
 *
 **/
public class TinTucDAO extends GenericDAO<TinTuc> {

    public TinTucDAO() {
        super(TinTuc.class);
    }

    public List<TinTuc> findByDanhMucName(String danhMucName) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            String jpql = """
                    SELECT tt FROM TinTuc tt
                    WHERE tt.danhMuc.tenDanhMuc = :name
                    """;

            TypedQuery<TinTuc> query = em.createQuery(jpql, TinTuc.class);
            query.setParameter("name", danhMucName);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }
}
