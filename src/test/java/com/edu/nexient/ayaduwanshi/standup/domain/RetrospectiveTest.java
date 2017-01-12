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
public class RetrospectiveTest extends AbstractJPATest {

    public RetrospectiveTest() {

    }

    @Test
    public void testCreate() {
        String retroName = "RetroInClass";
        String retroIssue = "RetroInClassIssue";
        String retroIssueType = "RetroInClassType";

        tx.begin();
        Retrospective retro = new Retrospective();
        retro.setName(retroName);
        retro.setRetroIssue(retroIssue);
        retro.setRetroIssueType(retroIssueType);
        em.persist(retro);
        tx.commit();

        assertNotNull(retro.getId());
        assertEquals(retroName, retro.getName());
        assertEquals(retroIssue, retro.getRetroIssue());
        assertEquals(retroIssueType, retro.getRetroIssueType());
        assertTrue(retroName.equals(retro.getName()));
        assertTrue(retroIssue.equals(retro.getRetroIssue()));
        assertTrue(retroIssueType.equals(retro.getRetroIssueType()));
    }

    @Test
    public void testRead() {
        Retrospective rName = em.createNamedQuery("Retrospective.findByName", Retrospective.class).setParameter("name", "Retro1").getSingleResult();
        Retrospective rIssue = em.createNamedQuery("Retrospective.findByRetroIssue", Retrospective.class).setParameter("retroIssue", "Retro1Issue").getSingleResult();
        Retrospective rIssueType = em.createNamedQuery("Retrospective.findByRetroIssueType", Retrospective.class).setParameter("retroIssueType", "Retro1IssueType").getSingleResult();
        assertNotNull(rName.getId());

        String originalName = rName.getName();
        String originalIssue = rIssue.getRetroIssue();
        String originalIssueType = rIssueType.getRetroIssueType();

        tx.begin();
        em.persist(rName);
        em.persist(rIssue);
        em.persist(rIssueType);
        tx.commit();

        assertEquals(originalName, rName.getName());
        assertEquals(originalIssue, rIssue.getRetroIssue());
        assertEquals(originalIssueType, rIssueType.getRetroIssueType());
        assertTrue(originalName.equals(rName.getName()));
        assertTrue(originalIssue.equals(rIssue.getRetroIssue()));
        assertTrue(originalIssueType.equals(rIssueType.getRetroIssueType()));

    }

    @Test
    public void testUpdate() {
        Retrospective rName = em.createNamedQuery("Retrospective.findByName", Retrospective.class).setParameter("name", "Retro1").getSingleResult();
        Retrospective rIssue = em.createNamedQuery("Retrospective.findByRetroIssue", Retrospective.class).setParameter("retroIssue", "Retro1Issue").getSingleResult();
        Retrospective rIssueType = em.createNamedQuery("Retrospective.findByRetroIssueType", Retrospective.class).setParameter("retroIssueType", "Retro1IssueType").getSingleResult();
        assertNotNull(rName.getId());

        String originalName = rName.getName();
        String originalIssue = rIssue.getRetroIssue();
        String originalIssueType = rIssueType.getRetroIssueType();
        String newName = "RetroInClassUpdate";
        String newIssue = "RetroInClassUpdateIssue";
        String newIssueType = "RetroInClassUpdateType";

        tx.begin();
        rName.setName(newName);
        rIssue.setRetroIssue(newIssue);
        rIssueType.setRetroIssueType(newIssueType);
        tx.commit();

        assertNotEquals(originalName, rName.getName());
        assertNotEquals(originalIssue, rIssue.getRetroIssue());
        assertNotEquals(originalIssueType, rIssueType.getRetroIssueType());
        assertTrue(newName.equals(rName.getName()));
        assertTrue(newIssue.equals(rIssue.getRetroIssue()));
        assertTrue(newIssueType.equals(rIssueType.getRetroIssueType()));

        tx.begin();
        rName.setName(originalName);
        rIssue.setRetroIssue(originalIssue);
        rIssueType.setRetroIssueType(originalIssueType);
        tx.commit();
    }

    @Test
    public void testDelete() {
        // do later
    }

}
