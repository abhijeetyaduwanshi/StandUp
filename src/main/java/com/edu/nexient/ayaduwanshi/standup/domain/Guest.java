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
    @NamedQuery(name = "Guest.findById", query = "select g from Guest g where g.id = :id")
    ,
    @NamedQuery(name = "Guest.findByFirstName", query = "select g from Guest g where g.firstName = :firstName")
    ,
    @NamedQuery(name = "Guest.findByLastName", query = "select g from Guest g where g.lastName = :lastName")
    ,
    @NamedQuery(name = "Guest.findByEmail", query = "select g from Guest g where g.email = :email")
    ,
    @NamedQuery(name = "Guest.findAll", query = "select g from Guest g"),})
public class Guest extends Person implements Serializable {

    @ManyToMany
    @JoinTable(name = "guest_projects", joinColumns = @JoinColumn(name = "guest_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projects = new ArrayList<>();

    /**
     * Get the value of projects
     *
     * @return the value of projects
     */
    public List<Project> getProjects() {
        return projects;
    }

    public Guest() {
    }

}
