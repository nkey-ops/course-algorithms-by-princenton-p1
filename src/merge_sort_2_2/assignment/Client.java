package merge_sort_2_2.assignment;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import java.util.Random;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author deuru
 *
 */
public class Client {
	private static int POINTS_CAP = 32768;
	public static void main(String[] args) {
		if(args.length == 0 )
			generateRandomValues(new Configurations());
		else if(args.length >= 2) {
			if(args[0].equals("-r")) 
				generateRandomValues(parseInt(args[1]), getConfig(args, 2));
			 else if(args[0].equals("-p")) 
				generateFromPath(args[1], getConfig(args, 2));
			 else if(args[0].equals("-s")) 
				generateSquare(parseInt(args[1]), getConfig(args, 2));

		}else 
			System.err.printf("Usage: Client <tag> <val> <conf> <val> \n"
				+ "by default generates random number of points\n"
				+ "-r [n points]     generate n random points\n"
				+ "-p [path]         generate poins from path\n"
				+ "-s [side length]  generate squre with provided side\n"
				+ "                  suggested <= side is 30, pen size is <= 0.0001\n"
				+ "Configuration:\n"
				+ "-p  [val]          sets pen radious");
		
	}
	
	private static Configurations getConfig(String[] args, int s) {
		Configurations c = new Configurations();

		for (int i = s;  i < args.length; i+= 2) {
			switch(args[i]) { 
			case "-p" -> c.setPointRadious(parseDouble(args[i + 1]));  
			}	
		}

		return c;
	}

	private static void generateRandomValues( Configurations c) {
		generateRandomValues(StdRandom.uniformInt(0, POINTS_CAP - 1), c);
	}

	private static void generateRandomValues(int nPoints, Configurations c) {
		if(nPoints < 1 && nPoints >= POINTS_CAP)
			throw new IllegalArgumentException(
					"Number of points is less than 1 or more than " + POINTS_CAP);
		Point[] points = new Point[nPoints];

		Random r =  new Random();
		label:
		for (int i = 0; i < nPoints; i++) { 
			int x = r.nextInt(0, POINTS_CAP);
			int y = r.nextInt(0, POINTS_CAP);

			Point p = new Point(x, y);
			for (int j = 0; j < i; j++) 
				if(p.compareTo(points[j]) == 0) {
					i--;
					continue label;
				}
			
			points[i] = p ;
		}
		
		System.out.println("Points Generated: " + nPoints);
		configuratePlane(c);
		drawPlaneAndPoints(points);	

	}
		private static void generateFromPath(String path, Configurations c) {
		/// read the n points from a file
			In in = new In(path);
			int n = in.readInt();
			Point[] points = new Point[n];
			for (int i = 0; i < n; i++) {
				int x = in.readInt();
				int y = in.readInt();
				points[i] = new Point(x, y);
			}

			configuratePlane(c);
			drawPlaneAndPoints(points);
		}

		private static void drawPlaneAndPoints(Point[] points) {
//			BruteCollinearPoints collinear = new BruteCollinearPoints(points);
			FastCollinearPoints collinear = new FastCollinearPoints(points);
			System.out.println("Collinear lines generated: "
									+ collinear.numberOfSegments());

			drawLines(collinear.segments());
			StdDraw.show();

			drawPoints(points);
			StdDraw.show();


		}

		private static void drawPoints(Point[] points) {
			StdDraw.setPenColor(StdDraw.RED);
			for (Point p : points) p.draw();
			System.out.println("Points Drawn: " + points.length );
		}

		private static void drawLines(LineSegment[] segments) {
			StdDraw.setPenColor(StdDraw.BLACK);
			for (LineSegment segment : segments) {
				segment.draw();
				StdOut.println(segment);
			}

			System.out.println("Lines Drawn: " + segments.length );
		}

		private static void configuratePlane(Configurations c) {
			StdDraw.enableDoubleBuffering();
			StdDraw.setPenRadius(c.getPointRadious());
			StdDraw.setXscale(0, POINTS_CAP);
			StdDraw.setYscale(0, POINTS_CAP);
		}
		
		
		/**
		 * @param s side length
		 */
		private static void generateSquare(int s, Configurations c) {
			if(s < 1 ) 
				throw new IllegalArgumentException(
						"Length of a squre side cannot be lower than 1");

			Point[] p =  new Point[s * s];

			int step = 1000 , 
					sX = POINTS_CAP / 2 - (s / 2 * step), 
					sY = POINTS_CAP / 2 - (s / 2 * step);	
			
			int cX = sX;
			for (int i = 0; i < p.length; i++, cX += step) {
				p[i] = new Point(cX, sY);
				if((i + 1) % s == 0) {
					sY+= step;
					cX = sX - step;
				}
			}	
	
			configuratePlane(c);
			drawPlaneAndPoints(p);
		}
		
		
		private static class Configurations {
			private double pointRadious = 0.01;

			public double getPointRadious() {
				return pointRadious;
			}

			public void setPointRadious(double pointRadious) {
				this.pointRadious = pointRadious;
			}

		}
}
