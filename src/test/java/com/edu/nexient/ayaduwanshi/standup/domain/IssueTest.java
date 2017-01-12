/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.nexient.ayaduwanshi.standup.domain;

import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ayaduwanshi
 */
public class IssueTest extends AbstractJPATest {

    public IssueTest() {
    }

    @Test
    public void testCreate() {

        String issueName = "IssueInClass";
        String issueType = "IssueInClassType";
        Date issueDate = new GregorianCalendar(2015, (10 - 1), 2).getTime();

        tx.begin();
        Issue issue = new Issue();
        issue.setName(issueName);
        issue.setIssueType(issueType);
        issue.setIssueDate(issueDate);
        em.persist(issue);
        tx.commit();

        assertNotNull(issue.getId());
        assertEquals(issueName, issue.getName());
        assertTrue(issueName.equals(issue.getName()));
        assertEquals(issueType, issue.getIssueType());
        assertTrue(issueType.equals(issue.getIssueType()));
        assertEquals(issueDate, issue.getIssueDate());
        assertTrue(issueDate.equals(issue.getIssueDate()));
    }

    @Test
    public void testRead() {
        Issue iName = em.createNamedQuery("Issue.findByName", Issue.class).setParameter("name", "Issue1").getSingleResult();
        Issue iType = em.createNamedQuery("Issue.findByIssueType", Issue.class).setParameter("issueType", "Issue1Type").getSingleResult();
        Issue iDate = em.createNamedQuery("Issue.findByIssueDate", Issue.class).setParameter("issueDate", new GregorianCalendar(2016, (12 - 1), 14).getTime()).getSingleResult();
        assertNotNull(iName.getId());

        String originalIssue = iName.getName();
        String originalIssueType = iType.getIssueType();
        Date originalIssueDate = iDate.getIssueDate();

        tx.begin();
        em.persist(iName);
        em.persist(iType);
        em.persist(iDate);
        tx.commit();

        assertEquals(originalIssue, iName.getName());
        assertTrue(originalIssue.equals(iName.getName()));
        assertEquals(originalIssueType, iType.getIssueType());
        assertTrue(originalIssueType.equals(iType.getIssueType()));
        assertEquals(originalIssueDate, iDate.getIssueDate());
        assertTrue(originalIssueDate.equals(iDate.getIssueDate()));
    }

    @Test
    public void testUpdate() {
        Issue iName = em.createNamedQuery("Issue.findByName", Issue.class).setParameter("name", "Issue1").getSingleResult();
        Issue iType = em.createNamedQuery("Issue.findByIssueType", Issue.class).setParameter("issueType", "Issue1Type").getSingleResult();
        Issue iDate = em.createNamedQuery("Issue.findByIssueDate", Issue.class).setParameter("issueDate", new GregorianCalendar(2016, (12 - 1), 14).getTime()).getSingleResult();
        assertNotNull(iName.getId());

        String originalIssue = iName.getName();
        String newIssue = "IssueInClassUpdate";
        String originalIssueType = iType.getIssueType();
        String newIssueType = "IssueInClassUpdateType";
        Date originalIssueDate = iDate.getIssueDate();
        Date newIssueDate = new GregorianCalendar(2016, (12 - 1), 15).getTime();

        tx.begin();
        iName.setName(newIssue);
        iType.setIssueType(newIssueType);
        iDate.setIssueDate(newIssueDate);
        tx.commit();

        assertNotEquals(originalIssue, iName.getName());
        assertTrue(newIssue.equals(iName.getName()));
        assertNotEquals(originalIssueType, iType.getIssueType());
        assertTrue(newIssueType.equals(iType.getIssueType()));
        assertNotEquals(originalIssueDate, iDate.getIssueDate());
        assertTrue(newIssueDate.equals(iDate.getIssueDate()));

        tx.begin();
        iName.setName(originalIssue);
        iType.setIssueType(originalIssueType);
        iDate.setIssueDate(originalIssueDate);
        tx.commit();
    }

    @Test
    public void testDelete() {
        // do later
    }

}
