package quick_sort_2_3.intquest;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;


/**
 * Decimal dominants. 
 *
 * Given an array with n keys, design an algorithm to find all 
 * values that occur more than n/10 times.
 *
 * The expected running time of your algorithm should be linear.
 *
 * Credits to https://stackoverflow.com/a/52932772
 * 
 *
 */

public class DecimalDominants {

    public static void main(String[] args) {
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 100;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = StdRandom.uniformInt(0, Math.max(n / 10, 1));

        System.out.println(Arrays.toString(arr));
        System.out.println("Search:");
        search(arr);
        System.out.println("Check:");
        check(arr);
    }


    public static void search(int[] arr) {
       search(arr, 0, arr.length - 1);  
       System.out.println();
    }

    public static void search(int[] arr, int lo, int hi) {
        if(lo >= hi) return;

        int lt = lo, gt = hi;
        int i = lo + 1;
        int v = arr[lo]; 

        while(i <= gt) {

            int cmp = Integer.compare(arr[i], v); 
            
            if     (cmp < 0)    exch(arr, i++, lt++); 
            else if(cmp > 0)    exch(arr, i,   gt--); 
            else i++;
        }


        if(gt + 1 - lt >= 10) 
            System.out.print(v + ", ");;

        search(arr, lo, lt - 1);
        search(arr, gt + 1, hi);
    }

    private static void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr [j] = tmp;
    }


    private static void check(int[] arr) {
        boolean[] c = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int co = 1;

           for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] == arr[j] && !c[j]) {
                    co++; 
                    c[j] = true;
                }
           } 

           if(co >= 10) System.out.print(arr[i] + ", ");
        }

        System.out.println();
    }

}


