/**
 * 
 */
package com.nbi.childportal.common;


/**
 * @author zahmad
 *
 */
public class AppLogger {
	private String loggerName;
	
	public AppLogger(String loggerName){
		this.loggerName = loggerName;
	}
	
	public void log(String log){
		System.out.println(loggerName+": "+log);
	}

	public void logException(Exception e) {
		e.printStackTrace();
	}
	
}
