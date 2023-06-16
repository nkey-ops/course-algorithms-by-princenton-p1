package merge_sort_2_2.assignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;


/**
 * @author deuru
 * 
 *         There are two key points to get the order of growth of 
 *         the running time to be $n^2\log n$ in the worst case, 
 *         with space proportional to n plus the number of line segments returned, 
 *         and work properly even if the input has 5 or more collinear points.
 *        
 *         Stable Arrays.sort() is guaranteed to be stable, 
 *         so equal elements will not be reordered as a result of the sort. 
 *         So the input points array is already sorted by points natural 
 *         order once we sort the element at the first valid check step.
 *         
 *         To avoid duplicate line segments, we need to check if new found
 *         collinear points pairs already exist in the LineSegment. 
 *         If we loop over the LineSegment everytime we have 
 *         a new line segments to check,
 *         this will results in large run time that will not satisfy the requirement. 
 *         Instead, we need to make use of the inner features of the line patterns:
 *         
 *         Since the every possible segment is created by points it contains,
 *         	1) and we iterate through the sorted Points array to find segment
 *        	2) so every non-duplicate new segment is guaranteed 
 *             to be created from its smallest point member
 *          3) any duplicate segment is created later by its other member other
 *         	   than the smallest>
 *         
 *        Source: https://congchan.github.io/algorithms-applications-03-pattern-recognition/  
 */
public class FastCollinearPoints {
	private final LineSegment[] segments;
	private static final int MIN_POINTS_ON_LINE = 4;

	public FastCollinearPoints(Point[] points){
		requireNonNull(points);
		segments =  getLineSegments(points, MIN_POINTS_ON_LINE );
	} 

	//	the number of line segments
	public int numberOfSegments() {
		return segments.length;
	}

	// the line segments
	public LineSegment[] segments() {
		return segments.clone();
	}

	private LineSegment[] getLineSegments(Point[] points, int minPointsOnLine) {
		if(minPointsOnLine < 2) 
			throw new IllegalArgumentException(
					"MinPointsOnLine should be equal or more that 2");
		requireNonNull(points);
		
		int n = points.length;
		if(n == 0) return new LineSegment[0];

		Point[] c = points.clone();
		LinkedList<LineSegment> ls = new LinkedList<>(); 
		Point p1 = null, p2 = null;

		for (int i = 0; i < n; i++) {
			requireNonNull(points[i]);

			if(n == 1) break; 
			Point bp = points[i];

			Arrays.sort(c, comparator(bp));
			p1 = c[1];  

			requireNonEqual(bp, p1);
			
			int pointsOnLine = 2;
			double sl = bp.slopeTo(p1);

			for (int j =  2 ; j < points.length; j++) {
				double slc = bp.slopeTo(c[j]);
				if(sl == slc) {
					p2 = c[j];
					pointsOnLine++;
				} else {
					if(areCollinearPoints(minPointsOnLine, p1, bp, pointsOnLine) ) 
						ls.add(new LineSegment(bp, p2));
											
					p1 = c[j]; 
					sl = slc;
					pointsOnLine = 2;
				}
			}

			if(areCollinearPoints(minPointsOnLine, p1, bp, pointsOnLine)) 
						ls.add(new LineSegment(bp, p2));
		}

		return ls.toArray(new LineSegment[ls.size()]); 
	}

	private Comparator<? super Point> comparator(Point bp) {
		return (po1, po2) -> {
			requireNonNull(po1);
			requireNonNull(po2);
			int r =  Double.compare(bp.slopeTo(po1), bp.slopeTo(po2));
			return r != 0 ? r : po1.compareTo(po2);
		};
	}

	private boolean areCollinearPoints(int minPointsOnLine, Point p1, Point bp, int pointsOnLine) {
		return pointsOnLine >= minPointsOnLine 
				&& bp.compareTo(p1) < 0;
	}

	private void requireNonNull(Object obj) {
		if(obj == null) 
			throw new IllegalArgumentException("Parrammeter cannot be null");
	}

	private static void requireNonEqual(Point i, Point k) {
		if(i == null || k == null || i.compareTo(k) == 0)  
			throw new IllegalArgumentException(
					"Points cannot be null or the same");
	}
}