package quick_sort_2_3.cp.ex18;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Median-of-3 partitioning.
 * Add median-of-3 partitioning to quicksort, as described in the text
 * (see page 296).
 * Run doubling tests to determine the effectiveness of the change.
 *
 *
 * Results: 
 *
 *   algorithms/src/utils$ jal SortCompare.java medq quick
 *   50000 1000 
 *   For 50000 random Doubles and 1000 repeats
 *   MedianOf3Partittioning is 0.77853 times faster than QuickSort 
 */


public class MedianOf3Partitioning {

    public static void main(String[] args) {
        int[] arr = StdRandom.permutation(args.length == 1 ? Integer.parseInt(args[0]) : 10);

        Integer[] a = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
            a[i] = arr[i];

        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));

    }

    public static <T> void sort(Comparable<T>[] arr) {

        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1);

    }

    private static <T> void sort(Comparable<T>[] arr, int l, int h) {

        if (h <= l)
            return;

        int j = partition(arr, l, h);

        sort(arr, l, j - 1);
        sort(arr, j + 1, h);
    }

    private static <T> int partition(Comparable<T>[] arr, int l, int h) {

       Comparable<T> v;

        if(h - l + 1 < 3)  v = arr[l]; 
        else {
             Comparable<T>  a = arr[l], 
                                  b = arr[l + 1], 
                                  c = arr[l + 2];

             v = isLess(a, b) ? 
                             (isLess(b, c) ?    
                                     b : 
                                     (isLess(a, c) ? c : a)) :
                             (isLess(a, c) ?  
                                      a :
                                     (isLess(b, c) ? c : b)); 

             if     (v == b) exch(arr, l, l + 1);
             else if(v == c) exch(arr, l, l + 2);
        }

        int i = l, j = h + 1;
        while(true) {
            

            while(isLess(arr[++i], v ) && i < h);
            while(isLess(v, arr[--j]) && j > l);

            if(j <= i) break;
            

            exch(arr, i, j);
        }

        exch(arr, l, j);
        
        return j;
    }

    private static <T> void exch(Comparable<T>[] arr, int i, int j) {
        Comparable<T>  tmp = arr[i]; 
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @SuppressWarnings("unchecked")
    public static <T> boolean isLess(Comparable<T> a, Comparable<T> b) {

        return a.compareTo((T) b) < 0;
    }

}
