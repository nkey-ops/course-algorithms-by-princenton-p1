package quick_sort_2_3.cp.ex17;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Sentinels.
 * Modify the code in Algorithm 2.5 to remove both bounds checks
 * in the inner while loops. The test against the left end of the subarray is
 * redundant since
 * the partitioning item acts as a sentinel (v is never less than a[lo]). To
 * enable removal of
 * the other test, put an item whose key is the largest in the whole array into
 * a[length-1]
 * just after the shuffle. This item will never move (except possibly to be
 * swapped with an
 * item having the same key) and will serve as a sentinel in all subarrays
 * involving the end
 * of the array.
 *
 * Note : When sorting interior subarrays, the leftmost entry in the subarray
 * to the right serves as a sentinel for the right end of the subarray.
 *
 */
public class Sentinels {

    public static void main(String[] args) {
        int[] arr = StdRandom.permutation(args.length == 1 ? Integer.parseInt(args[0]) : 10);

        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr) {

        int bi = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[bi] < arr[i])
                bi = i;

            int r = i + StdRandom.uniformInt(arr.length - i); // between i and n-1
            int temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;

            if (arr[bi] < arr[i])
                bi = i;
        }

        int temp = arr[bi];
        arr[bi] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;


        System.out.println(Arrays.toString(arr));

        sort(arr, 0, arr.length - 1);

    }

    private static void sort(int[] arr, int l, int h) {
        if (h <= l)
            return;

        int j = partition(arr, l, h);

        sort(arr, l, j - 1);
        sort(arr, j + 1, h);

    }

    private static int partition(int[] arr, int l, int h) {

        int i = l, j = h + 1;
        int v = arr[l];
        while (true) {

            while (arr[++i] < v);
            while (v < arr[--j]);

            if (i >= j)
                break;

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        arr[l] = arr[j];
        arr[j] = v;

        return j;
    }
}
