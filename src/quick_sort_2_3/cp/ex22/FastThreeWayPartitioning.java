package quick_sort_2_3.cp.ex22;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Fast three-way partitioning. (J. Bentley and D. McIlroy).
 *
 * Implement an entropy-optimal sort QuickBentleyMcIlroy.java based on
 * keeping equal keys at both the left and right ends of the subarray.
 *
 * Maintain indices p and q such that a[lo..p-1]
 * that a[q+1..hi] are all equal to a[lo],
 * an index i such that a[p..i-1] are all less than a[lo]
 * and an index j such that a[j+1..q] are all greater than a[lo].
 *
 * Add to the inner partitioning loop code to swap a[i] with a[p]
 * (and increment p) if it is equal to v
 * and to swap a[j] with a[q] (and decrement q) if
 * it is equal to v before the usual comparisons of a[i] and a[j] with v.
 *
 * Bentley-McIlroy 3-way partitioning overview
 * After the partitioning loop has terminated,
 * add code to swap the equal keys into position
 */
public class FastThreeWayPartitioning {

    public static void main(String[] args) {
        int[] arr =  StdRandom.permutation(args.length == 1 ? Integer.parseInt(args[0]) : 10);

        for (int i = 0; i < arr.length; i++) {
           arr[i] = (int) (Math.random() * 10); 
        }


        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr) {
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi)
            return;

        int p = lo, q = hi + 1;
        int i = lo,     j = hi + 1;
        int v = arr[lo];

        while (true) {
            while(arr[++i] < v) if (i == hi) break;
            while(arr[--j] > v) if(j == lo ) break;
            
            
            if(i == j  && arr[i] == v) swap(arr, i, ++p); 
            if(i >= j) break;

            swap(arr, i, j);
        
            if(arr[i] == v) swap(arr, i, ++p);
            if(arr[j] == v) swap(arr, j, --q);
        }


        i = j + 1;
        for (int k = lo; k <= p; k++)
            swap(arr, k, j--);
        for (int k = hi; k >= q; k--)
            swap(arr, k, i++);

        sort(arr, lo, j);
        sort(arr, i, hi);
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
