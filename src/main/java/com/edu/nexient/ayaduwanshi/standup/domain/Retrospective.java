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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ayaduwanshi
 */
@Entity
@Table(name = "Retro")
@NamedQueries({
    @NamedQuery(name = "Retrospective.findById", query = "select r from Retrospective r where r.id = :id")
    ,
    @NamedQuery(name = "Retrospective.findByName", query = "select r from Retrospective r where r.name = :name")
    ,
    @NamedQuery(name = "Retrospective.findByRetroIssue", query = "select r from Retrospective r where r.retroIssue = :retroIssue")
    ,
    @NamedQuery(name = "Retrospective.findByRetroIssueType", query = "select r from Retrospective r where r.retroIssueType = :retroIssueType")
    ,
    @NamedQuery(name = "Retrospective.findAll", query = "select r from Retrospective r"),})
public class Retrospective extends BaseEntity implements Serializable {

    private String name;
    private String retroIssue;
    private String retroIssueType;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    @ManyToMany(mappedBy = "retrospectives")
    private List<User> users = new ArrayList<>();

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
     * Get the value of retroIssue
     *
     * @return the value of retroIssue
     */
    public String getRetroIssue() {
        return retroIssue;
    }

    /**
     * Set the value of retroIssue
     *
     * @param retroIssue new value of retroIssue
     */
    public void setRetroIssue(String retroIssue) {
        this.retroIssue = retroIssue;
    }

    /**
     * Get the value of retroIssueType
     *
     * @return the value of retroIssueType
     */
    public String getRetroIssueType() {
        return retroIssueType;
    }

    /**
     * Set the value of retroIssueType
     *
     * @param retroIssueType new value of retroIssueType
     */
    public void setRetroIssueType(String retroIssueType) {
        this.retroIssueType = retroIssueType;
    }

    /**
     * Get the value of project
     *
     * @return the value of project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Set the value of project
     *
     * @param project new value of project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Get the value of users
     *
     * @return the value of users
     */
    public List<User> getUsers() {
        return users;
    }

    public Retrospective() {
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder(super.toString());
//        sb.append("\n\t");
//        sb.append("Retrospective{name=").append(name).append(", retroIssue=").append(retroIssue).append(", retroIssueType=").append(retroIssueType).append('}');
//        return sb.toString();
//    }

}
