/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.nexient.ayaduwanshi.standup.domain;

import javax.persistence.MappedSuperclass;

/**
 *
 * @author ayaduwanshi
 */
@MappedSuperclass
public abstract class Person extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder(super.toString());
//        sb.append("\n\t");
//        sb.append("Person{firstName=").append(firstName).append(", lastName=").append(lastName).append(", email=").append(email).append('}');
//        return sb.toString();
//    }

}
