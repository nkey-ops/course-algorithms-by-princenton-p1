package quick_sort_2_3.webex.ex2;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;
import utils.SortCompare;
/**
 *  Randomized quicksort. 
 *  Modify partition() so that it always chooses 
 *  the partitioning item uniformly at random from 
 *  the array (instead of shuffling the array initially). 
 *
 *  Compare the performance against  {@link SortCompare}
 *
 *  Coparsion results:
 *   For 1000 random Doubles
 *      quick is ~0.7 times faster than rquick
 */ 

public class RandomizedQuicksort {

   public static void main(String[] args) {
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) 
            arr[i] = StdRandom.uniformInt(n);
        
        System.out.println("Array: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));

    }
     

    public static <T> void sort(Comparable<T>[] arr) {
        sort(arr, 0, arr.length - 1);
    }

     public static <T> void sort(Comparable<T>[] arr, int lo, int hi) {
        if(hi <= lo) return;
        int i  = partition(arr, lo, hi);
        sort(arr, lo, i - 1);
        sort(arr, i + 1, hi);
    }


    public static <T> int partition(Comparable<T>[] arr, int lo, int hi) {
        int i = lo, j = hi + 1;

        exch(arr, lo, StdRandom.uniformInt(lo, hi + 1));
        Comparable<T> v = arr[lo];

        while (true) {
            while (less(arr[++i], v)) if(i == hi) break;
            while (less(v, arr[--j])) if(j == lo) break;

            if(i >= j) break;
            exch(arr, i, j);
        }
        exch(arr, lo, j);

        return j;
    }


    @SuppressWarnings("unchecked")
    private static <T> boolean less(Comparable<T> c1, Comparable<T> c2) {
        return c1.compareTo((T) c2) < 0;

    }

    private static <T> void exch(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }


}
