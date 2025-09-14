package me.huynhducphu.huynhducphu22653551labweek3.section2.repository;

import me.huynhducphu.huynhducphu22653551labweek3.section2.model.Account;
import me.huynhducphu.huynhducphu22653551labweek3.section2.util.JpaUtil;

import java.util.List;

public class AccountRepository {
    public Account save(Account a) {
        var em = JpaUtil.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            return a;
        } finally { em.close(); }
    }

    public List<Account> findAll() {
        var em = JpaUtil.getEmf().createEntityManager();
        try {
            return em.createQuery("select a from Account a", Account.class).getResultList();
        } finally { em.close(); }
    }
}
