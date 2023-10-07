package priority_queues_2_4.webex.ex3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;

import edu.princeton.cs.algs4.MinPQ;
/**
 * Taxicab numbers. 
 * Find the smallest integers that can be expressed as the sum of cubes of 
 * integers in 
 *
 * two different ways (1,729), 
 * three different ways (87,539,319), 
 * four different ways (6,963,472,309,248), 
 * five different ways (48,988,659,276,962,496), 
 * and six different ways (24,153,319,581,254,312,065,344). 
 *
 * Such integers are named Taxicab numbers after the famous Ramanujan story. 
 * The smallest integers that can be expressed as the sum of cubes of integers 
 * in seven different ways is currently unknown. 
 *
 * Write a program Taxicab.java that reads in a command 
 * line parameter N and prints out all nontrivial solutions 
 * of a3 + b3 = c3 + d3. such that a, b, c,
 *
 *
 *   java TaxicabNumbers.java 12
 *   RESULT:
 *   
 *   1^3 + 12^3 = 1729
 *   9^3 + 10^3 = 1729
 *
 */
public class TaxicabNumbers {

    public static void main(String[] args) {
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;

        Comparator<BigInteger[]> c = (a, b) -> {
            if(a[2].compareTo(b[2]) < 0 ) return -1;
            else if(a[2].compareTo(b[2]) > 0 ) return +1;
            else if(a[0].compareTo(b[0]) < 0 ) return -1;
            else if(a[0].compareTo(b[0]) > 0 ) return +1;
            else return 0;
        };

        MinPQ<BigInteger[]> m1 = new MinPQ<>(n * n, c);

        for (long i = 1; i <= n; i++) {
            BigInteger bi = BigInteger.valueOf(i);
            m1.insert(
                    new BigInteger[] {
                            bi, bi,
                            bi.pow(3).multiply(BigInteger.valueOf(2))
                    });

        }

        ArrayList<ArrayList<BigInteger[]>> l = new ArrayList<>();
        ArrayList<BigInteger[]> data = new ArrayList<>();

        BigInteger[] prev = { BigInteger.ZERO,
                BigInteger.ZERO, BigInteger.ZERO };
        BigInteger bn = BigInteger.valueOf(n);

        
        boolean isFirst = true;
        while (!m1.isEmpty()) {
            BigInteger[] num = m1.delMin();

            if (num[2].compareTo(prev[2]) == 0) {
                if (isFirst) data.add(prev); 

                isFirst = false;
                data.add(num);
            }else {
                isFirst = true;

                 if(!data.isEmpty()) {
                      l.add(data);
                      data = new ArrayList<>();
                }
            }

            prev = num;

            if (num[1].compareTo(bn) < 1) {
                BigInteger j = num[1].add(BigInteger.ONE);
                m1.insert(new BigInteger[] {
                        num[0], j,
                        num[0].pow(3).add(j.pow(3)) });
            } 
        }

        System.out.println("RESULT:");

        for (ArrayList<BigInteger[]> taxicabs : l) {
            System.out.println();
            for (BigInteger[] taxicab : taxicabs) {

                System.out.printf("%s^3 + %s^3 = %s\n", 
                        taxicab[0], taxicab[1], taxicab[2] );
            }
        }

    }

}
