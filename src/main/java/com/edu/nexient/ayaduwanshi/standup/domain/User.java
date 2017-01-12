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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author ayaduwanshi
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "User.findById", query = "select u from User u where u.id = :id")
    ,
    @NamedQuery(name = "User.findByFirstName", query = "select u from User u where u.firstName = :firstName")
    ,
    @NamedQuery(name = "User.findByLastName", query = "select u from User u where u.lastName = :lastName")
    ,
    @NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email = :email")
    ,
    @NamedQuery(name = "User.findByCompanyName", query = "select u from User u where u.companyName = :companyName")
    ,
    @NamedQuery(name = "User.findByPosition", query = "select u from User u where u.position = :position")
    ,
    @NamedQuery(name = "User.findAll", query = "select u from User u"),})
public class User extends Person implements Serializable {

    private String companyName;
    private String position;

    @ManyToMany
    @JoinTable(name = "user_issues", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "issue_id"))
    private List<Issue> issues = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user_projects", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projects = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user_retros", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "retro_id"))
    private List<Retrospective> retrospectives = new ArrayList<>();

    /**
     * Get the value of companyName
     *
     * @return the value of companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Set the value of companyName
     *
     * @param companyName new value of companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Get the value of position
     *
     * @return the value of position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Set the value of position
     *
     * @param position new value of position
     */
    public void setPosition(String position) {
        this.position = position;
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
     * Get the value of projects
     *
     * @return the value of projects
     */
    public List<Project> getProjects() {
        return projects;
    }

    /**
     * Get the value of retrospectives
     *
     * @return the value of retrospectives
     */
    public List<Retrospective> getRetrospectives() {
        return retrospectives;
    }

    public User() {
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder(super.toString());
//        sb.append("\n\t");
//        sb.append("User{companyName=").append(companyName).append(", position=").append(position).append('}');
//        return sb.toString();
//    }

}
