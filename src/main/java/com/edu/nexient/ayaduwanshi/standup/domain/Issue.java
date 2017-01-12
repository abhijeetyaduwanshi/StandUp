/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.nexient.ayaduwanshi.standup.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ayaduwanshi
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Issue.findById", query = "select i from Issue i where i.id = :id")
    ,
    @NamedQuery(name = "Issue.findByName", query = "select i from Issue i where i.name = :name")
    ,
    @NamedQuery(name = "Issue.findByIssueType", query = "select i from Issue i where i.issueType = :issueType")
    ,
    @NamedQuery(name = "Issue.findByIssueDate", query = "select i from Issue i where i.issueDate = :issueDate")
    ,
    @NamedQuery(name = "Issue.findAll", query = "select i from Issue i"),})
public class Issue extends BaseEntity implements Serializable {

    private String name;
    private String issueType;
    @Temporal(TemporalType.DATE)
    private Date issueDate;

    // remove the set method of the relationships
    @ManyToMany(mappedBy = "issues") // mappedBy can be used on either side of the relationship in ManyToMany and the JoinTable should be done on other side(inverse side) of the relationship
    private List<User> users = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

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
     * Get the value of issueType
     *
     * @return the value of issueType
     */
    public String getIssueType() {
        return issueType;
    }

    /**
     * Set the value of issueType
     *
     * @param issueType new value of issueType
     */
    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    /**
     * Get the value of issueDate
     *
     * @return the value of issueDate
     */
    public Date getIssueDate() {
        return issueDate;
    }

    /**
     * Set the value of issueDate
     *
     * @param issueDate new value of issueDate
     */
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
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

    public Issue() {
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder(super.toString());
//        sb.append("\n\t");
//        sb.append("Issue{name=").append(name).append(", issueType=").append(issueType).append(", issueDate=").append(issueDate).append('}');
//        return sb.toString();
//    }

}
