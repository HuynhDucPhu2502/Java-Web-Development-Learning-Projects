package me.huynhducphu.actualtest_1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.huynhducphu.actualtest_1.model.Thuoc;
import me.huynhducphu.actualtest_1.util.JpaUtil;

import java.util.List;

/**
 * Admin 9/25/2025
 **/
public class ThuocDAO extends GenericDAO<Thuoc> {

    public ThuocDAO() {
        super(Thuoc.class);
    }

    public List<Thuoc> findByLoaiThuocId(Long loaiThuocId) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            String jpql = """
                    SELECT t FROM Thuoc t 
                    WHERE t.loaiThuoc.id = :loaiThuocId
                    """;

            TypedQuery<Thuoc> query = em.createQuery(jpql, Thuoc.class);
            query.setParameter("loaiThuocId", loaiThuocId);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }
}
