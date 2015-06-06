package com.cp.AadharHelper;

import in.gov.uidai.auth.aua.httpclient.AuthClient;
import in.gov.uidai.auth.device.model.DeviceCollectedAuthData;
import in.gov.uidai.authentication.uid_auth_request_data._1.MatchingStrategy;

import java.net.URL;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testAuthenticationName(){
    	String authServerURL = "http://auth.uidai.gov.in/1.6";
		try {
			AuthClient authClient = new AuthClient(new URL(authServerURL).toURI());
			
			DeviceCollectedAuthData authData = new DeviceCollectedAuthData();
			authData.setUid("999999990019");
			authData.setName("Shivshankar Choudhury");
			authData.setNameMatchStrategy(MatchingStrategy.E);
			authData.setNameMatchValue(100);
			
			authData.setGender("Male");
			authData.setFullAddress("");
			
			boolean result = authClient.authenticateAuthData(authData);
			System.out.println("Result from authenticateAuthData : " + result);
			
			assertEquals(true, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void testAuthenticationNameNegative(){
    	String authServerURL = "http://auth.uidai.gov.in/1.6";
		try {
			AuthClient authClient = new AuthClient(new URL(authServerURL).toURI());
			
			DeviceCollectedAuthData authData = new DeviceCollectedAuthData();
			authData.setUid("999999990019");
			authData.setName("Wrong Name");
			authData.setNameMatchStrategy(MatchingStrategy.E);
			authData.setNameMatchValue(100);
			
			authData.setGender("Male");
			authData.setFullAddress("");
			
			boolean result = authClient.authenticateAuthData(authData);
			System.out.println("Result from authenticateAuthData : " + result);
			
			assertEquals(false, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void testAuthenticationDoB(){
    	String authServerURL = "http://auth.uidai.gov.in/1.6";
		try {
			AuthClient authClient = new AuthClient(new URL(authServerURL).toURI());
			
			DeviceCollectedAuthData authData = new DeviceCollectedAuthData();
			authData.setUid("999999990019");
			authData.setDob("1968-05-13");
			authData.setDobType("V");
			
			authData.setNameMatchStrategy(MatchingStrategy.E);
			authData.setNameMatchValue(100);
			
			authData.setGender("Male");
			authData.setFullAddress("");
			
			boolean result = authClient.authenticateAuthData(authData);
			System.out.println("Result from authenticateAuthData : " + result);
			
			assertEquals(true, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void testAuthenticationEmail(){
    	String authServerURL = "http://auth.uidai.gov.in/1.6";
		try {
			AuthClient authClient = new AuthClient(new URL(authServerURL).toURI());
			
			DeviceCollectedAuthData authData = new DeviceCollectedAuthData();
			authData.setUid("999999990026");
			authData.setEmail("kma@mailserver.com");
			
			authData.setNameMatchStrategy(MatchingStrategy.E);
			authData.setNameMatchValue(100);
			
			authData.setGender("Male");
			authData.setFullAddress("");
			
			boolean result = authClient.authenticateAuthData(authData);
			System.out.println("Result from authenticateAuthData : " + result);
			
			assertEquals(true, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void testAuthenticationPincode(){
    	String authServerURL = "http://auth.uidai.gov.in/1.6";
		try {
			AuthClient authClient = new AuthClient(new URL(authServerURL).toURI());
			
			DeviceCollectedAuthData authData = new DeviceCollectedAuthData();
			authData.setUid("999999990026");
			authData.setPinCode("313001");
			
			authData.setNameMatchStrategy(MatchingStrategy.E);
			authData.setNameMatchValue(100);
			
			authData.setGender("Male");
			authData.setFullAddress("");
			
			boolean result = authClient.authenticateAuthData(authData);
			System.out.println("Result from authenticateAuthData : " + result);
			
			assertEquals(true, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void testAuthenticationAddress1(){
    	String authServerURL = "http://auth.uidai.gov.in/1.6";
		try {
			AuthClient authClient = new AuthClient(new URL(authServerURL).toURI());
			
			DeviceCollectedAuthData authData = new DeviceCollectedAuthData();
			authData.setUid("999999990026");
			authData.setState("Rajasthan");
			authData.setDistrict("Udaipur");
			authData.setVillage("Udaipur");
			
			authData.setNameMatchStrategy(MatchingStrategy.E);
			authData.setNameMatchValue(100);
			
			authData.setGender("Male");
			authData.setFullAddress("");
			
			boolean result = authClient.authenticateAuthData(authData);
			System.out.println("Result from authenticateAuthData : " + result);
			
			assertEquals(true, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
}
