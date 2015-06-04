/**
 * 
 */
package com.nbi.childportal.pojos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author zahmad
 *
 */

@XmlRootElement(name="status")
public class StatusResponse {

	private boolean isSuccess=false;
	private String error=null;
	
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
}
