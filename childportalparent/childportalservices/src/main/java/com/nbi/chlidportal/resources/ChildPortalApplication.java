package com.nbi.chlidportal.resources;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("")
public class ChildPortalApplication extends Application
{
    private Set<Object> singletons = new HashSet();
    private Set<Class<?>> empty = new HashSet();
 
    public ChildPortalApplication() {
        // ADD YOUR RESTFUL RESOURCES HERE
        this.singletons.add(new SchoolAdmissionRecordResource());
    }
 
    public Set<Class<?>> getClasses()
    {
        return this.empty;
    }
 
    public Set<Object> getSingletons()
    {
        return this.singletons;
    }
}