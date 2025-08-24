package me.huynhducphu.section7.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.huynhducphu.section7.model.Contact;
import me.huynhducphu.section7.repository.ContactRepository;

/**
 * Admin 8/20/2025
 **/
@ApplicationScoped
public class ContactService {

    @Inject
    private ContactRepository contactRepository;

    public void createContact(Contact contact) {
        contactRepository.createContact(contact);
    }


}
