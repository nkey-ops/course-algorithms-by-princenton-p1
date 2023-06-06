package merge_sort_2_2.assignment;

/**
 * @author deuru
 *
 */
public class BruteCollinearPoints {
	private static final int MIN_POINTS_ON_LINE = 4;
	private final LineSegment[] segments;

	// finds all line segments containing 4 points
	public BruteCollinearPoints(Point[] points) {
		if (points == null)
			throw new IllegalArgumentException("Points cannot be null");

		segments = points.length == 0 ? 
				new LineSegment[0] : getLineSegments(points);
	}

	// the number of line segments
	public int numberOfSegments() {
		return segments.length;
	}
	// the line segments

	public LineSegment[] segments() {
		return segments.clone();
	}	

	private LineSegment[] getLineSegments(Point[] points) {
		if (points == null)
			throw new IllegalArgumentException("Points cannot be null");

		int n = points.length;

		Point[] ls = new Point[n * (n - 1)];

		Point le = null, re = null;
		int lsc = 0;
		for (int i = 0; i < n; i++) {
			if (points[i] == null)
				throw new IllegalArgumentException("Point cannot be null");

			for (int k = i + 1 ; k < n; k++) {
				validate(points[i], points[k]);

				if(isLess(points[i], points[k])) {
					le = points[i];
					re = points[k];
				}else {
					le = points[k];
					re = points[i];
				}

				int pointsOnLine = 2;
				double slc = le.slopeTo(re);

				for (int j = k + 1; j < n; j++) {
					validate(le, points[j]);

					if (slc == le.slopeTo(points[j])) {
						// choosing point for left edge that is smaller than p1
						// and for right edge that is bigger that p2
						if (isLess(points[j], le)) 		 le = points[j];
						else if (isMore(points[j], re))	 re = points[j];
						pointsOnLine++;
					}
				}

				if (pointsOnLine >= MIN_POINTS_ON_LINE 
						&& !hasLineWithAngel(ls, lsc / 2, le, re)) {
					ls[lsc++] = le;
					ls[lsc++] = re;
				}

			}
		}

		LineSegment[] r =  new LineSegment[lsc / 2];
		for (int ri = 0, lsi = 0; ri < r.length; ri++, lsi+=2) {
			r[ri] = new LineSegment(ls[lsi], ls[lsi + 1]);  
		}

		return r;
	}

	private static void validate(Point i, Point k) {
		if(i == null || k == null || i.compareTo(k) == 0)  
			throw new IllegalArgumentException("Points cannot be the same or null");
	}

	/**
	 * Checks if there is a line with the same angle 
	 * 
	 * @param ls	line segments
	 * @param l		times to check each segment	
	 * @param degree
	 * @return
	 */
	private boolean hasLineWithAngel(Point[] ls, int l, Point p1, Point p2) {
		validate(p1, p2);
		if(ls == null || l < 0 || l * 2 > ls.length || ls.length % 2 != 0) 
			throw new IllegalArgumentException();

		for (int i = 0; i < l * 2; i+=2) {
			validate(ls[i], ls[i + 1]);

			double src = ls[i].slopeTo(ls[i + 1]);
			double dst = ls[i].slopeTo(p1);
			if (src == p1.slopeTo(p2) 
					&& (src == dst || dst == Double.NEGATIVE_INFINITY)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isMore(Point c1, Point c2) {
		if(c1 == null || c2 == null) throw new IllegalArgumentException();
		return c1.compareTo( c2) > 0;
	}

	private static boolean isLess( Point c1, Point c2) {
		if(c1 == null || c2 == null) 
			throw new IllegalArgumentException("Point cannot be null");
		return c1.compareTo(c2) < 0;
	}
}
