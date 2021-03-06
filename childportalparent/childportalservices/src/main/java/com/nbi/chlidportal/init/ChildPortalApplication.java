package com.nbi.chlidportal.init;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.nbi.chlidportal.resources.AdmissionResource;
import com.nbi.chlidportal.resources.DropoutResource;
import com.nbi.chlidportal.resources.OrgResource;
import com.nbi.chlidportal.resources.RoleResource;
import com.nbi.chlidportal.resources.UserResource;

@ApplicationPath("")
public class ChildPortalApplication extends Application
{
    private Set<Object> singletons = new HashSet();
    private Set<Class<?>> empty = new HashSet();
 
    public ChildPortalApplication() {
        // LIST OF GENERIC RESOURCES
        this.singletons.add(new AdmissionResource());
        this.singletons.add(new UserResource());
        this.singletons.add(new RoleResource());
        this.singletons.add(new OrgResource());
        this.singletons.add(new DropoutResource());
        
     // LIST OF NGO SPECIFIC RESOURCES
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