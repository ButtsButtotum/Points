package pm.points.forces;

import pm.points.basic.Point;

public abstract class PointForce
{
	
	public void applyForceAcceleration(Point p1, Point p2) {
		if( p1 == null || p2 == null || ( p1.getXLoc() == p2.getXLoc() && p1.getYLoc() == p2.getYLoc() ) ) {
			return;
		}
		else {
//			System.out.println( "start locations: ("+p1.getXLoc()+","+p1.getYLoc()+"):("+p2.getXLoc()+","+p2.getYLoc()+")");
			
			double xDifference = p2.getXLoc() - p1.getXLoc();
			double yDifference = p2.getYLoc() - p1.getYLoc();
			
			double xDirection = xDifference > 0 ? 1 : -1;
			double yDirection = yDifference > 0 ? 1 : -1;
			
//			System.out.println("difference: ("+xDifference+","+yDifference+")");
			
			double xDistance = Math.abs(xDifference);
			double yDistance = Math.abs(yDifference);
			
			double distance = Math.sqrt( xDifference * xDifference + yDifference * yDifference );
			
//			System.out.println("calculated distance: "+distance);
			
			double force = forceByDistance( distance, p1, p2 );
			
//			System.out.println("calculated force magnitude: "+force);
			
			double xPercentage = xDistance / ( xDistance + yDistance );
			double yPercentage = 1 - xPercentage;
			
//			System.out.println("percentages: (" + (int)(xPercentage*100) + "," + (int)(yPercentage*100) +")");
			
			double xForce = force * xPercentage * xDirection;
			double yForce = force * yPercentage * yDirection;
			
//			System.out.println("forces: (" + xForce+","+yForce+")");
			
			double xAccel = p1.getXAccel() + xForce;
			double yAccel = p1.getYAccel() + yForce;
			
			p1.setXAccel(xAccel);
			p1.setYAccel(yAccel);
		}
	}
	
//	public void applyForceAcceleration(Point p1, Point p2) {
//		if( p1 == null || p2 == null ) {
//			return;
//		}
//		else {
//			double x1 = p1.getXLoc();
//			double y1 = p1.getYLoc();
//			double x2 = p2.getXLoc();
//			double y2 = p2.getYLoc();
//			
//			double a = x2 - x1;
//			double b = y2 - y1;
//			
//			if( a + b == 0 ) {
//				return;
//			}
//			
//			double c = Math.sqrt(a*a + b*b);
//			
//			double f = forceByDistance( c, p1, p2 );
//			
//			double xRatio = a / ( Math.abs(a) + Math.abs(b) );
//			double yRatio = b / ( Math.abs(a) + Math.abs(b) );
//			
//			double xForce = xRatio * f;
//			double yForce = yRatio * f;
//
//			p1.setXAccel( p1.getXAccel() + xForce );
//			p1.setYAccel( p1.getYAccel() + yForce );
//		}
//	}
	
	protected abstract double forceByDistance( double d, Point p1, Point p2 );
	
}