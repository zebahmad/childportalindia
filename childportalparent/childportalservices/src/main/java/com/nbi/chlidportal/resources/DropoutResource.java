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
public class DropoutResource implements IDropoutsResource {

	public Map<String, Long> getDropoutStats(GroupingFilter groupingFilter,StatType statType) {
		
		return null;
	}

	public ArrayList<String> getDropoutList(GroupingFilter groupingFilter, String schoolingYear) {
		return null;
	}

}
