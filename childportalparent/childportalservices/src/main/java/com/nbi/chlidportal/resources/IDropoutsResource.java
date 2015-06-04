/**
 * 
 */
package com.nbi.chlidportal.resources;

import java.util.ArrayList;
import java.util.Map;

import com.nbi.childportal.pojos.reports.GroupingFilter;
import com.nbi.childportal.pojos.reports.StatType;

/**
 * @author zahmad
 *
 */
public interface IDropoutsResource {
	
	public Map<String, Long> getDropoutStats(GroupingFilter groupingFilter, StatType statType);
	public ArrayList<String> getDropoutList(GroupingFilter groupingFilter, String schoolingYear);

}
