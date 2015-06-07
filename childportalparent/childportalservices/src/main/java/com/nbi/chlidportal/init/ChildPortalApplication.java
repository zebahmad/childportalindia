package com.nbi.chlidportal.init;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.nbi.chlidportal.resources.AdmissionResource;
import com.nbi.chlidportal.resources.DropoutResource;
import com.nbi.chlidportal.resources.OrgResource;
import com.nbi.chlidportal.resources.UserResource;
import com.nbi.chlidportal.resources.UserRoleResource;

@ApplicationPath("")
public class ChildPortalApplication extends Application
{
    private Set<Object> singletons = new HashSet();
    private Set<Class<?>> empty = new HashSet();
 
    public ChildPortalApplication() {
        // ADD YOUR RESTFUL RESOURCES HERE
        this.singletons.add(new AdmissionResource());
        this.singletons.add(new UserResource());
        this.singletons.add(new UserRoleResource());
        this.singletons.add(new OrgResource());
        this.singletons.add(new DropoutResource());
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