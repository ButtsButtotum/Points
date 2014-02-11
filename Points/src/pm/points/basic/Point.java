package pm.points.basic;

import java.sql.PseudoColumnUsage;

import pm.points.global.PointConstants;
import pm.points.global.PointRelationships;

public class Point
{
	// add mass later
	protected String theIdentifier;
	protected int theTypeCode;
	protected double theXLoc;
	protected double theYLoc;
	protected double theXSpeed;
	protected double theYSpeed;
	protected double theXAccel;
	protected double theYAccel;
	
	public int getTypeCode() {
		return theTypeCode;
	}
	public void setIdentifier(String identifier) {
		theIdentifier = identifier;
	}
	public String getIdentifier() {
		return theIdentifier;
	}
	public void setTypeCode(int typeCode) {
		theTypeCode = typeCode;
	}
	public double getXLoc() {
		return theXLoc;
	}
	public void setXLoc(double xLoc) {
		theXLoc = xLoc;
	}
	public double getYLoc() {
		return theYLoc;
	}
	public void setYLoc(double yLoc) {
		theYLoc = yLoc;
	}
	public double getXSpeed() {
		return theXSpeed;
	}
	public void setXSpeed(double xSpeed) {
		theXSpeed = xSpeed;
	}
	public double getYSpeed() {
		return theYSpeed;
	}
	public void setYSpeed(double ySpeed) {
		theYSpeed = ySpeed;
	}
	public double getXAccel() {
		return theXAccel;
	}
	public void setXAccel(double xAccel) {
		theXAccel = xAccel;
	}
	public double getYAccel() {
		return theYAccel;
	}
	public void setYAccel(double yAccel) {
		theYAccel = yAccel;
	}
	
	public void clearAccel() {
		theYAccel = 0;
		theXAccel = 0;
	}
	
	public String toString() {
		return theIdentifier+" ("+theTypeCode+"): ("+theXLoc+","+theYLoc+")("+theXSpeed+","+theYSpeed+")("+theXAccel+","+theYAccel+")";
	}
	
	public double getDistance(Point p2) {
		if( p2 == null || p2 == this ) {
			return PointConstants.ERROR_CODE;
		}
		else if( p2.getXLoc() == theXLoc && p2.getYLoc() == theYLoc ) {
			return 0;
		}
		else {
			double x = ( theXLoc - p2.getXLoc() );
			x = x * x;
			double y = ( theYLoc - p2.getYLoc() );
			y = y * y;
			return Math.sqrt( x + y );
		}
	}
	
//	public double getRelationshipTo( Point p2 ) {
//		if( p2 == null ) {
//			return PointConstants.ERROR_CODE;
//		}
//		
//		return PointRelationships.getRelationship(theTypeCode, p2.getTypeCode());
//	}
}