package pm.points.basic;

public class BasicPoint
{
	
	protected double xLoc;
	protected double yLoc;
	
	public BasicPoint() {
		
	}
	
	public BasicPoint( double xLoc, double yLoc ) {
		xLoc = xLoc;
		yLoc = yLoc;
	}
	
	public double getxLoc() {
		return xLoc;
	}
	public void setxLoc(double xLoc) {
		this.xLoc = xLoc;
	}
	public double getyLoc() {
		return yLoc;
	}
	public void setyLoc(double yLoc) {
		this.yLoc = yLoc;
	}
	
}