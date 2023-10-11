package priority_queues_2_4.intquest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.MinPQ;

/**
 * Taxicab
 *
 * A taxicab number is an integer that can be expressed 
 * as the sum of two cubes of positive integers 
 * in two different ways: a^3 + b^3 = c^3 + d^3.
 *
 * For example, 1729 is the smallest taxicab number: 
 * Ta(2)= 1729	
 *   	= 1^3+12^3	
 *   	= 9^3+10^3,
 *
 * Design an algorithm to find all taxicab numbers with 
 * a, b, c, and d less than n.
 *
 *
 * Output:
 *
 * ~/algorithms/src/priority_queues_2_4/intquest$
 * java Taxicab.java 500 10
 *
 * Completion ~0.0% | Taxi Numbers: 1 | Cub Sum: 2
 * 500^3 * 2 = 250000000 | 10% = 25000000
 * 
 * Completion ~10% | Taxi Numbers: 2 | Cub Sum: 25000082
 * 500^3 * 2 = 250000000 | 10% = 25000000
 * 
 * Completion ~20% | Taxi Numbers: 2 | Cub Sum: 50000105
 * 500^3 * 2 = 250000000 | 10% = 25000000
 * 
 * Completion ~30% | Taxi Numbers: 2 | Cub Sum: 75000673
 * 500^3 * 2 = 250000000 | 10% = 25000000
 * 
 * Completion ~40% | Taxi Numbers: 3 | Cub Sum: 100001167
 * 500^3 * 2 = 250000000 | 10% = 25000000
 * 
 * Completion ~50% | Taxi Numbers: 3 | Cub Sum: 125000001
 * 500^3 * 2 = 250000000 | 10% = 25000000
 * 
 * Completion ~60% | Taxi Numbers: 3 | Cub Sum: 150006330
 * 500^3 * 2 = 250000000 | 10% = 25000000
 * 
 * Completion ~70% | Taxi Numbers: 3 | Cub Sum: 175009779
 * 500^3 * 2 = 250000000 | 10% = 25000000
 * 
 * Completion ~80% | Taxi Numbers: 3 | Cub Sum: 200001177
 * 500^3 * 2 = 250000000 | 10% = 25000000
 * 
 * Completion ~90% | Taxi Numbers: 3 | Cub Sum: 225004348
 * 500^3 * 2 = 250000000 | 10% = 25000000
 * 
 * Completion ~1.0e+02% | Taxi Numbers: 3 | Cub Sum: 250000000
 * 500^3 * 2 = 250000000 | 10% = 25000000
 * 
 * RESULT:
 * 
 * 1^3 + 1^3 = 2
 * 
 * 1^3 + 12^3 = 1729
 * 9^3 + 10^3 = 1729
 * 
 * 228^3 + 423^3 = 87539319
 * 167^3 + 436^3 = 87539319
 * 255^3 + 414^3 = 87539319
 * 
 * -------
 * End of Ouput
 *
 * All found TaxiCab numbers at present:
 *
 * Ta(1)= 1^3 + 1^3	
 *
 * Ta(2)= 1729	
 *   	= 1^3+12^3	
 *   	= 9^3+10^3,
 *
 * Ta(3) = 87539319
 *       = 167^3+436^3
 *       = 228^3+423^3
 *       = 255^3+414^3.
 *
 * Ta(4) = 6963472309248
 *       = 2421^3+19083^3
 *       = 5436^3+18948^3
 *       = 10200^3+18072^3
 *       = 13322^3+16630^3.
 *
 * Ta(5) = 48988659276962496
 *       = 38787^3+365757^3
 *       = 107839^3+362753^3
 *       = 205292^3+342952^3
 *       = 221424^3+336588^3
 *       = 231518^3+331954^3.
 *
 * Ta(6) = 24153319581254312065344
 *       = 28906206^3+582162^3
 *       = 28894803^3+3064173^3
 *       = 28657487^3+8519281^3
 *       = 27093208^3+16218068^3
 *       = 26590452^3+17492496^3
 *       = 26224366^3+18289922^3
 *
 *
 * Don't try to find Ta(5+)
 */
public class Taxicab implements Comparable<Taxicab> {
    public long i;
    public long j;
    public BigInteger sum;

    public Taxicab(long i, long j, BigInteger sum) {
        this.i = i;
        this.j = j;
        this.sum = sum;
    }

    @Override
    public int compareTo(Taxicab o) {
        return sum.compareTo(o.sum);
    }

    @Override
    public String toString() {
        return "Taxicab [i=" + i + ", j=" + j + ", sum=" + sum + "]";
    }

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usaage [v] [p]\n"
                    + "  -v Value sets search limit using formula val^3 * 2"
                    + "  -p Percentage value to determine  "
                    + "how often status will be updated");
            System.exit(0);
        }

        int n = Integer.parseInt(args[0]);
        double minCompPercent = Double.parseDouble(args[1]);

        List<List<Taxicab>> lTaxicabs = getTaxicabs(n, minCompPercent);

        System.out.println("RESULT:");

        for (List<Taxicab> taxicabs : lTaxicabs) {
            System.out.println();
            for (Taxicab taxicab : taxicabs) {

                System.out.printf("%s^3 + %s^3 = %s\n",
                        taxicab.i, taxicab.j, taxicab.sum);
            }
        }

    }

    private static List<List<Taxicab>> getTaxicabs(int n, double minCompPercent) {
        if (n < 0 || minCompPercent <= 0 || minCompPercent > 100)
            throw new IllegalArgumentException();

        BigDecimal bMinCompPercent = BigDecimal.valueOf(minCompPercent);
        System.out.println(bMinCompPercent);
        int compPercentCap = 100, compPercent = 0;

        BigDecimal maxCubSum = BigDecimal.valueOf(n)
                .pow(3)
                .multiply(BigDecimal.valueOf(2));
        BigInteger minPercent = maxCubSum
                .multiply(BigDecimal.valueOf(minCompPercent))
                .divide(BigDecimal.valueOf(compPercentCap))
                .toBigInteger();

        MinPQ<Taxicab> minPQ = new MinPQ<>(n);

        for (long i = 1; i <= n; i++) {
            BigInteger bi = BigInteger.valueOf(i).pow(3);
            minPQ.insert(
                    new Taxicab(i, i, bi.add(bi)));
        }

        List<List<Taxicab>> l = new ArrayList<>();
        List<Taxicab> data = new ArrayList<>();

        data.add(minPQ.min());
        l.add(data); // adding 1^3 + 1^3 = 2
        data = new ArrayList<>();

        Taxicab prev = new Taxicab(0, 0, BigInteger.ZERO);

        int nTaxi = 2;
        int c = 1;
        while (!minPQ.isEmpty()) {
            Taxicab curr = minPQ.delMin();

            if (curr.sum.compareTo(prev.sum) == 0) {
                if (c == 1)
                    data.add(prev);
                c++;
                if (c <= nTaxi)
                    data.add(curr);
            } else {
                if (c == nTaxi) {
                    l.add(data);
                    nTaxi++;
                    data = new ArrayList<>(nTaxi);
                } else
                    data.clear();

                c = 1;
            }

            prev = curr;

            if (Long.compare(curr.j, n) < 1) {
                minPQ.insert(
                        new Taxicab(curr.i, curr.j + 1,
                                BigInteger.valueOf((long) Math.pow(curr.i, 3))
                                        .add(
                                                BigInteger.valueOf((long) Math.pow(curr.j + 1, 3)))));
            }

            long longValue = prev.sum.divide(minPercent).longValue();
            if (longValue >= compPercent) {
                System.out.printf(
                        "Completion ~%s%% | Taxi Numbers: %s | Cub Sum: %s\n" +
                                "%s^3 * 2 = %s | %s%% = %s\n\n",

                        bMinCompPercent.multiply(BigDecimal.valueOf(longValue)),
                        l.size(), prev.sum,
                        n, maxCubSum,
                        bMinCompPercent, minPercent);

                compPercent++;
            }
        }

        return l;
    }

}
