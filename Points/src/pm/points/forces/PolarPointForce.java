package pm.points.forces;

import pm.points.basic.Point;

public class PolarPointForce extends PointForce
{
	protected double forceByDistance(double d, Point p1, Point p2) {
		double constant = p1.getTypeCode() == p2.getTypeCode() ? -1 : 1;
		return constant / ( d * d );
	}
	
}