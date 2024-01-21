package unionfind_1_5.exp.ex_21;

import static java.lang.Math.divideExact;
import static java.lang.Math.multiplyExact;

import unionfind_1_5.cp.ex_17.RandomConnections;

/**
 *
 *
 * <pre>
 * 1.5.21 Erdös-Renyi model.
 * Use your client from Exercise 1.5.17 to test the hypothesis that the
 * number of pairs generated to get one component is ~ ½N ln N.
 *
 * Result:
 *
 * Tries  Vertecies     Actual   Expected Difference
 * 1000         16         29         32       1.10
 * 1000         32         68         80       1.18
 * 1000         64        154        192       1.25
 * 1000        128        354        448       1.27
 * 1000        256        787       1024       1.30
 * 1000        512       1753       2304       1.31
 * 1000       1024       3848       5120       1.33
 * 1000       2048       8486      11264       1.33
 * 1000       4096      18215      24576       1.35
 * 1000       8192      39207      53248       1.36
 *
 * </pre>
 */
public class ErdosRenyiModel {
  public static void main(String[] args) {
    int n = 1000;
    int numOfVertecies = 16;

    String form = "%s %10s %10s %10s";
    System.out.printf(form + " %10s\n", "Tries", "Vertecies", "Actual", "Expected", "Difference");
    while (numOfVertecies < 20_000) {
      int avgComponents = getSumOfComponents(n, numOfVertecies);

      // ~ ½N ln N.
      int expected = multiplyExact(divideExact(numOfVertecies, 2), log2(numOfVertecies));

      System.out.printf(
          form + " %10.2f\n",
          n,
          numOfVertecies,
          avgComponents,
          expected,
          (double) expected / avgComponents);
      numOfVertecies *= 2;
    }
  }

  private static int getSumOfComponents(int tries, int numOfVertecies) {
    int sumOfComponents = 0;
    for (int i = 0; i < tries; i++) {
      int con = RandomConnections.count(numOfVertecies);
      sumOfComponents = Math.addExact(con, sumOfComponents);
    }

    return divideExact(sumOfComponents, tries);
  }

  private static int log2(int n) {
    if (n == 0) return 0;
    else return 31 - Integer.numberOfLeadingZeros(n);
  }
}
