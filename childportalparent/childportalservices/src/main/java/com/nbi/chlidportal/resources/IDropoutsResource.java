/**
 * 
 */
package com.nbi.chlidportal.resources;

import java.util.List;
import java.util.Map;

import com.nbi.childportal.pojos.User;
import com.nbi.childportal.pojos.reports.GroupingFilter;
import com.nbi.childportal.pojos.reports.StatType;
import com.nbi.childportal.pojos.reports.Statistic;

/**
 * @author zahmad
 *
 */
public interface IDropoutsResource {
	
	public Map<String, Statistic> getDropoutStats(GroupingFilter groupingFilter, StatType statType)throws Exception;
	public List<User> getStateDropoutList(String state, String schoolingYear) throws Exception;
	public List<User> getDistrictDropoutList(String district, String schoolingYear) throws Exception;

}
