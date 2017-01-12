/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.nexient.ayaduwanshi.standup.domain;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ayaduwanshi
 */
public class ProjectTest extends AbstractJPATest {

    public ProjectTest() {
    }

    @Test
    public void testCreate() {

        String projectName = "ProjectInClass";
        String projectClientName = "ProjectInClassClientName";
        String projectType = "ProjectInClassType";

        tx.begin();
        Project project = new Project();
        project.setName(projectName);
        project.setClientName(projectClientName);
        project.setProjectType(projectType);
        em.persist(project);
        tx.commit();

        assertNotNull(project.getId());
        assertEquals(projectName, project.getName());
        assertTrue(projectName.equals(project.getName()));
        assertEquals(projectClientName, project.getClientName());
        assertTrue(projectClientName.equals(project.getClientName()));
        assertEquals(projectType, project.getProjectType());
        assertTrue(projectType.equals(project.getProjectType()));
    }

    @Test
    public void testRead() {
        Project pName = em.createNamedQuery("Project.findByName", Project.class).setParameter("name", "Project1").getSingleResult();
        Project pClientName = em.createNamedQuery("Project.findByClientName", Project.class).setParameter("clientName", "Project1ClientName").getSingleResult();
        Project pType = em.createNamedQuery("Project.findByProjectType", Project.class).setParameter("projectType", "Project1Type").getSingleResult();
        assertNotNull(pName.getId());

        String originalProjectName = pName.getName();
        String originalProjectClientName = pClientName.getClientName();
        String originalProjectType = pType.getProjectType();

        tx.begin();
        em.persist(pName);
        em.persist(pClientName);
        em.persist(pType);
        tx.commit();

        assertEquals(originalProjectName, pName.getName());
        assertTrue(originalProjectName.equals(pName.getName()));
        assertEquals(originalProjectClientName, pClientName.getClientName());
        assertTrue(originalProjectClientName.equals(pClientName.getClientName()));
        assertEquals(originalProjectType, pType.getProjectType());
        assertTrue(originalProjectType.equals(pType.getProjectType()));

//        // r/t test
//        List<Project> projects = em.createNamedQuery("Project.findAll", Project.class).getResultList();
//        assertTrue(projects.size() == 1);
//        assertFalse(projects.isEmpty());
//
//        for (Project p : projects) {
//            System.out.println(p.toString());
//
//            for (Retrospective r : p.getRetrospectives()) {
//                System.out.println(r.toString());
//            }
//        }
    }

    @Test
    public void testUpdate() {
        Project pName = em.createNamedQuery("Project.findByName", Project.class).setParameter("name", "Project1").getSingleResult();
        Project pClientName = em.createNamedQuery("Project.findByClientName", Project.class).setParameter("clientName", "Project1ClientName").getSingleResult();
        Project pType = em.createNamedQuery("Project.findByProjectType", Project.class).setParameter("projectType", "Project1Type").getSingleResult();
        assertNotNull(pName.getId());

        String originalName = pName.getName();
        String originalClientName = pClientName.getClientName();
        String originalType = pType.getProjectType();
        String newName = "ProjectInClassUpdate";
        String newClientName = "ProjectInClassClientName";
        String newType = "ProjectInClassType";

        tx.begin();
        pName.setName(newName);
        pClientName.setClientName(newClientName);
        pType.setProjectType(newType);
        tx.commit();

        assertNotEquals(originalName, pName.getName());
        assertNotEquals(originalClientName, pClientName.getClientName());
        assertNotEquals(originalType, pType.getProjectType());
        assertTrue(newName.equals(pName.getName()));
        assertTrue(newClientName.equals(pClientName.getClientName()));
        assertTrue(newType.equals(pType.getProjectType()));

        tx.begin();
        pName.setName(originalName);
        pClientName.setClientName(originalClientName);
        pType.setProjectType(originalType);
        tx.commit();

    }

    @Test
    public void testDelete() {
//        Project pName = em.createNamedQuery("Project.findByName", Project.class).setParameter("name", "Mobile punch application").getSingleResult();
//        Project pClientName = em.createNamedQuery("Project.findByClientName", Project.class).setParameter("clientName", "THD").getSingleResult();
//        Project pType = em.createNamedQuery("Project.findByProjectType", Project.class).setParameter("projectType", "mobile").getSingleResult();
////        Project p = em.createNamedQuery("Project.findAll", Project.class).getSingleResult();
//
//        assertNotNull(pName.getId());
//
//        tx.begin();
//        for (Issue i : pName.getIssues()) {
//            em.remove(i);
//        }
//        for (Retrospective r : pName.getRetrospectives()) {
//            em.remove(r);
//        }
//        em.remove(pName);
//        em.remove(pClientName);
//        em.remove(pType);
//        tx.commit();
//
//        Project postRemove = em.find(Project.class, 1L);
//        assertNull(postRemove);
    }

}
