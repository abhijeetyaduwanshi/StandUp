package com.edu.nexient.ayaduwanshi.standup.domain;

import com.edu.nexient.ayaduwanshi.standup.domain.Issue;
import com.edu.nexient.ayaduwanshi.standup.domain.Project;
import com.edu.nexient.ayaduwanshi.standup.domain.Retrospective;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-20T14:27:13")
@StaticMetamodel(User.class)
public class User_ extends Person_ {

    public static volatile ListAttribute<User, Project> projects;
    public static volatile SingularAttribute<User, String> companyName;
    public static volatile ListAttribute<User, Retrospective> retrospectives;
    public static volatile SingularAttribute<User, String> position;
    public static volatile ListAttribute<User, Issue> issues;

}