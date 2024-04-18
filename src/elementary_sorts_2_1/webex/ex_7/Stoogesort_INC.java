package elementary_sorts_2_1.webex.ex_7;

import java.util.Arrays;

import utils.Utils;

/**
 *
 *
 * <pre>
 * Stoogesort.
 * Analyze the running time and correctness of the following recursive sorting algorithm:
 * if the leftmost item is larger than the rightmost item, swap them.
 * If there are 2 or more items in the current subarray, (i) sort the initial two-thirds of
 * the array recursively, (ii) sort the final two-thirds of the array,
 * (iii) sort the initial two-thirds of the array again.
 * </pre>
 */
public class Stoogesort {

  public static void main(String[] args) {
    int n = 6;
    for (byte[] arr : Utils.permutations(n)) {
      var s = Arrays.toString(arr) + " ";
      sort(arr, 0, n);

      System.out.println(s + Arrays.toString(arr));
      assert Utils.isSortedAsc(arr);
    }
  }

  public static void sort(byte[] arr, int s, int e) {
    System.out.println(s + " " + e);
    if (arr[s] > arr[e - 1])
      exch(arr, s, e - 1);

    // System.out.println(Arrays.toString(arr));

    if (e - s > 2) {

      sort(arr, s, (int) Math.ceil((e - s) * 0.66));
      sort(arr, e - (int) Math.ceil((e - s) * 0.66), e);
      sort(arr, s, (int) Math.ceil((e - s) * 0.66));
    }
  }

  public static void sort(int[] arr, int s, int e) {
    System.out.println(s + " " + e);
    if (arr[s] > arr[e - 1]) {
      exch(arr, s, e - 1);
    }

    if (e - s > 2) {
      sort(arr, s, (int) ((e - s) * 0.66));
      sort(arr, e - (int) ((e - s) * 0.66), e);
      sort(arr, s, (int) ((e - s) * 0.66));
    }
  }

  private static void exch(int[] arr, int s, int i) {
    int tmp = arr[s];
    arr[s] = arr[i];
    arr[i] = tmp;
  }

  private static void exch(byte[] arr, int s, int i) {
    byte tmp = arr[s];
    arr[s] = arr[i];
    arr[i] = tmp;
  }
}
