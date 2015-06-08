/**
 * 
 */
package com.nbi.childportal.pojos.rest;

import java.lang.reflect.Field;

import com.nbi.childportal.pojos.Address;
import com.nbi.childportal.pojos.ChildAdmission;
import com.nbi.childportal.pojos.Organization;
import com.nbi.childportal.pojos.User;

/**
 * @author zahmad
 *
 */
public class BaseTo {
	
	protected static void setFieldValue(ChildAdmission childAdmission, String fieldName, Object value) throws Exception{
		Field admissionIdField = ChildAdmission.class.getDeclaredField(fieldName);
		admissionIdField.setAccessible(true);
		admissionIdField.set(childAdmission, value);
	}
	
	protected static void setFieldValue(ChildAdmissionTo childAdmissionTo, String fieldName, Object value) throws Exception{
		Field admissionIdField = ChildAdmissionTo.class.getDeclaredField(fieldName);
		admissionIdField.setAccessible(true);
		admissionIdField.set(childAdmissionTo, value);
	}
	
	protected static void setFieldValue(User user, String fieldName, Object value) throws Exception{
		Field admissionIdField = User.class.getDeclaredField(fieldName);
		admissionIdField.setAccessible(true);
		admissionIdField.set(user, value);
	}

	protected static void setFieldValue(UserTo user, String fieldName, Object value) throws Exception{
		Field admissionIdField = UserTo.class.getDeclaredField(fieldName);
		admissionIdField.setAccessible(true);
		admissionIdField.set(user, value);
	}
	
	protected static void setFieldValue(Address user, String fieldName, Object value) throws Exception{
		Field admissionIdField = Address.class.getDeclaredField(fieldName);
		admissionIdField.setAccessible(true);
		admissionIdField.set(user, value);
	}
	
	protected static void setFieldValue(AddressTo user, String fieldName, Object value) throws Exception{
		Field admissionIdField = AddressTo.class.getDeclaredField(fieldName);
		admissionIdField.setAccessible(true);
		admissionIdField.set(user, value);
	}
	
	protected static void setFieldValue(Organization user, String fieldName, Object value) throws Exception{
		Field admissionIdField = Organization.class.getDeclaredField(fieldName);
		admissionIdField.setAccessible(true);
		admissionIdField.set(user, value);
	}
	
	protected static void setFieldValue(OrganizationTo user, String fieldName, Object value) throws Exception{
		Field admissionIdField = OrganizationTo.class.getDeclaredField(fieldName);
		admissionIdField.setAccessible(true);
		admissionIdField.set(user, value);
	}
}
