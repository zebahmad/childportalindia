/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scl.loadlibrary;

import java.security.PublicKey;
import java.util.Date;

/**
 *
 * @author scl0629
 */
public class LoadLibrary {
    public static String LoadingErrorMessage = null;
    
    static {
        try {
             System.out.println("Loading Library");
             System.loadLibrary("FingerprintSensorAPI");
             System.out.println ("Library Loaded Successfully...");
             LoadingErrorMessage = "Libraries Loaded Successfully.";
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            LoadingErrorMessage = "Error in Loading Library";
        } catch (Exception ex) {
            LoadingErrorMessage = "Error in Loading Library";
            ex.printStackTrace();
        }
    }

    public LoadLibrary(){
        //Do nothing
    }

   // public native byte[] encrypt(byte[] key, byte[] data, Integer errorCode);
    public native boolean isDeviceConnected();
    public native int captureFPData(int timeOut);
    public native byte[] getCapturedTemplate();
    public native int getNFIQLevel();
    public native byte[] getCapturedImage();
   // public native String getDeviceSerialNumber();
    public native String getDeviceMake();
    public native String getDeviceInfo();
   // public native String getVersionDll();
   // public native byte[] createImage(byte[] rawimage, int imagelength);
    public native String getDeviceModel();
    public native int compareTemplates(byte[][] capturedTemplates, byte[] currentTemplate, int noOfTemplates);
    
    //public native int Identify(String id, String firstName, String lastName, int timeOut);
}
