package me.huynhducphu.section7.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import me.huynhducphu.section7.model.Contact;


/**
 * Admin 8/20/2025
 **/
@ApplicationScoped
public class ContactRepository {

    @Inject
    private EntityManager em;

    public void createContact(Contact contact) {
        em.getTransaction().begin();
        em.persist(contact);
        em.getTransaction().commit();
    }

    public void findContactById(Long id) {
        em.find(Contact.class, id);
    }

}
