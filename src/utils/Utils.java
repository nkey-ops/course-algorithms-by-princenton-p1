package utils;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Objects;

public class Utils {

  public static <T> boolean isSortedAsc(Comparable<T>[] arr) {
    for (int i = 1; i < arr.length; i++) if (less(arr[i], arr[i - 1])) return false;

    return true;
  }

  public static <T> boolean isSortedAsc(Comparable<T>[] arr, int lo, int hi) {
    if (lo < 0 || hi >= arr.length || lo > hi) throw new IllegalArgumentException();

    for (int i = lo + 1; i <= hi; i++) if (less(arr[i], arr[i - 1])) return false;

    return true;
  }

  public static <T> boolean isSortedAsc(int[] arr) {
    return isSortedAsc(arr, 0, arr.length - 1);
  }

  public static <T> boolean isSortedAsc(byte[] arr) {
    return isSortedAsc(arr, 0, arr.length - 1);
  }

  public static <T> boolean isSortedAsc(int[] arr, int lo, int hi) {
    if (lo < 0 || hi >= arr.length || lo > hi) throw new IllegalArgumentException();

    for (int i = lo + 1; i <= hi; i++) {
      if (arr[i - 1] > arr[i]) return false;
    }

    return true;
  }

  public static <T> boolean isSortedAsc(byte[] arr, int lo, int hi) {
    if (lo < 0 || hi >= arr.length || lo > hi) throw new IllegalArgumentException();

    for (int i = lo + 1; i <= hi; i++) {
      if (arr[i - 1] > arr[i]) return false;
    }

    return true;
  }

  @SuppressWarnings("unchecked")
  public static <T> boolean less(Comparable<T> v, Comparable<T> w) {
    return v.compareTo((T) w) < 0;
  }

  public static Integer[] permutation(int i) {
    int[] p = StdRandom.permutation(i, i);

    return Arrays.stream(p).boxed().toArray(Integer[]::new);
  }

  public static Integer[] permutation(int i, int k) {
    int[] p = StdRandom.permutation(i, k);

    return Arrays.stream(p).boxed().toArray(Integer[]::new);
  }

  /**
   * Returns matrix of all the permutations of zeros and ones in array of length {@code n}.
   *
   * <p>The returned matrix will be of the size equals to {@code Math#pow(2, n)}
   *
   * @param l length of the arrays
   * @return a matrix of all the permutations of zeros and ones in array of length {@code n}
   */
  public static byte[][] permutations(int l) {
    if (l < 1) {
      throw new IllegalArgumentException("Length cannot be below 1");
    }

    int length = (int) Math.pow(2, l);
    byte[][] r = new byte[length][l];

    permutations(r, 0, length, 0);
    return r;
  }

  /**
   * Returns matrix of all the permutations of zeros and ones in array of length {@code n}.
   *
   * <p>The returned matrix will be of the size equals to {@code Math#pow(2, n)}
   *
   * @param l length of the arrays
   * @return a matrix of all the permutations of zeros and ones in array of length {@code n}
   */
  public static int[][] permutationsInt(int l) {
    if (l < 1) {
      throw new IllegalArgumentException("Length cannot be below 1");
    }

    int length = (int) Math.pow(2, l);
    int[][] r = new int[length][l];

    permutations(r, 0, length, 0);
    return r;
  }

  private static void permutations(byte[][] arr, int s, int e, int i) {
    Objects.requireNonNull(arr);

    if (s < 0 || e < 0 || i < 0 || s >= arr.length || e > arr.length || i > arr[0].length) {
      throw new IllegalArgumentException(
          String.format("One the values is improper s: %s e: %s i: %s", s, e, i));
    }

    int mid = s + (e - s) / 2;
    if (mid == s) {
      return;
    }

    arr[mid] = Arrays.copyOf(arr[s], arr[0].length);

    arr[s][i] = 0;
    arr[mid][i] = 1;

    permutations(arr, mid, e, i + 1);
    permutations(arr, s, mid, i + 1);
  }

  private static void permutations(int[][] arr, int s, int e, int i) {
    Objects.requireNonNull(arr);

    if (s < 0 || e < 0 || i < 0 || s >= arr.length || e > arr.length || i > arr[0].length) {
      throw new IllegalArgumentException(
          String.format("One the values is improper s: %s e: %s i: %s", s, e, i));
    }

    int mid = s + (e - s) / 2;
    if (mid == s) {
      return;
    }

    arr[mid] = Arrays.copyOf(arr[s], arr[0].length);

    arr[s][i] = 0;
    arr[mid][i] = 1;

    permutations(arr, mid, e, i + 1);
    permutations(arr, s, mid, i + 1);
  }

  /**
   * Draw the matrix returned by {@link #permutations(int)} replacing zeros with ▢ and ones with ■ .
   *
   * @param n length of the array of permutations
   */
  public static void printPermutations(int n) {

    for (byte[] bs : permutations(n)) {
      System.out.println(Arrays.toString(bs).replace("1", "■ ").replace("0", "▢ "));
    }
  }

  public static void main(String[] args) {
    byte[][] arr = permutations(8);
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        assert !Arrays.equals(arr[i], arr[j]);
      }
    }
  }
}
