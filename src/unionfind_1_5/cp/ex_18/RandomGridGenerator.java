package unionfind_1_5.cp.ex_18;

import bags_queues_and_stacks_1_3.cp.ex_35.RandomBag;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 *
Added: Union Find 1.5 | Create Problems | 18 Random Grid Generator
 * <pre>
 * 1.5.18 Random grid generator.
 * Write a program RandomGrid that takes an int value N from the command line,
 * generates all the connections in an N-by-N grid, puts them in random order,
 * randomly orients them (so that p q and q p are equally likely to occur), and prints the result
 * to standard output.
 * To randomly order the connections, use a RandomBag (see Exercise 1.3.34 on page 167).
 * To encapsulate p and q in a single object, use the Connection nested class shown below.
 * Package your program as two static methods: generate(), which takes N as argument and
 * returns an array of connections, and main(), which takes N from the command line,
 * calls generate(), and iterates through the returned array to print the connections.
 *
 *
 * Result:
 *
 *    10 X 10
 *    ↓ → ↓ ← → ↓ ↓ ↓ → ↓
 *    → → ↓ → ↓ ← ↓ ↓ ↓ ←
 *    ↑ ← → ↓ ← → ↓ ← ↓ ←
 *    ↑ ↓ ↑ ↓ → ↓ ↓ → → ↓
 *    ↓ → ↑ → ↓ ↓ ↓ ↓ → ↓
 *    → → → ↑ → ↓ → ↓ ← ←
 *    ↑ ↓ → → ↑ ↓ → ↓ ← ←
 *    ↑ ← → → ↑ ↓ ↓ ← → ↑
 *    → → → ↓ ← → → ↓ ← ↑
 *    ↑ → ↑ → → → → → → ▣
 *
 * </pre>
 */
public class RandomGridGenerator {
  private static class Connection {
    int p;
    int q;

    public Connection(int p, int q) {
      this.p = p;
      this.q = q;
    }
  }

  /*
   *
   * N * N  * 4 log n
   */

  public static Iterable<Connection> generate(int side) {
    RandomBag<Connection> rb = new RandomBag<>();

    if (side <= 0) throw new IllegalArgumentException("Side length cannot be below zero.");

    int size = side * side;

    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(size);

    int[] xy = new int[4];
    for (int i = 0; i < size - 1; i++) {

      int j = 0;

      int conIdent = uf.find(i);

      if (i > side && conIdent != uf.find(i - side)) xy[j++] = i - side;
      if (i < size - side) xy[j++] = i + side;
      if (i != 0 && i % side != 0 && conIdent != uf.find(i - 1)) xy[j++] = i - 1;
      if (i == 0 || (i + 1) % side != 0) xy[j++] = i + 1;

      assert j != 0;

      Connection item = new Connection(i, xy[StdRandom.uniformInt(0, j)]);
      uf.union(conIdent, item.q);
      rb.add(item);
    }

    rb.add(new Connection(size - 1, size - 1));
    return rb;
  }

  public static String toString(Iterable<Connection> connections, int side) {
    String[] arr = new String[side * side];

    if (side <= 0) throw new IllegalArgumentException("Side length cannot be below zero.");

    int size = 0;
    int desiredSize = side * side;
    for (Connection con : connections) {
      Objects.requireNonNull(con);

      if (size > desiredSize)
        throw new IllegalArgumentException(
            "Number of connections is more than side * side =  " + desiredSize);

      int d = con.q - con.p;

      String v;
      if (d == 1) v = "→ ";
      else if (d == -1) v = "← ";
      else if (d == side) v = "↓ ";
      else if (d == -side) v = "↑ ";
      else if (d == 0) v = "▣ ";
      else throw new IllegalArgumentException();

      if ((con.p + 1) % side == 0) v += System.lineSeparator();

      arr[con.p] = v;
      size++;
    }

    StringBuilder sb = new StringBuilder();
    Arrays.stream(arr).forEach(sb::append);

    return sb.append(System.lineSeparator()).toString();
  }

  public static void main(String[] args) {
    int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;

    Iterable<Connection> iterable = RandomGridGenerator.generate(n);

    System.out.printf("%s X %s\n", n, n);
    System.out.print(toString(iterable, n));
  }
}
