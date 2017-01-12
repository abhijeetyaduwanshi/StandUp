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
public class UserTest extends AbstractJPATest {

    public UserTest() {
    }

    @Test
    public void testCreate() {

        String userFirstName = "UserInClass";
        String userLastName = "UserInClassLN";
        String userEmail = "userInClass@gmail.com";
        String userCompanyName = "UserInClassCompanyName";
        String userPosition = "UserInClassPosition";

        tx.begin();
        User user = new User();
        user.setFirstName(userFirstName);
        user.setLastName(userLastName);
        user.setEmail(userEmail);
        user.setCompanyName(userCompanyName);
        user.setPosition(userPosition);
        em.persist(user);
        tx.commit();

        assertNotNull(user.getId());
        assertEquals(userFirstName, user.getFirstName());
        assertEquals(userLastName, user.getLastName());
        assertEquals(userEmail, user.getEmail());
        assertEquals(userCompanyName, user.getCompanyName());
        assertEquals(userPosition, user.getPosition());
        assertTrue(userFirstName.equals(user.getFirstName()));
        assertTrue(userLastName.equals(user.getLastName()));
        assertTrue(userEmail.equals(user.getEmail()));
        assertTrue(userCompanyName.equals(user.getCompanyName()));
        assertTrue(userPosition.equals(user.getPosition()));

    }

    @Test
    public void testRead() {
        User uFirstName = em.createNamedQuery("User.findByFirstName", User.class).setParameter("firstName", "User1").getSingleResult();
        User uLastName = em.createNamedQuery("User.findByLastName", User.class).setParameter("lastName", "User1LN").getSingleResult();
        User uEmail = em.createNamedQuery("User.findByEmail", User.class).setParameter("email", "user1@gmail.com").getSingleResult();
        User uCompanyName = em.createNamedQuery("User.findByCompanyName", User.class).setParameter("companyName", "User1CompanyName").getSingleResult();
        User uPosition = em.createNamedQuery("User.findByPosition", User.class).setParameter("position", "User1Position").getSingleResult();
        assertNotNull(uFirstName.getId());

        String originalFirstName = uFirstName.getFirstName();
        String originalLastName = uLastName.getLastName();
        String originalEmail = uEmail.getEmail();
        String originalCompanyname = uCompanyName.getCompanyName();
        String originalPosition = uPosition.getPosition();

        tx.begin();
        em.persist(uFirstName);
        em.persist(uLastName);
        em.persist(uEmail);
        em.persist(uCompanyName);
        em.persist(uPosition);
        tx.commit();

        assertEquals(originalFirstName, uFirstName.getFirstName());
        assertEquals(originalLastName, uLastName.getLastName());
        assertEquals(originalEmail, uEmail.getEmail());
        assertEquals(originalCompanyname, uCompanyName.getCompanyName());
        assertEquals(originalPosition, uPosition.getPosition());
        assertTrue(originalFirstName.equals(uFirstName.getFirstName()));
        assertTrue(originalLastName.equals(uLastName.getLastName()));
        assertTrue(originalEmail.equals(uEmail.getEmail()));
        assertTrue(originalCompanyname.equals(uCompanyName.getCompanyName()));
        assertTrue(originalPosition.equals(uPosition.getPosition()));
    }

    @Test
    public void testUpdate() {
        User uFirstName = em.createNamedQuery("User.findByFirstName", User.class).setParameter("firstName", "User1").getSingleResult();
        User uLastName = em.createNamedQuery("User.findByLastName", User.class).setParameter("lastName", "User1LN").getSingleResult();
        User uEmail = em.createNamedQuery("User.findByEmail", User.class).setParameter("email", "user1@gmail.com").getSingleResult();
        User uCompanyName = em.createNamedQuery("User.findByCompanyName", User.class).setParameter("companyName", "User1CompanyName").getSingleResult();
        User uPosition = em.createNamedQuery("User.findByPosition", User.class).setParameter("position", "User1Position").getSingleResult();
        assertNotNull(uFirstName.getId());

        String originalFirstName = uFirstName.getFirstName();
        String originalLastName = uLastName.getLastName();
        String originalEmail = uEmail.getEmail();
        String originalCompanyName = uCompanyName.getCompanyName();
        String originalPosition = uPosition.getPosition();
        String newFirstName = "UserInClassUpdate";
        String newLastName = "UserInClassUpdateLN";
        String newEmail = "userInClassUpdate@gmail.com";
        String newCompanyName = "UserInClassCompanyName";
        String newPosition = "UserInClassPosition";

        tx.begin();
        uFirstName.setFirstName(newFirstName);
        uLastName.setLastName(newLastName);
        uEmail.setEmail(newEmail);
        uCompanyName.setCompanyName(newCompanyName);
        uPosition.setPosition(newPosition);
        tx.commit();

        assertNotEquals(originalFirstName, uFirstName.getFirstName());
        assertNotEquals(originalLastName, uLastName.getLastName());
        assertNotEquals(originalEmail, uEmail.getEmail());
        assertNotEquals(originalCompanyName, uCompanyName.getCompanyName());
        assertNotEquals(originalPosition, uPosition.getPosition());
        assertTrue(newFirstName.equals(uFirstName.getFirstName()));
        assertTrue(newLastName.equals(uLastName.getLastName()));
        assertTrue(newEmail.equals(uEmail.getEmail()));
        assertTrue(newCompanyName.equals(uCompanyName.getCompanyName()));
        assertTrue(newPosition.equals(uPosition.getPosition()));

        tx.begin();
        uFirstName.setFirstName(originalFirstName);
        uLastName.setLastName(originalLastName);
        uEmail.setEmail(originalEmail);
        uCompanyName.setCompanyName(originalCompanyName);
        uPosition.setPosition(originalPosition);
        tx.commit();
    }

    @Test
    public void testDelete() {
        // do later
    }

}
