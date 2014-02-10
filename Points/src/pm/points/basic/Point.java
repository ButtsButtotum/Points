package pm.points.basic;

import pm.points.global.PointConstants;
import pm.points.global.PointRelationships;

public class Point
{
	// add mass later
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
	
//	public double getRelationshipTo( Point p2 ) {
//		if( p2 == null ) {
//			return PointConstants.ERROR_CODE;
//		}
//		
//		return PointRelationships.getRelationship(theTypeCode, p2.getTypeCode());
//	}
}