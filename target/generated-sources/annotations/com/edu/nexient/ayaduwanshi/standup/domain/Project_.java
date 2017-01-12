package com.edu.nexient.ayaduwanshi.standup.domain;

import com.edu.nexient.ayaduwanshi.standup.domain.Guest;
import com.edu.nexient.ayaduwanshi.standup.domain.Issue;
import com.edu.nexient.ayaduwanshi.standup.domain.Retrospective;
import com.edu.nexient.ayaduwanshi.standup.domain.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-20T14:27:13")
@StaticMetamodel(Project.class)
public class Project_ extends BaseEntity_ {

    public static volatile SingularAttribute<Project, String> clientName;
    public static volatile SingularAttribute<Project, String> name;
    public static volatile SingularAttribute<Project, String> projectType;
    public static volatile ListAttribute<Project, Retrospective> retrospectives;
    public static volatile ListAttribute<Project, Guest> guests;
    public static volatile ListAttribute<Project, Issue> issues;
    public static volatile ListAttribute<Project, User> users;

}