package pm.points.forces;

import pm.points.basic.Point;

public class PolarPointForce extends AbstractPointForce
{
	protected double forceByDistance(double d, Point p1, Point p2) {
		int constant = p1.getTypeCode() == p2.getTypeCode() ? -1 : 1;
		return constant / ( d * d );
	}
	
}