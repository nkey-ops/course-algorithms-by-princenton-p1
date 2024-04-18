package merge_sort_2_2;

import elementary_sorts_2_1.webex.ex_4.OptimalObliviousSortingChallenge;
import java.util.Arrays;
import java.util.Objects;

import javax.naming.ldap.SortKey;

import utils.Utils;

/** Test */
public class Test {

  public static void main(String[] args) {
    OptimalObliviousSortingChallenge.sort(3, 7, 8, 1, 2, 5);
    // l > r
    testLeftMoreThanRight();
    // l < r
    testLeftLessThanRight();

    testZigZag();

    testRandomOdd();
    testRandomEven();
    weird();

    testRandom();
  }

  private static void testRandom() {
    int n = 4;

    int f = 1;
    for (int i = 2; i <=n; i++) {
      f *= i; 
    }

    int[][] arr = new int[f][n];
    // 1 1 1 1  
    // 1 1 1 2
    // 1 1 1 3

    for (int i = 0; i < n; i++) {
      for (int k = n - 1, j = 0; k >= 0; k--, j++) {
          arr[j][k] = j; 
      }
    }

    for (int[] is : arr) {
      System.out.println(Arrays.toString(is));
    }
  }

  public static void weird() {
    System.out.println();
    System.out.println("Weird");

    int[] arr = {3, 4, 7, 8, 1, 2, 5, 6};

    //
    // [0, 1, 1, 0, 0, 1
    //
    // 0, 0, 1, 1, 0, 0, 1, 1,
    // 0, 0, 0, 0, 1, 1, 1, 1,
    //
    // 3, 4, 7, 8, 1, 2, 5, 6
    // 1, 4, 7, 8, 3, 2, 5, 6
    // 1, 2, 7, 8, 3, 4, 5, 6
    //
    // 1, 2, 3, 8, 7, 4, 5, 6
    // 1, 2, 3, 4, 7, 8, 5, 6
    //
    //
    merge(arr, 0, 4, arr.length);

    System.out.println(Arrays.toString(arr));

    assert Utils.isSortedAsc(arr);
  }

  private static void testRandomOdd() {
    System.out.println(" ".repeat(20) + "Test Random");

    int l = 5;
    int mid = l / 2;

    for (int[] arr : Utils.permutationsInt(l)) {
      sort(arr, 0, mid);
      sort(arr, mid, arr.length);

      merge(arr, 0, mid, arr.length);
      assert Utils.isSortedAsc(arr);
      System.out.println();
      System.out.println();
    }
    ;
  }

  private static void testRandomEven() {
    System.out.println(" ".repeat(20) + "Test Random Even");

    int l = 6;
    int mid = l / 2;
    System.out.println(mid);

    for (int[] arr : Utils.permutationsInt(l)) {
      sort(arr, 0, mid);
      sort(arr, mid, arr.length);

      merge(arr, 0, mid, arr.length);
      assert Utils.isSortedAsc(arr);
      System.out.println();
      System.out.println();
    }
    ;
  }

  private static void testZigZag() {
    System.out.println(" ".repeat(20) + "Test Zig Zag");

    System.out.println("Even length");
    int[] arr = {0, 2, 4, 6, 1, 3, 5, 7};
    merge(arr, 0, 4, arr.length);
    assert Utils.isSortedAsc(arr);

    System.out.println();

    System.out.println("Odd length");
    int[] arr1 = {0, 2, 4, 6, 8, 1, 3, 5, 7};
    merge(arr1, 0, 5, arr1.length);
    assert Utils.isSortedAsc(arr1);
  }

  private static void testLeftLessThanRight() {
    System.out.println(" ".repeat(20) + "Test L < R");

    System.out.println("Even length");
    int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
    merge(arr, 0, 4, arr.length);
    assert Utils.isSortedAsc(arr);

    System.out.println();

    System.out.println("Odd length");
    int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    merge(arr2, 0, 5, arr2.length);
    assert Utils.isSortedAsc(arr2);
  }

  private static void testLeftMoreThanRight() {
    System.out.println(" ".repeat(20) + "Test L > R");
    System.out.println("Even length");
    int[] arr = {5, 6, 7, 8, 1, 2, 3, 4};
    merge(arr, 0, 4, arr.length);
    assert Utils.isSortedAsc(arr);

    System.out.println("\nOdd length");
    int[] arr2 = {5, 6, 7, 8, 9, 1, 2, 3, 4};
    merge(arr2, 0, 5, arr2.length);
    assert Utils.isSortedAsc(arr2);
  }

  public static void merge(int[] arr, int s, int mid, int e) {

    int rri = mid;
    int lri = -1;

    int li = s, ri = mid;

    for (int i = s; i < e - 1; i++) {
      if (lri != -1) li = lri;
      else li = i;

      // if (rli != -1) ri = rli;
      ri = rri;

      System.out.printf("lri %s || rri %s || li %s ri %s || i %s\n", lri, rri, li, ri, i);
      System.out.println(Arrays.toString(arr));

      // assert i == lli;
      assert lri == -1 || i <= lri;
      assert lri <= rri;

      if (i == rri) {
        break;
      } else if (rri >= e) {
        // TODO if r side exhausted and array length is even
        // probably everything is already sorted
        exch(arr, i, lri);
        lri++;
      } else if (arr[ri] < arr[li]) {
        // rri, lri
        exch(arr, i, ri);
        rri++;

        if (i == lri) {
          lri++;
        } else if (lri == -1) {
          lri = ri;
        }
      } else {
        // lri == lli continue;
        //  3 4, 7, 8 : 1 2   5, 6
        //
        //  1 2, 3, 8 : 7 4 | 5, 6
        //  1 2, 3, 4 : 7 8 | 5, 6
        //  1 2, 3, 4 9 : 7 8 | 5, 6

        if (lri != -1) {
          exch(arr, li, i);
          //if (i >= mid) lri++;
           if(rri - lri >= 2 || i >= mid) lri++;
        }
      }

      System.out.println();
    }

    System.out.println(Arrays.toString(arr));
  }

  public static void exch(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

  public static void sort(int[] arr, int s, int e) {
    Objects.requireNonNull(arr);
    if (s < 0 || s >= arr.length || e < 0 || e > arr.length || s >= e) {
      throw new IllegalArgumentException();
    }

    for (int i = s + 1; i < e; i++) {
      for (int j = i - 1; j >= s && arr[j + 1] < arr[j]; j--) {
        exch(arr, j, j + 1);
      }
    }

    assert Utils.isSortedAsc(arr, s, e - 1);
  }
}
