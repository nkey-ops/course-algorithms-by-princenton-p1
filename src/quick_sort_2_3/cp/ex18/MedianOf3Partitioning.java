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
 *  deuru@local:~/table/space/algorithms/src/utils$ jal -ea SortCompare.java quick 
 *  med3q 10000 10000
 *  quick: 14.24200
 *  med3q: 10.23500
 *  For 10000 random Doubles
 *  quick is 0.71865 times slower than med3q
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

       Comparable<T> v ;

        
        if(h - l + 1 == 2)  v = arr[l]; 
        else {
            int i = l + (h - l) / 2;
            v = medianThree(arr[l], arr[i], arr[h]);

             if     (v == arr[i]) exch(arr, l, i);
             else if(v == arr[h]) exch(arr, l, h);
        }

        int i = l, j = h + 1;
        while(true) {
            while(isLess(arr[++i], v ) && i < h);
            while(isLess(v, arr[--j]) && j > l);

            // find item on lo to swap
            if(j <= i) break;
            

            exch(arr, i, j);
        }

        exch(arr, l, j);
        
        return j;
    }


   private  static <T> Comparable<T> medianThree(
                         Comparable<T> a,
                         Comparable<T> b,  Comparable<T> c) {
    if ((isLess(b, a)) ^ (isLess(c, a))) 
        return a;
    else if (isLess(b, a) ^ isLess(b, c)) 
        return b;
    else
        return c;
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
