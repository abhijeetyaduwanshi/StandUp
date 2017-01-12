package com.edu.nexient.ayaduwanshi.standup.domain;

import com.edu.nexient.ayaduwanshi.standup.domain.Project;
import com.edu.nexient.ayaduwanshi.standup.domain.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-20T14:27:13")
@StaticMetamodel(Issue.class)
public class Issue_ extends BaseEntity_ {

    public static volatile SingularAttribute<Issue, String> issueType;
    public static volatile SingularAttribute<Issue, String> name;
    public static volatile SingularAttribute<Issue, Project> project;
    public static volatile SingularAttribute<Issue, Date> issueDate;
    public static volatile ListAttribute<Issue, User> users;

}