package quick_sort_2_3.webex.ex5;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Comparing an item against itself. 
 * Show that our implementation of quicksort can compare 
 * an item against itself, i.e., calls less(i, i) for some index i. 
 * Modify our implementation so that it never compares an item against itself. 
 */

public class ex5 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        //for (int i = 0; i < n; i++) 
        //    arr[i] = StdRandom.uniformInt(n);
        
        System.out.println("Array: " + Arrays.toString(arr));

        System.out.println("Sort WITH self comparison");
        sortWithSelfComparison(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));

        System.out.println("Sort WITHOUT self comparison");
        sortWithoutSelfComparison(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
    


    public static void sortWithSelfComparison(int[] arr) {
        //StdRandom.shuffle(arr); commention out to get corner keys
        sortWithSelfComparison(arr, 0, arr.length - 1);
    }

    public static void sortWithoutSelfComparison(int[] arr) {
        //StdRandom.shuffle(arr); commention out to get corner keys
        sortWithoutSelfComparison(arr, 0, arr.length - 1);
    }

    private static void sortWithSelfComparison(int[] arr, int lo, int hi) {
        if(lo >= hi) return;

        int i = lo, j = hi + 1;
        int v = arr[lo];

        while(true) {
            while(arr[++i] < v && i != hi);
            // if  all figures after lo are bigger than
            // upper "while" will break on lo + 1
            // lower"while" will continue till it see arr[lo]
            // but before that it will check it 
            while(v < arr[--j] && j != lo); 

            if(lo == j) 
                System.out.printf(
                        "Compared arr[i] with arr[i] at %s\n", i);

            if(i >= j) break;
            exch(arr, i, j);
        }

        exch(arr, lo, j);

        sortWithSelfComparison(arr, lo, j - 1);
        sortWithSelfComparison(arr,  j + 1, hi);

    }

    private static void sortWithoutSelfComparison(int[] arr, int lo, int hi) {
        if(lo >= hi) return;

        int i = lo, j = hi + 1;
        int v = arr[lo];

        while(true) {
            while(arr[++i] < v && i != hi);
            while(v < arr[--j])
                if(lo == j) {
                    System.out.printf( "Compared arr[i] with arr[i] at %s\n", j);
                    break;
                }

            if(i >= j) break;
            exch(arr, i, j);
        }

        exch(arr, lo, j);

        sortWithoutSelfComparison(arr, lo, j - 1);
        sortWithoutSelfComparison(arr,  j + 1, hi);

    }

    private static  void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }
}









