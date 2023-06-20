package quick_sort_2_3.cp.ex16;

import java.util.Arrays;

/**
 * Best case.
 * Write a program QuickBest.java
 * that produces a best-case array (with no duplicates) for Quick.sort():
 *
 * An array of N distinct keys with the property that
 * every partition will produce subarrays that differ in size by at most 1
 * (the same subarray sizes that would happen for an array of N equal keys).
 *
 * For the purposes of this exercise, ignore the initial shuffle.
 */

public class BestCase {

    public static void main(String[] args) {
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 15;

        produceAlphabet(n);
    }

    public static Character[] produceAlphabet(int n) {
        if(n < 0 || n > 26)
            throw new IllegalArgumentException();

        Character[] arr = new Character[n];

        for (int i = 0; i < n; i++)
            arr[i] = (char) (65 + i) ;
        

        System.out.println(" ".repeat(12)  +  Arrays.toString(arr));
        produce(arr, 0, n - 1);

        return arr;
    }

    public static <T> void produce(T[] arr, int lo, int hi) {
        if (lo >= hi) {

        System.out.printf("%-11s %s\n", arr[lo],  Arrays.toString(arr));
            return;
        }

        int mid = lo + (hi - lo) / 2;

        produce(arr, mid + 1, hi);
        produce(arr, lo, mid - 1);

        T tmp = arr[lo];
        arr[lo] = arr[mid];
        arr[mid] = tmp;


        System.out.printf("%-2s-%-2s %-2s-%-2s %s\n",  mid, tmp, lo,  arr[lo],  Arrays.toString(arr));
    }
    
}
