package quick_sort_2_3.webex.ex6;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Hoare's original quicksort.
 * Implement a version of Hoare's original quicksort algorithm.
 * It's similar to our two-way partitioning algorithm except 
 * that the pivot is not swapped into its final position. 
 *
 * Instead, the pivot is left in one of the two subarrays,
 * no element is fixed in its final position,
 * and the two subarrays where the pointers cross are sorted recursively. 
 *
 */
public class HoareQuick {

    public static void main(String[] args) {
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = StdRandom.uniformInt(n);

        System.out.println("Array: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi)
            return;

        System.out.println(Arrays.toString(arr));

        int i = lo - 1, j = hi + 1;
        int v = arr[lo];

        while (true) {
            while (arr[++i] < v && i != hi);
            while (v < arr[--j] && j != lo);
                
            if(i >= j) break;
            exch(arr, i, j);        
        }

        sort(arr, lo, j);
        sort(arr, j + 1, hi);
    }

    private static  void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }
}
