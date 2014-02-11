package pm.points.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;

import pm.points.basic.Point;
import pm.points.forces.PersonalSpacePointForce;
import pm.points.forces.PointForce;
import pm.points.forces.PolarPointForce;
import pm.points.utility.ParseUtility;

public class BasicTest
{
	// not multithread-friendly
	
	private static Set<Point>					thePoints;
	private static Set<PointForce>		theActiveForces;
	
	private void clearAccelerations() {
		for( Point p : thePoints ) {
			p.setXAccel(0.0);
			p.setYAccel(0.0);
		}
	}
	
	private void calculateAccelerations() {
		for( Point p1 : thePoints ) {
			for( Point p2 : thePoints ) {
				if( p1 != p2 ) {
					for( PointForce f : theActiveForces ) {
						f.applyForceAcceleration(p1,p2);
					}
				}
			}
		}
	}
	
	private void accelerationToSpeed(double timeIncrement) {
		for( Point p : thePoints ) {
			double speedX = p.getXSpeed();
			double speedY = p.getYSpeed();
			
			speedX += timeIncrement * p.getXAccel();
			speedY += timeIncrement * p.getYAccel();

			p.setXSpeed(speedX);
			p.setYSpeed(speedY);
		}
	}
	
	private void speedToLocation(double timeIncrement) {
		for( Point p : thePoints ) {
			double locX = p.getXLoc();
			double locY = p.getYLoc();
			
			locX += timeIncrement * p.getXSpeed();
			locY += timeIncrement * p.getYSpeed();
			
			p.setXLoc(locX);
			p.setYLoc(locY);
		}
	}
	
	private void iterate(double timeIncrement, int increments ) {
		if( increments > 0 ) {
			for( int i = 0; i < increments; i++ ) {
				iterate(timeIncrement);
			}
		}
	}
	
	private void iterate(double timeIncrement) {
		clearAccelerations();
		calculateAccelerations();
		accelerationToSpeed(timeIncrement);
		speedToLocation(timeIncrement);
	}
	
	private void clean()
	{
		thePoints = new HashSet<Point>();
		theActiveForces = new HashSet<PointForce>();
	}
	
	private void init(String filePath) throws IOException
	{
		File			f		= null;
		BufferedReader	br		= null;
		String			line	= null;
		
		try
		{
			f	=	new File(filePath);
			br	=	new BufferedReader(new FileReader(f));
		
			
			while(( ( line = br.readLine() ) != null ))
			{
				String[] inputs = line.split("\t");
				if( inputs != null && inputs.length >= 4 )
				{
					// intentionally being unsafe to stop everything and alert if file is garbage
					Point p = new Point();
					String id = ParseUtility.isEmpty(inputs[0]) ? java.util.UUID.randomUUID().toString() : inputs[0];
					if( !id.startsWith("/")) {
						p.setIdentifier(id);
						p.setTypeCode(Integer.parseInt(inputs[1]));
						p.setXLoc(Double.parseDouble(inputs[2]));
						p.setYLoc(Double.parseDouble(inputs[3]));
						thePoints.add(p);
					}
				}
			}
		} catch( Throwable t ) {
			if( br != null ) {
				br.close();
				throw t;
			}
		}
	}
	
	private void write(String s) {
		System.out.println(s);
	}
	
	private void printStatus(boolean showForces)
	{
		write("points");
		for( Point p : thePoints ) {
			write(p.toString());
		}
		
		if( showForces ) {
			write("forces");
			for( PointForce f : theActiveForces ) {
				write( f.getClass().getName() );
			}
		}
	}
	
	public static void main(String[] args) throws Throwable {
		System.out.println("Testing has begun.");
		
		String filePath = "C:/temp/point/Book1.txt";
		double timeIncrement = 1.0;
		BasicTest test = new BasicTest();
		
		test.clean();
		test.init(filePath);
		theActiveForces.add(new PersonalSpacePointForce());
		theActiveForces.add(new PolarPointForce());
		test.printStatus(true);
		
//		for( int i = 0; i < 10; i++ ) {
//			test.iterate(0.1, 1);
//			test.printStatus(false);
//		}
		
		test.iterate(0.1, 90);
		test.printStatus(true);
		
		
		System.out.println("Testing is complete.");
	}
	
}