package unionfind_1_5.exp.ex_22;

import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.QuickUnionUF;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 *
 *
 * <pre>
 * Doubling test for Erdös-Renyi model.
 *
 * Develop a performance-testing client that takes an int value
 * T from the command line and performs T trials of the following ex- periment:
 *
 * Use your client from Exercise 1.5.17 to generate random connections, using UnionFind to
 * determine connectivity as in our development client, looping until all sites are connected.
 * For each N, print the value of N, the average number of connections processed, and the ratio
 * of the running time to the previous.
 *
 * Use your program to validate the hypotheses in the text that the running times for quick-find and
 * quick-union are quadratic and weighted quick-union is near-linear.
 *
 *  Note: Time testing in Java extremely complicated and without use of specialized 
 *  libraries the results will be distorted by different factors like (Branch Prediction 
 *  which significantly effects QU (Quick Union results)) 
 *  So it's difficult or sometimes impossible to get proper results using this method.  
 *
 * Result:
 *  
 *    Sites | AVG Runtime:         QF         QU        WQU | RTP:   QF      QU     WQU
 *        2 |                   48541      16092      21115 |      1.00    1.00    1.00
 *        4 |                   15796      11950      17883 |      0.33    0.74    0.85
 *        8 |                   10814      12508      26834 |      0.68    1.05    1.50
 *       16 |                   12949      10390       9036 |      1.20    0.83    0.34
 *       32 |                   17515      15687      12296 |      1.35    1.51    1.36
 *       64 |                   23158      52811      22407 |      1.32    3.37    1.82
 *      128 |                   58192     238325      73840 |      2.51    4.51    3.30
 *      256 |                  446969     714063     480984 |      7.68    3.00    6.51
 *      512 |                  389637     581494     126947 |      0.87    0.81    0.26
 *     1024 |                 1058443    2118570     213215 |      2.72    3.64    1.68
 *     2048 |                 4146335   10359952     459645 |      3.92    4.89    2.16
 *     4096 |                15806260   46862470     993592 |      3.81    4.52    2.16
 *     8192 |                61816012  212945210    2245218 |      3.91    4.54    2.26
 *    16384 |               235709828 1513964006    5102350 |      3.81    7.11    2.27
 *
 *
 *  Here can be seen at last 4 rows that RTP(Running time to the previous test)
 *  for QF (Quick Find) and QU (Quick Union) is quadratic (when input is increased by 2 
 *  running time is increased n^4 comparing to the initial input, where 
 *  WQU (Weighted Quick Union) is linear (input increased by 2, running increased by 2 too).
 *
 * </pre>
 */
public class DoublingTestForErdosRenyiModel {

  public static void main(String[] args) {
    int trials = args.length == 1 ? Integer.parseInt(args[0]) : 100;
    int maxSites = 20_000;

    String format = "%6s | %12s %10s %10s %10s | %4s %3$4s %4$7s %5$7s\n";
    System.out.printf(format, "Sites", "AVG Runtime:", "QF", "QU", "WQU", "RTP:");

    long prevAvgRunTimeQF = 0;
    long prevAvgRunTimeQU = 0;
    long prevAvgRunTimeWQF = 0;

    for (int i = 2; i < maxSites; i *= 2) {
      long sumQfMilli = 0;
      long sumQuMilli = 0;
      long sumWquMilli = 0;

      for (int j = 0; j < trials; j++) {
        sumQfMilli = Math.addExact(sumQfMilli, testQuickFind(i));
        sumQuMilli = Math.addExact(sumQuMilli, testQuickUnion(i));
        sumWquMilli = Math.addExact(sumWquMilli, testWeightedQuickUnion(i));
      }

      long avgQfNano = Math.divideExact(sumQfMilli, trials);
      long avgQuNano = Math.divideExact(sumQuMilli, trials);
      long avgWquNano = Math.divideExact(sumWquMilli, trials);

      System.out.printf(
          "%6s | %23s %10s %10s | %9.2f %7.2f %7.2f\n",
          i,
          avgQfNano,
          avgQuNano,
          avgWquNano,
          prevAvgRunTimeQF != 0 ? (double) avgQfNano / prevAvgRunTimeQF : 1,
          prevAvgRunTimeQU != 0 ? (double) avgQuNano / prevAvgRunTimeQU : 1,
          prevAvgRunTimeWQF != 0 ? (double) avgWquNano / prevAvgRunTimeWQF : 1);

      prevAvgRunTimeQF = avgQfNano;
      prevAvgRunTimeQU = avgQuNano;
      prevAvgRunTimeWQF = avgWquNano;
    }
  }

  private static long testWeightedQuickUnion(int sites) {
    if (sites <= 0) {
      throw new IllegalArgumentException();
    }

    return testQuickUnionRandom(sites, UnionFindType.WEIGHTED_QUICK_UNION);
  }

  private static long testQuickUnion(int sites) {
    if (sites <= 0) {
      throw new IllegalArgumentException();
    }

    return testQuickUnionRandom(sites, UnionFindType.QUICK_UNION);
  }

  private static long testQuickFind(int sites) {
    if (sites <= 0) {
      throw new IllegalArgumentException();
    }

    return testQuickUnionRandom(sites, UnionFindType.QUICK_FIND);
  }

  private static long testQuickUnionRandom(int sites, UnionFindType quickFind) {
    QuickFindUF qf = null;
    QuickUnionUF qu = null;
    WeightedQuickUnionUF wqu = null;

    switch (quickFind) {
      case QUICK_FIND -> qf = new QuickFindUF(sites);
      case QUICK_UNION -> qu = new QuickUnionUF(sites);
      default -> wqu = new WeightedQuickUnionUF(sites);
    }

    long start = System.nanoTime();
    int connections = 0;
    while (connections != 1) {
      int p = StdRandom.uniformInt(sites);
      int q = StdRandom.uniformInt(sites);

      switch (quickFind) {
        case QUICK_FIND -> {
          if (qf.find(p) != qf.find(q)) {
            qf.union(p, q);
          }
          connections = qf.count();
        }
        case QUICK_UNION -> {
          if (qu.find(p) != qu.find(q)) {
            qu.union(q, p);
          }
          connections = qu.count();
        }
        default -> {
          if (wqu.find(p) != wqu.find(q)) {
            wqu.union(q, p);
          }
          connections = wqu.count();
        }
      }
    }

    return System.nanoTime() - start;
  }

  private static enum UnionFindType {
    QUICK_FIND,
    QUICK_UNION,
    WEIGHTED_QUICK_UNION;
  }
}
