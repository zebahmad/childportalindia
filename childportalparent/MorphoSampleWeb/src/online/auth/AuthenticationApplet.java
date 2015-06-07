/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.auth;

//import com.sun.xml.internal.ws.message.ByteArrayAttachment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;

//import java.nio.ByteBuffer;
//import java.util.ArrayList;
//import java.util.List;
//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 *
 * @author scl0826
 */
public class AuthenticationApplet extends javax.swing.JApplet {

    BioCaptureManager captureManager;
    boolean appletTest = true;
//    String temp=null;
//    byte[] temp1=null;

    /**
     * Initializes the applet EnrolmentApplet
     */
    @Override
    public void init() {
        System.out.println("Init called.");
        initiateCapture();
        this.setVisible(true);
        captureManager = BioCaptureManager.getInstance();
        System.out.println("Capture Manage object created.");
        
        
         if (appletTest) {

             try {
                 boolean deviceConnected = isDeviceConnected();
                 String deviceMake = getDeviceMake();
                 String deviceInfo = getDeviceInfo();
                 String deviceModel = getDeviceModel();
                 int captureResult = CaptureFingerprint(30);
                 String template = getCapturedTemplate();
                 System.out.println("template: " + template);
                 String image = getCapturedImage();
                 System.out.println("image: " + image);
                 /*int nfiq = getNFIQ();
                 int compareResult = compareTemplates(template, template,1);
                 System.out.println("Match Result: " + compareResult);*/
             } catch (Exception e) {
                 e.printStackTrace();
             }
            
           
        }
    }

    private void initiateCapture() {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AuthenticationApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuthenticationApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuthenticationApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuthenticationApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the applet
         */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {

                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.setSize(375, 230);

        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

       
    public String getCapturedImage()
    {
        return captureManager.getCapturedImage();
    }
    
    public  boolean isDeviceConnected() {
        return captureManager.isDeviceConnected();
    }
     
    public String getDeviceModel()
    {
         return captureManager.getDeviceModel();
    }
     
    public String getDeviceMake()
    {
         return captureManager.getDeviceMake();
    }
     
    public String getDeviceInfo()
    {
        return captureManager.getDeviceInfo();
    }
     
     
    public int CaptureFingerprint (int timeOut)
    {
          
        return captureManager.captureFPData(timeOut);
    }
     
     
    public String getCapturedTemplate()
    {
        return  captureManager.getCapturedTemplate();
    }
     
      
    public int compareTemplates(String capturedTemplates, String currentTemplate, int NumberOfTemplates)
    {        
        
         return  captureManager.compareTemplates(capturedTemplates,currentTemplate,NumberOfTemplates);
    }
     
    public int getNFIQ()
    {
         return captureManager.getNFIQ();
    }

     
 

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        controlsPanel = new javax.swing.JPanel();
        jLblError = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        mainPanel.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MSO1300E_large.JPG"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 190, 150);

        mainPanel.add(jPanel2);
        jPanel2.setBounds(70, 10, 190, 150);

        controlsPanel.setLayout(null);

        jLblError.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14));
        jLblError.setForeground(new java.awt.Color(255, 0, 0));
        jLblError.setFocusable(false);
        jLblError.setOpaque(true);
        jLblError.setRequestFocusEnabled(false);
        jLblError.setVerifyInputWhenFocusTarget(false);
        controlsPanel.add(jLblError);
        jLblError.setBounds(0, 30, 350, 20);

        mainPanel.add(controlsPanel);
        controlsPanel.setBounds(0, 170, 360, 50);

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 0, 370, 220);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controlsPanel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLblError;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

   
}
