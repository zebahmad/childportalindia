/**
 * 
 */
package com.nbi.chlidportal.resources;

import java.util.List;

import com.nbi.childportal.pojos.User;
import com.nbi.childportal.pojos.reports.StatType;
import com.nbi.childportal.pojos.reports.Statistic;

/**
 * @author zahmad
 *
 */
public interface IDropoutsResource {
	
	public Statistic getNationWideDropoutStats(StatType statType) throws Exception;
	public Statistic getStateDropoutStats(String state, StatType statType) throws Exception;
	public Statistic getDistrictDropoutStats(String state, String district, StatType statType) throws Exception;
	
	public List<User> getStateDropoutList(String state, String schoolingYear) throws Exception;
	public List<User> getDistrictDropoutList(String state, String district, String schoolingYear) throws Exception;

}
