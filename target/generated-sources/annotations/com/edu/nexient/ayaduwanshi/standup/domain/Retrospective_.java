package com.edu.nexient.ayaduwanshi.standup.domain;

import com.edu.nexient.ayaduwanshi.standup.domain.Project;
import com.edu.nexient.ayaduwanshi.standup.domain.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-20T14:27:13")
@StaticMetamodel(Retrospective.class)
public class Retrospective_ extends BaseEntity_ {

    public static volatile SingularAttribute<Retrospective, String> name;
    public static volatile SingularAttribute<Retrospective, Project> project;
    public static volatile SingularAttribute<Retrospective, String> retroIssue;
    public static volatile SingularAttribute<Retrospective, String> retroIssueType;
    public static volatile ListAttribute<Retrospective, User> users;

}