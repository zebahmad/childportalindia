/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.auth;

import com.scl.loadlibrary.LoadLibrary;
import java.security.MessageDigest;
import java.io.InputStream;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
//import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.beans.Encoder;
import java.io.*;
import java.util.TimeZone;
import java.security.*;

//import com.sun.org.apache.xml.internal.security.encryption;

/**
 *
 * @author SCL0696
 */
public class BioCaptureManager {

    LoadLibrary auth;
    private BioCaptureManager() {
        auth = new LoadLibrary();
    }
    private static BioCaptureManager bioCaptureManager;

    public static synchronized BioCaptureManager getInstance() {
        if (bioCaptureManager == null) {
            bioCaptureManager = new BioCaptureManager();
        }
        return bioCaptureManager;
    }

   
    public boolean isDeviceConnected() {
        return auth.isDeviceConnected();
    }

    public String getDeviceMake() {
        return auth.getDeviceMake();
    }

    public String getDeviceModel() {
        return auth.getDeviceModel();
    }

    
    public String getCapturedImage()
    {
        return Base64.encode(auth.getCapturedImage());
    }

    public String getDeviceInfo() {
        return auth.getDeviceInfo();
    }

    public int getNFIQ()
    {
        return auth.getNFIQLevel();
    }
    
    public int captureFPData(int timeOut) {
        int result=0;
        try {
            result = auth.captureFPData(timeOut);

        } catch (Exception e) {
            return result;
        }
        return result;
    }

    public String getCapturedTemplate() {
        return Base64.encode(auth.getCapturedTemplate());
    }
    
     public int compareTemplates(String capturedTemplates, String currentTemplate, int NumberOfTemplates)
     {          
         byte[] capturedTemp = Base64.decode(capturedTemplates);
         byte[] currentTemp = Base64.decode(currentTemplate);
         byte[][] capturedTemplates1 = new byte[1][];
         capturedTemplates1[0] = new byte[capturedTemp.length];
         System.arraycopy(capturedTemp, 0, capturedTemplates1[0], 0, capturedTemp.length);
         return  auth.compareTemplates(capturedTemplates1,currentTemp,1);
     }
}