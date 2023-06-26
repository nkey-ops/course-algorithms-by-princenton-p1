package quick_sort_2_3.webex.ex7;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;
import utils.Utils;
/**
 *  Dual-pivot quicksort. 
 *  Implement a version of Yaroslavskiy's dual-pivot quicksort. 
 *
 * Sources:
 *  The algorithm provides the following steps:
 *    1. For small arrays (length < 27), use the Insertion sort algorithm.
 *
 *    2. Choose two pivot elements P1 and P2. 
 *          We can get, for example, the first element
 *          a[left] as P1 and the last element a[right] as P2.
 *
 *    3. P1 must be less than P2, otherwise they are swapped. 
 *       So, there are the following parts:
 *          • part I with indices from left+1 to L–1 with elements, 
 *            which are less than P1,
 *          • part II with indices from L to K–1 with elements, 
 *            which are greater or equal to P1 and less or equal to P2,
 *          • part III with indices from G+1 to right–1 with elements greater than P2,
 *          • part IV contains the rest of the elements to be examined 
 *            with indices from K to G.
 *
 *    4. The next element a[K] from the part IV is compared with two pivots 
 *          P1 and P2, and placed to the corresponding part I, II, or III.
 *
 *    5. The pointers L, K, and G are changed in the corresponding directions.
 *
 *    6. The steps 4 - 5 are repeated while K ≤ G.
 *
 *    7. The pivot element P1 is swapped with the last element from part I,
 *       the pivot element P2 is swapped with the first element from part III.
 *
 *    8. The steps 1 - 7 are repeated recursively for every 
 *       part I, part II, and part III
 *
 * at: https://codeblab.com/wp-content/uploads/2009/09/DualPivotQuicksort.pdf
 *
 */
public class DualPivot {

    public static void main(String[] args) {
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = StdRandom.uniformInt(n);

        System.out.println("Array: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));

        assert Utils.isSortedAsc(arr);
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi)
            return;

        if (arr[lo] > arr[hi])  exch(arr, lo, hi);
        int p1 = arr[lo];
        int p2 = arr[hi];

        int l = lo, k = l + 1, g = hi;

        while (k < g) {
            if (arr[k] < p1)        exch(arr, k++, ++l);
            else if (arr[k] > p2)   exch(arr, k, --g);
            else k++;
        }

        exch(arr, lo, l);
        exch(arr, hi, g);

        sort(arr, lo, l - 1);
        sort(arr, l + 1, g - 1);
        sort(arr, g + 1, hi);
    }

    private static void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
