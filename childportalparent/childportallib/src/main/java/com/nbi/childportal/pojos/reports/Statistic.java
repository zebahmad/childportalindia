/**
 * 
 */
package com.nbi.childportal.pojos.reports;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author zahmad
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="statistic")
public class Statistic {
	
	private List<StatPoint> statPoints;

	public List<StatPoint> getStatPoint() {
		return statPoints;
	}
	public void setStatPoint(List<StatPoint> statPoint) {
		this.statPoints = statPoint;
	}
	public void addStatPoint(StatPoint statPoint) {
		if(this.statPoints == null){
			statPoints = new ArrayList<StatPoint>();
		}
		statPoints.add(statPoint);
	}
	
}
