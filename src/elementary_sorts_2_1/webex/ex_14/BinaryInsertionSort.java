package elementary_sorts_2_1.webex.ex_14;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Binary insertion sort.
 * Develop an implementation BinaryInsertion.java of
 * insertion sort that uses binary search to find the insertion point j for
 * entry a[i] and
 * then shifts all of the entries a[j] to a[i-1] over one position to the right.
 *
 * The number of compares to sort an array of length n
 * should be ~ n lg n in the worst case.
 *
 * Note that the number of array accesses will still be quadratic
 * in the worst case.
 *
 * Use SortCompare.java to evaluate the effectiveness of doing so.
 */
public class BinaryInsertionSort {

    public static void main(String[] arr) {

        int[] a = StdRandom.permutation(100);
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int v = arr[i];
            int j = binarySearch(v, arr, 0, i);

            assert arr[j] >= arr[i];

            for (int j2 = i; j2 > j; j2--)
                arr[j2] = arr[j2 - 1];

            arr[j] = v;

        }

    }

    public static int binarySearch(int v, int[] arr, int l, int r) {

        int mid = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;

            int cmp = Integer.compare(v, arr[mid]);
            if (cmp == 0)
                return mid;
            else if (cmp > 0)
                l = mid + 1;
            else
                r = mid - 1;
        }
        
        return arr[mid] < v ? mid + 1 : mid;
    }
}
