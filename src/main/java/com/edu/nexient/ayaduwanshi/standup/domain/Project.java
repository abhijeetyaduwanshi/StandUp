/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.nexient.ayaduwanshi.standup.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author ayaduwanshi
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Project.findById", query = "select p from Project p where p.id = :id")
    ,
    @NamedQuery(name = "Project.findByName", query = "select p from Project p where p.name = :name")
    ,
    @NamedQuery(name = "Project.findByClientName", query = "select p from Project p where p.clientName = :clientName")
    ,
    @NamedQuery(name = "Project.findByProjectType", query = "select p from Project p where p.projectType = :projectType")
    ,
    @NamedQuery(name = "Project.findAll", query = "select p from Project p"),})
public class Project extends BaseEntity implements Serializable {

    private String name;
    private String clientName;
    private String projectType;

    @OneToMany(mappedBy = "project") // mappedBy should be used in many side of the relationship in OneToMany
    private List<Retrospective> retrospectives = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<Issue> issues = new ArrayList<>();

    @ManyToMany(mappedBy = "projects")
    private List<User> users = new ArrayList<>();

    @ManyToMany(mappedBy = "projects")
    private List<Guest> guests = new ArrayList<>();

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of clientName
     *
     * @return the value of clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Set the value of clientName
     *
     * @param clientName new value of clientName
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * Get the value of projectType
     *
     * @return the value of projectType
     */
    public String getProjectType() {
        return projectType;
    }

    /**
     * Set the value of projectType
     *
     * @param projectType new value of projectType
     */
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    /**
     * Get the value of retrospectives
     *
     * @return the value of retrospectives
     */
    public List<Retrospective> getRetrospectives() {
        return retrospectives;
    }

    /**
     * Get the value of issues
     *
     * @return the value of issues
     */
    public List<Issue> getIssues() {
        return issues;
    }

    /**
     * Get the value of users
     *
     * @return the value of users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Get the value of guests
     *
     * @return the value of guests
     */
    public List<Guest> getGuests() {
        return guests;
    }

    public Project() {
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder(super.toString());
//        sb.append("\n\t");
//        sb.append("Project{name=").append(name).append(", clientName=").append(clientName).append(", projectType=").append(projectType).append('}');
//        return sb.toString();
//    }

}
