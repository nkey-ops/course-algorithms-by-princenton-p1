package quick_sort_2_3.ex.ex5;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Write a program Sort2distinct.java
 * that sorts an array that is known to contain just two distinct key values.
 *
 */
public class Sorted2distinct {

    public static void main(String[] args) {
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;

        boolean[] arr = new boolean[n];
        for (int i = 0; i < n; i++) 
            arr[i] = StdRandom.bernoulli();
        
        System.out.println("Array: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));

    }

    public static void sort(boolean[] arr) {
        int h = arr.length - 1;
        for (int i = 0; i <= h;) {
            if (arr[i] == false) {
                arr[i] = arr[h];
                arr[h--] = false;
            }else 
                i++;
        }
    }

}
