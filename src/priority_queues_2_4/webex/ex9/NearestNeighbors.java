package priority_queues_2_4.webex.ex9;

import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Nearest neighbors.
 * Given n vectors x1, x2, ..., xN of length m
 * and another vector x of the same length,
 * find the 20 vectors that are closest to x
 *
 *
 * Output:
 *  GENERATED LINES :30
 *  Line: x1 2.0, y1 9.0,    x2 6.0, y2 29.0
 *  Line: x1 -10.0, y1 -9.0,         x2 -21.0, y2 8.0
 *  Line: x1 -2.0, y1 9.0,   x2 -4.0, y2 29.0
 *  Line: x1 -5.0, y1 -3.0,  x2 -9.0, y2 17.0
 *  Line: x1 -6.0, y1 4.0,   x2 -23.0, y2 15.0
 *  Line: x1 8.0, y1 -9.0,   x2 23.0, y2 5.0
 *  Line: x1 -6.0, y1 3.0,   x2 3.0, y2 21.0
 *  Line: x1 0.0, y1 10.0,   x2 -11.0, y2 27.0
 *  Line: x1 3.0, y1 -3.0,   x2 -11.0, y2 12.0
 *  Line: x1 -8.0, y1 -1.0,  x2 -16.0, y2 18.0
 *  Line: x1 4.0, y1 3.0,    x2 3.0, y2 23.0
 *  Line: x1 8.0, y1 -5.0,   x2 21.0, y2 11.0
 *  Line: x1 8.0, y1 9.0,    x2 14.0, y2 29.0
 *  Line: x1 -4.0, y1 1.0,   x2 -15.0, y2 18.0
 *  Line: x1 -10.0, y1 -8.0,         x2 -14.0, y2 12.0
 *  Line: x1 1.0, y1 -1.0,   x2 1.0, y2 19.0
 *  Line: x1 -1.0, y1 -8.0,  x2 16.0, y2 3.0
 *  Line: x1 -3.0, y1 -7.0,  x2 10.0, y2 9.0
 *  Line: x1 -10.0, y1 9.0,  x2 -30.0, y2 9.0
 *  Line: x1 6.0, y1 5.0,    x2 10.0, y2 25.0
 *  Line: x1 1.0, y1 5.0,    x2 21.0, y2 5.0
 *  Line: x1 -2.0, y1 -2.0,  x2 -7.0, y2 18.0
 *  Line: x1 -3.0, y1 4.0,   x2 -22.0, y2 11.0
 *  Line: x1 4.0, y1 7.0,    x2 -7.0, y2 24.0
 *  Line: x1 -1.0, y1 4.0,   x2 -16.0, y2 18.0
 *  Line: x1 -2.0, y1 -7.0,  x2 14.0, y2 5.0
 *  Line: x1 -4.0, y1 -2.0,  x2 8.0, y2 14.0
 *  Line: x1 0.0, y1 6.0,    x2 -16.0, y2 18.0
 *  Line: x1 -3.0, y1 5.0,   x2 -17.0, y2 20.0
 *  Line: x1 -3.0, y1 5.0,   x2 17.0, y2 5.0
 *  NEIGHBORS LINES :20
 *  Line: x1 1.0, y1 5.0,    x2 21.0, y2 5.0
 *  Line: x1 -3.0, y1 5.0,   x2 17.0, y2 5.0
 *  Line: x1 8.0, y1 9.0,    x2 14.0, y2 29.0
 *  Line: x1 -3.0, y1 -7.0,  x2 10.0, y2 9.0
 *  Line: x1 6.0, y1 5.0,    x2 10.0, y2 25.0
 *  Line: x1 4.0, y1 3.0,    x2 3.0, y2 23.0
 *  Line: x1 4.0, y1 7.0,    x2 -7.0, y2 24.0
 *  Line: x1 -4.0, y1 -2.0,  x2 8.0, y2 14.0
 *  Line: x1 1.0, y1 -1.0,   x2 1.0, y2 19.0
 *  Line: x1 2.0, y1 9.0,    x2 6.0, y2 29.0
 *  Line: x1 0.0, y1 6.0,    x2 -16.0, y2 18.0
 *  Line: x1 -2.0, y1 -7.0,  x2 14.0, y2 5.0
 *  Line: x1 -1.0, y1 4.0,   x2 -16.0, y2 18.0
 *  Line: x1 3.0, y1 -3.0,   x2 -11.0, y2 12.0
 *  Line: x1 0.0, y1 10.0,   x2 -11.0, y2 27.0
 *  Line: x1 -1.0, y1 -8.0,  x2 16.0, y2 3.0
 *  Line: x1 8.0, y1 -5.0,   x2 21.0, y2 11.0
 *  Line: x1 -3.0, y1 5.0,   x2 -17.0, y2 20.0
 *  Line: x1 -3.0, y1 4.0,   x2 -22.0, y2 11.0
 *  Line: x1 -2.0, y1 9.0,   x2 -4.0, y2 29.0
 *  TARGET LINE
 *  Line: x1 5.0, y1 5.0,    x2 10.0, y2 10.0
 *
 *
 * Sources;
 * https://stackoverflow.com/a/2824500
 * https://paulbourke.net/geometry/pointlineplane/
 * https://paulbourke.net/geometry/pointlineplane/DistancePoint.java
 */
public class NearestNeighbors {
    public static void main(String[] args) {
        long n = args.length == 1 ? Integer.parseInt(args[0]) : 30;

        int neighbors = 20;
        int length = 20;
        double tLineAp1 = 5, tLineBp1 = 5, tLineAp2 = 10, tLineBp2 = 10;

        int yBound = 10, xBound = 10;
        double penRadius = 0.01;




        List<Line2D> vectors = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Point2D a =  new Point2D.Double(
                     StdRandom.uniformInt(-xBound, xBound + 1),
                     StdRandom.uniformInt(-yBound, yBound + 1));

           int x2 = StdRandom.uniformInt((int)a.getX() - length, (int) a.getX() + length + 1);
           Point2D b =  new Point2D.Double( x2,
                    Math.ceil(
                        Math.sqrt(length * length - Math.pow((a.getX() - x2), 2)) + a.getY()));

            vectors.add(new Line2D.Double(a,b));
        }


        StdDraw.setPenRadius(penRadius);
        StdDraw.setXscale(-xBound - length, xBound + length);
        StdDraw.setYscale(-yBound - length, yBound + length);


        Line2D targetLine = new Line2D.Double(
                new Point2D.Double(tLineAp1, tLineBp1),
                new Point2D.Double(tLineAp2, tLineBp2));

        List<Line2D>  res = getNeighbors(vectors, targetLine, neighbors);


        System.out.println("GENERATED LINES :" + n);
        draw(vectors, Color.BLACK);

        System.out.println("NEIGHBORS LINES :" + neighbors);
        draw(res, Color.GREEN);
     
        System.out.println("TARGET LINE");
        draw(List.of(targetLine), Color.MAGENTA);


    }


    public static List<Line2D> getNeighbors(List<Line2D> v, Line2D p3, int n)  {
        if(v.size() < n || v == null || p3 == null || n < 1)
            throw new IllegalArgumentException();

        MinPQ<Line2D> q = new MinPQ<>(
                (p1, p2) -> { 
                   
                   double disAp3toP1 = distanceToSegment(p1.getP1(), p1.getP2(), p3.getP1()), //Ax -> p1
                          disBp3toP1 = distanceToSegment(p1.getP1(), p1.getP2(), p3.getP2()), //Bx -> p1
                          disAp1toP3 = distanceToSegment(p3.getP1(), p3.getP2(), p1.getP1()), //Ap1 -> x
                          disBp1toP3 = distanceToSegment(p3.getP1(), p3.getP2(), p1.getP2()); //Bp1 -> x

                   double disAp3toP2 = distanceToSegment(p2.getP1(), p2.getP2(), p3.getP1()), //Ax -> p2
                          disBp3toP2 = distanceToSegment(p2.getP1(), p2.getP2(), p3.getP2()), //Bx -> p2
                          disAp2toP3 = distanceToSegment(p3.getP1(), p3.getP2(), p2.getP1()), //Ap2 -> x
                          disBp2toP3 = distanceToSegment(p3.getP1(), p3.getP2(), p2.getP2()); //Bp2 -> x
                          

                  double p1ShortestDist =  
                      Math.min(
                              Math.min(disAp3toP1, disBp3toP1), 
                              Math.min(disAp1toP3, disBp1toP3));

                  double p2ShortestDist =  
                      Math.min(
                              Math.min(disAp3toP2, disBp3toP2), 
                              Math.min(disAp2toP3, disBp2toP3));

                    return Double.compare(p1ShortestDist, p2ShortestDist);});


       v.forEach(q::insert); 


        List<Line2D> res = new ArrayList<>();
        for (int i = 0; i < n; i++) 
             res.add(q.delMin()); 
      
    
        return res;
    }


    /**
     * Wrapper function to accept the same arguments as the other examples
     * 
     * @param x3
     * @param y3
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static double distanceToSegment(double x3, double y3, double x1, double y1, double x2, double y2) {
        final Point2D p3 = new Point2D.Double(x3, y3);
        final Point2D p1 = new Point2D.Double(x1, y1);
        final Point2D p2 = new Point2D.Double(x2, y2);
        return distanceToSegment(p1, p2, p3);
    }

    /**
     * Returns the distance of p3 to the segment defined by p1,p2;
     * 
     * @param p1
     *           First point of the segment
     * @param p2
     *           Second point of the segment
     * @param p3
     *           Point to which we want to know the distance of the segment
     *           defined by p1,p2
     * @return The distance of p3 to the segment defined by p1,p2
     */
    public static double distanceToSegment(Point2D p1, Point2D p2, Point2D p3) {

        final double xDelta = p2.getX() - p1.getX();
        final double yDelta = p2.getY() - p1.getY();

        if ((xDelta == 0) && (yDelta == 0)) {
            throw new IllegalArgumentException("p1 and p2 cannot be the same point");
        }

        final double u = 
            ((p3.getX() - p1.getX()) * xDelta +  (p3.getY() - p1.getY()) * yDelta)
                / (xDelta * xDelta + yDelta * yDelta);

        final Point2D closestPoint;
        if (u < 0) {
            closestPoint = p1;
        } else if (u > 1) {
            closestPoint = p2;
        } else {
            closestPoint = new Point2D.Double(p1.getX() + u * xDelta, p1.getY() + u * yDelta);
        }

        return closestPoint.distance(p3);
    }


    private static void draw(List<Line2D> l, Color color ) {
        for (Line2D line2d : l) {

            StdDraw.setPenColor(color);
            StdDraw.line(
                    line2d.getX1(), line2d.getY1(), 
                    line2d.getX2(), line2d.getY2());


            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(line2d.getX1(), line2d.getY1());
            StdDraw.point(line2d.getX2(), line2d.getY2());


            System.out.printf("Line: x1 %s, y1 %s,\t x2 %s, y2 %s\n",
                    line2d.getX1(), line2d.getY1(),
                    line2d.getX2(), line2d.getY2());
        }
    }

}
