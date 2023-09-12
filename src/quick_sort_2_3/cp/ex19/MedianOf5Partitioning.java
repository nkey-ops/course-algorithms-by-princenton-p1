package quick_sort_2_3.cp.ex19;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;
import utils.Utils;

/**
 *  Median-of-5 partitioning. 
 *   Implement a quicksort based on partitioning on the
 *   median of a random sample of five items from the subarray. 
 *   Put the items of the sample at the appropriate ends of the array 
 *
 *   so that only the median participates in partitioning.
 *
 *   Run doubling tests to determine the effectiveness of the change, 
 *   in comparison both to the standard algorithm and to median-of-3 
 *   partitioning (see the previous exercise).
 *
 *   Extra credit : Devise a median-of-5 algorithm that uses fewer than seven compares on
 *   any input.
 */
public class MedianOf5Partitioning {

    public static void main(String[] args) {
        int[] arr = StdRandom.permutation(args.length == 1 ? Integer.parseInt(args[0]) : 10);

        Integer[] a = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
            a[i] = arr[i];

        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));

        assert Utils.isSortedAsc(a);
    }

    public static <T> void sort(Comparable<T>[] a) {

        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);

    }

    private static <T> void sort(Comparable<T>[] a, int lo, int hi ) {
        if(lo >= hi) { 
            return;
        }

        int j = partition(a, lo, hi);
        if(hi - lo + 1 == 5) return;
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);

    }

    private static <T> int partition(Comparable<T>[] arr, int lo, int hi) {

        Comparable<T> v = arr[ hi - lo + 1 >= 5 ? medianOf5Partition(arr, lo, hi) : lo ];

        if(hi - lo + 1 == 5) return lo + 2; 


        boolean s = hi - lo + 1 < 5;
        int l = lo + (s ? 0 : 2) , r = hi + (s ? 1 : - 1);  
        while(true) {
            while(isLess(arr[++l], v) && l < hi  );
            while(isLess(v, arr[--r]));

            if(l >= r) break;

            exch(arr, l, r);
        }

                
        exch(arr, lo + (s ? 0 : 2), r);

        return r;
  }

    private static <T> int medianOf5Partition(
            Comparable<T>[] arr, int lo, int hi) {


        int fifth = (int) Math.ceil((hi - lo ) / 5.00);
        int a = lo, 
            b = lo + fifth, 
            c = lo + (hi - lo ) / 2, 
            d = hi - fifth, 
            e = hi; 
            
        if (isLess(arr[b], arr[a])) {exch(arr, a, b);}
        if (isLess(arr[e], arr[d])) {exch(arr, d, e);}
        if (isLess(arr[c], arr[a])) {exch(arr, a, c);}
        if (isLess(arr[c], arr[b])) {exch(arr, b, c);}
        if (isLess(arr[d], arr[a])) {exch(arr, a, d);}
        if (isLess(arr[d], arr[c])) {exch(arr, c, d);}
        if (isLess(arr[e], arr[b])) {exch(arr, b, e);}
        if (isLess(arr[c], arr[b])) {exch(arr, b, c);}
        if (isLess(arr[e], arr[d])) {exch(arr, d, e);}


       assert isLess(arr[a], arr[b]) 
           && isLess(arr[b], arr[c]) 
           && isLess(arr[c], arr[d]) 
           && isLess(arr[d], arr[e]);

        exch(arr, lo + 1, b);
        exch(arr, lo + 2, c);
        exch(arr, hi - 1, d);
        exch(arr, hi, e);

        return lo + 2;
    
    }

    @SuppressWarnings("unchecked")
    public static <T> boolean isLess(Comparable<T> a, Comparable<T> b) {
        return a.compareTo((T) b) < 0;
    }


    private static <T> void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
