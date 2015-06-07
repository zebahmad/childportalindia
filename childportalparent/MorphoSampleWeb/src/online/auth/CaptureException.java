/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.auth;

/**
 *
 * @author SCL0696
 */
public class CaptureException extends Exception {

    private int type;
    private String description;
    private Throwable cause;
    public static final int FINGERPRINT_API_DEVICE_INTERNAL_ERROR = -1;
    public static final int FINGERPRINT_API_DEVICE_LICENSE_ERROR = 1;
    public static final int FINGERPRINT_API_DEVICE_TIMEOUT_ERROR = 2;
    
    
    public static final int DEVICE_NOT_CONNECTED = 3;
    public static final int LIBRARY_MISSING = 4;
    public static final int TIMEOUT = 5;
    public static final int LICENSE_EXCEPTION = 6;
    public static final int INTERNAL_ERROR = 7;
    
    public static final int UNKNOWN_DEVICE_ERROR = 8;
    public static final int DEVICE_CONNECTION_ERROR = 9;
    public static final int FINGER_ALREADY_CAPTURED_ERROR = 9;
    public static final int ENCRYPTION_MODULE_INITIALIZATION_ERROR = 10;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private CaptureException() {
        // No one should be able to cerate an object of exception without reason and description...
    }

    public CaptureException(int type, String description) {
        this.type = type;
        this.description = description;
    }

    public CaptureException(int type, String description, Throwable cause) {
        this.type = type;
        this.description = description;
        this.cause = cause;
    }

    public String toString() {
        return description;
    }
}
