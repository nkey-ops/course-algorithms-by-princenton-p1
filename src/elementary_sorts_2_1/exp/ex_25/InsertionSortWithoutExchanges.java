package elementary_sorts_2_1.exp.ex_25;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 *
 *
 * <pre>
 * Insertion sort without exchanges.
 * Develop an implementation of insertion sort that moves larger elements to the right one
 * position with one array access per entry, rather than using exch().
 * Use SortCompare to evaluate the effectiveness of doing so.
 *
 *
 * Comparisons:  Ώ(n - 1)  Θ(n ^ 2 / 4)        O(n ^ 2 / 2)
 * Exchanges:    Ώ(0)      Θ(n ^ 2 / 4)        O(n ^ 2 / 2)
 * Old Accesses: Ώ(n - 1)  Θ((n ^ 2 / 4) * 2)  O((n ^ 2 / 2) * 2)
 * New Accesses: Ώ(n - 1)  Θ((n ^ 2 / 4) + 1)  O((n ^ 2 / 2) + 1)
 *
 * :java SortCompare.java ins-no-exch Insertion 1000 1000
 *
 *    ins-no-exch: 6.55900
 *    Insertion: 7.82900
 *    For 1000 random Doubles
 *    ins-no-exch is 1.19363 times faster than Insertion
 *
 * </pre>
 */
public class InsertionSortWithoutExchanges {

  public static void main(String[] args) {
    int n = 10;

    int[] arr = StdRandom.permutation(n);
    System.out.println(Arrays.toString(arr));
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int t = arr[i];
      int j = i - 1;

      for (j = i - 1; j >= 0 && t < arr[j]; j--) {
        arr[j + 1] = arr[j];
      }

      arr[j + 1] = t;
    }
  }

  public static <T extends Comparable<T>> void sort(T[] arr) {
    for (int i = 1; i < arr.length; i++) {
      T t = arr[i];
      int j = i - 1;

      for (j = i - 1; j >= 0 && t.compareTo(arr[j]) < 0; j--) {
        arr[j + 1] = arr[j];
      }

      arr[j + 1] = t;
    }
  }
}
