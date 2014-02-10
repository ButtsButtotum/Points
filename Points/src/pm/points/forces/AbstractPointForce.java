package pm.points.forces;

import pm.points.basic.Point;

public abstract class AbstractPointForce
{
	
	public void applyForceToFirst(Point p1, Point p2) {
		if( p1 == null || p2 == null ) {
			return;
		}
		else {
			double x1 = p1.getXLoc();
			double y1 = p1.getYLoc();
			double x2 = p2.getXLoc();
			double y2 = p2.getYLoc();
			
			double a = x2 - x1;
			double b = y2 - y1;
			
			double c = Math.sqrt(a*a + b*b);
			
			double f = forceByDistance( c, p1, p2 );
			
			double xRatio = a / ( a + b );
			double yRatio = b / ( a + b );
			
			double xForce = xRatio * f;
			double yForce = yRatio * f;

			p1.setXAccel( p1.getXAccel() + xForce );
			p1.setYAccel( p1.getYAccel() + yForce );
		}
	}
	
	protected abstract double forceByDistance( double d, Point p1, Point p2 );
	
}