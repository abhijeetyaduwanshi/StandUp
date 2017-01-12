/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.nexient.ayaduwanshi.standup.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ayaduwanshi
 */
public class GuestTest extends AbstractJPATest {
    
    public GuestTest() {
    }
    
    @Test
    public void testCreate() {
        
        String guestFirstName = "GuestInClass";
        String guestLastName = "GuestInClassLN";
        String guestEmail = "guestInClass@gmail.com";
        
        tx.begin();
        Guest guest = new Guest();
        guest.setFirstName(guestFirstName);
        guest.setLastName(guestLastName);
        guest.setEmail(guestEmail);
        em.persist(guest);
        tx.commit();
        
        assertNotNull(guest.getId());
        assertEquals(guestFirstName, guest.getFirstName());
        assertTrue(guestFirstName.equals(guest.getFirstName()));
        assertEquals(guestLastName, guest.getLastName());
        assertTrue(guestLastName.equals(guest.getLastName()));
        assertEquals(guestEmail, guest.getEmail());
        assertTrue(guestEmail.equals(guest.getEmail()));
    }
    
    @Test
    public void testRead() {
        Guest gFirstName = em.createNamedQuery("Guest.findByFirstName", Guest.class).setParameter("firstName", "Guest1").getSingleResult();
        Guest gLastName = em.createNamedQuery("Guest.findByLastName", Guest.class).setParameter("lastName", "Guest1LN").getSingleResult();
        Guest gEmail = em.createNamedQuery("Guest.findByEmail", Guest.class).setParameter("email", "guest1@gmail.com").getSingleResult();
        assertNotNull(gFirstName.getId());
        
        String originalFirstName = gFirstName.getFirstName();
        String originalLastName = gLastName.getLastName();
        String originalEmail = gEmail.getEmail();
        
        tx.begin();
        em.persist(gFirstName);
        em.persist(gLastName);
        em.persist(gEmail);
        tx.commit();
        
        assertEquals(originalFirstName, gFirstName.getFirstName());
        assertTrue(originalFirstName.equals(gFirstName.getFirstName()));
        assertEquals(originalLastName, gLastName.getLastName());
        assertTrue(originalLastName.equals(gLastName.getLastName()));
        assertEquals(originalEmail, gEmail.getEmail());
        assertTrue(originalEmail.equals(gEmail.getEmail()));
    }
    
    @Test
    public void testUpdate() {
        Guest gFirstName = em.createNamedQuery("Guest.findByFirstName", Guest.class).setParameter("firstName", "Guest1").getSingleResult();
        Guest gLastName = em.createNamedQuery("Guest.findByLastName", Guest.class).setParameter("lastName", "Guest1LN").getSingleResult();
        Guest gEmail = em.createNamedQuery("Guest.findByEmail", Guest.class).setParameter("email", "guest1@gmail.com").getSingleResult();
        assertNotNull(gFirstName.getId());
        
        String originalFirstName = gFirstName.getFirstName();
        String newFirstName = "GuestInClassUpdate";
        String originalLastName = gLastName.getLastName();
        String newLastName = "GuestInClassUpdateLN";
        String originalEmail = gEmail.getEmail();
        String newEmail = "guestInClassUpdate@gmail.com";
        
        tx.begin();
        gFirstName.setFirstName(newFirstName);
        gLastName.setLastName(newLastName);
        gEmail.setEmail(newEmail);
        tx.commit();
        
        assertNotEquals(originalFirstName, gFirstName.getFirstName());
        assertTrue(newFirstName.equals(gFirstName.getFirstName()));
        assertNotEquals(originalLastName, gLastName.getLastName());
        assertTrue(newLastName.equals(gLastName.getLastName()));
        assertNotEquals(originalEmail, gEmail.getEmail());
        assertTrue(newEmail.equals(gEmail.getEmail()));
        
        tx.begin();
        gFirstName.setFirstName(originalFirstName);
        gLastName.setLastName(originalLastName);
        gEmail.setEmail(originalEmail);
        tx.commit();
        
    }
    
    @Test
    public void testDelete() {
        // do later
    }
    
}
