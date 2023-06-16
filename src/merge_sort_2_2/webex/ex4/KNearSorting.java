package merge_sort_2_2.webex.ex4;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 *  k-near-sorting.
 *  Suppose you have an array a[] of N distinct items which is nearly
 *  sorted:
 *  Each item at most k positions away from its position in the sorted
 *  order.
 *  Design an algorithm to sort the array in time proportional to N log k. 
 *  @author deuru
 */
public class KNearSorting {

    public static void main(String[] args) {
        int[] a = StdRandom.permutation(
                args.length == 1 ? Integer.parseInt(args[0]) : 10);

        System.out.println("Array:" + Arrays.toString(a));
        sort(a);
        System.out.println("Sorted" + Arrays.toString(a));
    }

    /**
     * Iterate from arr[1] to arr[N] over the array.
     * Compare the current element (key) to its predecessor.
     *
     * If the key element is smaller than its predecessor,
     * compare it to the elements before.
     *
     * Move the greater elements one position up to
     * make space for the swapped element.
     *
     */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int e = arr[i];
            int j;

            for (j = i - 1; j >= 0 && arr[j] > e; j--)
                arr[j + 1] = arr[j];

            arr[j + 1] = e;
        }
    }
}
