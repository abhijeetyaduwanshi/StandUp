/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.nexient.ayaduwanshi.standup.domain;

import java.util.GregorianCalendar;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author ayaduwanshi
 */
public class AbstractJPATest {

    private static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;

    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("nexPU");
    }

    @AfterClass
    public static void teadDownClass() {
        emf.close();
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        createTestData();
    }

    private void createTestData() {
        tx.begin();
        // guest class
        Guest guest = new Guest();
        guest.setFirstName("Guest1");
        guest.setLastName("Guest1LN");
        guest.setEmail("guest1@gmail.com");

        Guest guest2 = new Guest();
        guest2.setFirstName("Guest2");
        guest2.setLastName("Guest2LN");
        guest2.setEmail("guest2@gmail.com");

        // issue class
        Issue issue = new Issue();
        issue.setName("Issue1");
        issue.setIssueType("Issue1Type");
        issue.setIssueDate(new GregorianCalendar(2016, (12 - 1), 14).getTime()); // yyyy, mm, dd; month are set from 0 to 11 like and array so have to decrement 1 from it

        Issue issue2 = new Issue();
        issue2.setName("Issue2");
        issue2.setIssueType("Issue2Type");
        issue2.setIssueDate(new GregorianCalendar(2016, (12 - 1), 15).getTime());

        // project
        Project project = new Project();
        project.setName("Project1");
        project.setClientName("Project1ClientName");
        project.setProjectType("Project1Type");

        Project project2 = new Project();
        project2.setName("Project2");
        project2.setClientName("Project2ClientName");
        project2.setProjectType("Project2Type");

        // retrospective
        Retrospective retro = new Retrospective();
        retro.setName("Retro1");
        retro.setRetroIssue("Retro1Issue");
        retro.setRetroIssueType("Retro1IssueType");

        Retrospective retro2 = new Retrospective();
        retro2.setName("Retro2");
        retro2.setRetroIssue("Retro2Issue");
        retro2.setRetroIssueType("Retro2IssueType");

        // users
        User user = new User();
        user.setFirstName("User1");
        user.setLastName("User1LN");
        user.setEmail("user1@gmail.com");
        user.setCompanyName("User1CompanyName");
        user.setPosition("User1Position");

        User user2 = new User();
        user2.setFirstName("User2");
        user2.setLastName("User2LN");
        user2.setEmail("user2@gmail.com");
        user2.setCompanyName("User2CompanyName");
        user2.setPosition("User2Position");

        // r/t b/t project and guest
        // many to many r/t
        project.getGuests().add(guest);
        project.getGuests().add(guest2);
        project2.getGuests().add(guest);
        project2.getGuests().add(guest2);
        guest.getProjects().add(project);
        guest.getProjects().add(project2);
        guest2.getProjects().add(project);
        guest2.getProjects().add(project2);

        // r/t b/t issue and project
        // many to one r/t
        project.getIssues().add(issue);
        project.getIssues().add(issue2);
        project2.getIssues().add(issue);
        project2.getIssues().add(issue2);
        issue.setProject(project);
        issue.setProject(project2);
        issue2.setProject(project);
        issue2.setProject(project2);

        // r/t b/t issue and user
        // many to many r/t
        user.getIssues().add(issue);
        user.getIssues().add(issue2);
        user2.getIssues().add(issue);
        user2.getIssues().add(issue2);
        issue.getUsers().add(user);
        issue.getUsers().add(user2);
        issue2.getUsers().add(user);
        issue2.getUsers().add(user2);

        // set r/t b/t project and retrospective
        // the owning side of the relationship populates the fKey in the database
        // one to many r/t
        project.getRetrospectives().add(retro);
        project.getRetrospectives().add(retro2);
        project2.getRetrospectives().add(retro);
        project2.getRetrospectives().add(retro2);
        retro.setProject(project);
        retro.setProject(project2);
        retro2.setProject(project);
        retro2.setProject(project2);

        // r/t b/t user and project
        // many to many r/t
        project.getUsers().add(user);
        project.getUsers().add(user2);
        project2.getUsers().add(user);
        project2.getUsers().add(user2);
        user.getProjects().add(project);
        user.getProjects().add(project2);
        user2.getProjects().add(project);
        user2.getProjects().add(project2);

        // r/t b/t retro and user
        // many to many
        user.getRetrospectives().add(retro);
        user.getRetrospectives().add(retro2);
        user2.getRetrospectives().add(retro);
        user2.getRetrospectives().add(retro2);
        retro.getUsers().add(user);
        retro.getUsers().add(user2);
        retro2.getUsers().add(user);
        retro2.getUsers().add(user2);

        em.persist(guest);
        em.persist(guest2);
        em.persist(issue);
        em.persist(issue2);
        em.persist(project); // is you get a exception error -> a new object was found that could not cascade bla bla bla
        em.persist(project2);
        em.persist(retro); // go to the owning side of the relationship and with the relationship annotation add the cascade property
        em.persist(retro2);
        em.persist(user); // eg: @ManyToMany(mappedBy = "[prop]", cascade = cascadeType.PERSIST)
        em.persist(user2);
        tx.commit(); // that will take care of things, if still things goes wrong then you are doomed bro
    }

    @After
    public void tearDown() {
        removeTestData();
        em.close();
    }

    private void removeTestData() {
        // one way of removing data
        TypedQuery<Guest> qFirstName = em.createQuery("select g from Guest g where g.firstName = ?1", Guest.class);
        qFirstName.setParameter(1, "Guest1");
        Guest gFirstName = qFirstName.getSingleResult();

        TypedQuery<Guest> qLastName = em.createQuery("select g from Guest g where g.lastName = ?2", Guest.class);
        qLastName.setParameter(2, "Guest1LN");
        Guest gLastName = qLastName.getSingleResult();

        TypedQuery<Guest> qEmail = em.createQuery("select g from Guest g where g.email = ?3", Guest.class);
        qEmail.setParameter(3, "guest1@gmail.com");
        Guest gEmail = qEmail.getSingleResult();

        // easy way of removing data
        Issue iName = em.createNamedQuery("Issue.findByName", Issue.class).setParameter("name", "Issue1").getSingleResult();
        Issue iType = em.createNamedQuery("Issue.findByIssueType", Issue.class).setParameter("issueType", "Issue1Type").getSingleResult();
        Issue iDate = em.createNamedQuery("Issue.findByIssueDate", Issue.class).setParameter("issueDate", new GregorianCalendar(2016, (12 - 1), 14).getTime()).getSingleResult();

        Project pName = em.createNamedQuery("Project.findByName", Project.class).setParameter("name", "Project1").getSingleResult();
        Project pClientName = em.createNamedQuery("Project.findByClientName", Project.class).setParameter("clientName", "Project1ClientName").getSingleResult();
        Project pType = em.createNamedQuery("Project.findByProjectType", Project.class).setParameter("projectType", "Project1Type").getSingleResult();

        Retrospective rName = em.createNamedQuery("Retrospective.findByName", Retrospective.class).setParameter("name", "Retro1").getSingleResult();
        Retrospective rIssue = em.createNamedQuery("Retrospective.findByRetroIssue", Retrospective.class).setParameter("retroIssue", "Retro1Issue").getSingleResult();
        Retrospective rIssueType = em.createNamedQuery("Retrospective.findByRetroIssueType", Retrospective.class).setParameter("retroIssueType", "Retro1IssueType").getSingleResult();

        User uFirstName = em.createNamedQuery("User.findByFirstName", User.class).setParameter("firstName", "User1").getSingleResult();
        User uLastName = em.createNamedQuery("User.findByLastName", User.class).setParameter("lastName", "User1LN").getSingleResult();
        User uEmail = em.createNamedQuery("User.findByEmail", User.class).setParameter("email", "user1@gmail.com").getSingleResult();
        User uCompanyName = em.createNamedQuery("User.findByCompanyName", User.class).setParameter("companyName", "User1CompanyName").getSingleResult();
        User uPosition = em.createNamedQuery("User.findByPosition", User.class).setParameter("position", "User1Position").getSingleResult();

        tx.begin();

//        for (Project p : em.createNamedQuery("Project.findAll", Project.class).getResultList()) {
//            em.remove(p);
//        }
//
//        for (Retrospective r : em.createNamedQuery("Retrospective.findAll", Retrospective.class).getResultList()) {
//            em.remove(r);
//        }
//
//        for (Issue i : em.createNamedQuery("Issue.findAll", Issue.class).getResultList()) {
//            em.remove(i);
//        }
//
//        for (User u : em.createNamedQuery("User.findAll", User.class).getResultList()) {
//            em.remove(u);
//        }
        em.remove(gFirstName);
        em.remove(gLastName);
        em.remove(gEmail);
        em.remove(iName);
        em.remove(iType);
        em.remove(iDate);
        em.remove(pName);
        em.remove(pClientName);
        em.remove(pType);
        em.remove(rName);
        em.remove(rIssue);
        em.remove(rIssueType);
        em.remove(uFirstName);
        em.remove(uLastName);
        em.remove(uEmail);
        em.remove(uCompanyName);
        em.remove(uPosition);
        tx.commit();
    }

}
