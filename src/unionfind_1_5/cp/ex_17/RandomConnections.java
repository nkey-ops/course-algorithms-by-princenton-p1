package unionfind_1_5.cp.ex_17;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.UF;

/**
 * 1.5.17 Random connections.
 * Develop a UF client ErdosRenyi that takes an integer value N from the
 * command line, generates random pairs of integers between 0 and N-1, calling connected() to
 * determine if they are connected and then union() if not (as in our development client), looping
 * until all sites are connected, and printing the number of connections generated. Package your
 * program as a static method count() that takes N as argument and returns the number of connections
 * and a main() that takes N from the command line, calls count(), and prints the returned value.
 */
public class RandomConnections {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.printf("Usage [n] where n - [0, n)");
      System.exit(1);
    }

    int n = Integer.parseInt(args[0]);

    System.out.println(count(n));
  }

  public static int count(int n) {
    UF uf = new UF(n);
    int con = 0;

    while (uf.count() != 1) {
      int n1 = StdRandom.uniformInt(n);
      int n2 = StdRandom.uniformInt(n);

      con++;
      if (uf.find(n1) == uf.find(n2)) continue;

      uf.union(n1, n2);
    }

    return con;
  }
}
