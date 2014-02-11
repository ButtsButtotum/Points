package pm.points.forces;

import pm.points.basic.Point;

public class PersonalSpacePointForce extends PointForce
{	
	protected double forceByDistance( double d, Point p1, Point p2 ) {
		return -1.0 / ( d * d * d );
	}
}