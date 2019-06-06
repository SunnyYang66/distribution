package org.mfoyou.agent.utils.common;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.List;

public class PolygonArea {
	
	private List<Point2D.Double>  listPoint ;
	
	private Integer pointCount;

	public List<Point2D.Double> getListPoint() {
		return listPoint;
	}

	public void setListPoint(List<Point2D.Double> listPoint) {
		this.listPoint = listPoint;
	}

	public Integer getPointCount() {
		return pointCount;
	}

	public void setPointCount(Integer pointCount) {
		this.pointCount = pointCount;
	}
	
	public Polygon makePolygon(int mul){
		Polygon polygon = new Polygon();
		if(listPoint == null)return polygon;
		for(Point2D.Double pt:listPoint){
			polygon.addPoint((int)(pt.x*mul), (int)(pt.y*mul));
		}
		return polygon;
	}

   

}
