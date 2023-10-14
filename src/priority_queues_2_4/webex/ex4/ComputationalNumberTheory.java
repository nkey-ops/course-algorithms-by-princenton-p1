package priority_queues_2_4.webex.ex4;

import java.util.ArrayList;
import java.util.List;

/**
 * Computational number theory.
 * Find all solutions to the equation a + 2b^2 = 3c^3 + 4d^4
 * for which a, b, c, and d are less than 100,000.
 *
 * Hint: use one min heap and one max heap.
 *
 *
 * Output:
 *
 * 5 + 2 * 1^2 = 3 * 1^3 + 4 * 1^4 = 7
 * 26 + 2 * 1^2 = 3 * 2^3 + 4 * 1^4 = 28
 * 20 + 2 * 2^2 = 3 * 2^3 + 4 * 1^4 = 28
 * 10 + 2 * 3^2 = 3 * 2^3 + 4 * 1^4 = 28
 * 65 + 2 * 1^2 = 3 * 1^3 + 4 * 2^4 = 67
 * 59 + 2 * 2^2 = 3 * 1^3 + 4 * 2^4 = 67
 * ...
 * 80796 + 2 * 99996^2 = 3 * 1882^3 + 4 * 21^4 = 19998480828
 * 22250 + 2 * 99997^2 = 3 * 1882^3 + 4 * 23^4 = 19998822268
 * 92611 + 2 * 99997^2 = 3 * 1155^3 + 4 * 249^4 = 19998892629
 * 59117 + 2 * 99998^2 = 3 * 1655^3 + 4 * 200^4 = 19999259125
 * 65396 + 2 * 99998^2 = 3 * 1882^3 + 4 * 25^4 = 19999265404
 * 87558 + 2 * 99999^2 = 3 * 1718^3 + 4 * 186^4 = 19999687560
 * Number of results: 555229
 * for n = 100000
 */
public class ComputationalNumberTheory {

    public static void main(String[] args) {
        long n = args.length == 1 ? Integer.parseInt(args[0]) : 100_000;
        List<Long[]> res = calc(n);

        assert test(res);

        res.sort((v1, v2) ->  Long.compare(v1[4], v2[4]));


        res.forEach(v -> 
                System.out.printf(
                 "%s + 2 * %s^2 = \t3 * %s^3 + 4 * %s^4 = \t%s\n",
                 v[0],v[1],v[2],v[3],v[4]));

        System.out.printf("Number of results: %s\n"
                         + "for n = %s\n",
                           res.size(), n );
    }

    private static List<Long[]> calc(long n) {
        List<Long[]> res = new ArrayList<>();
        
        // a + 2b^2 = 3c^3 + 4d^4
        long b = 1, c = 1, d = 1;
        long leftMax = n + 2 * (n * n);
        long rightRes = rightSum(c, d);

        while (d <= n && rightRes <= leftMax) {
            while (c <= n && rightRes <= leftMax) {

                while (b <= n) {
                    long bRes = 2 * b * b;
                    if (bRes >= rightRes)
                        break;

                    long aRes = rightRes - bRes;
                    if(aRes <= n)
                        res.add(new Long[] { aRes, b, c, d, rightRes });
                    b++;
                }

                b = 1;
                c++;
                rightRes = rightSum(c, d);
            }

            c = 1;
            d++;
            rightRes = rightSum(c, d);
        }
        return res;
    }

    private static long rightSum(long c, long d) {
        return 3 * (long) Math.pow(c, 3) + 4 * (long) Math.pow(d, 4);
    }


    private static boolean test(List<Long[]> results) {
       for (Long[] result : results) {
            long leftSum =  result[0] + 2 *(long) Math.pow(result[1], 2); 
            long rightSum = rightSum(result[2], result[3]);
            
            if(leftSum != rightSum || leftSum != result[4])
                return false;

       }     
            
       return true;
    }
}
