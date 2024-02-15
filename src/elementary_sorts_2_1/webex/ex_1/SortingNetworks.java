package elementary_sorts_2_1.webex.ex_1;

import java.util.Arrays;
import utils.Utils;

/**
 *
 *
 * <pre>
 * Sorting networks.
 *
 * Write a program Sort3.java with three if statements (and no loops) that reads in three
 * integers a, b, and c from the command line and prints them out in ascending order.
 *
 * Results:
 * [0, 0, 0] 0 0 0
 * [0, 0, 1] 0 0 1
 * [0, 1, 0] 0 0 1
 * [0, 1, 1] 0 1 1
 * [1, 0, 0] 0 0 1
 * [1, 0, 1] 0 1 1
 * [1, 1, 0] 0 1 1
 * [1, 1, 1] 1 1 1
 *
 * </pre>
 */
public class SortingNetworks {
  public static void main(String[] args) {

    for (byte[] arr : Utils.permutations(3)) {
      System.out.print(Arrays.toString(arr) + " ");
      sort(arr[0], arr[1], arr[2]);
    }
  }

  public static void sort(int a, int b, int c) {
    int tmp;
    if (a > b) {
      tmp = a;
      a = b;
      b = tmp;
    }
    if (b > c) {
      tmp = b;
      b = c;
      c = tmp;
    }
    if (a > b) {
      tmp = a;
      a = b;
      b = tmp;
    }

    System.out.printf("%s %s %s\n", a, b, c);
    assert a <= b && b <= c;
  }
}
