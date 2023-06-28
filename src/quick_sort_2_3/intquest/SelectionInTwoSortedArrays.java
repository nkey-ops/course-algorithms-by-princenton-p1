package quick_sort_2_3.intquest;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 *  Selection in two sorted arrays. 
 *
 *  Given two sorted arrays a[  ]a[] and b[  ]b[], 
 *  of lengths n1 and n2 and an integer 0 ≤ k < n1+n2,
 *  design an algorithm to find a key of rank k.
 *
 *  The order of growth of the worst case running time 
 *  of your algorithm should be logn, where n = n1+n2.
 *
 *    Version 1: n1=n2 (equal length arrays) and k= n/2 (median).
 *
 *    Version 2: k=n/2 (median).
 *
 *    Version 3: no restrictions.
 *
 */
public class SelectionInTwoSortedArrays {

    public static void main(String[] args) {
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;

        testV1(n);
        System.out.println();

        testV2(n);
        System.out.println();

        testV3(n);
    }

    public static void testV1(int n){
       int[] a = StdRandom.permutation(n, n / 2);
        int[] b = StdRandom.permutation(n, n / 2);

        Arrays.sort(a);
        Arrays.sort(b);
        int[] c = merge(a, b);

        System.out.printf("Arrays:\n%s\n%s\n%s\n", 
                     Arrays.toString(a), Arrays.toString(b), 
                     Arrays.toString(c));

        System.out.printf("Value V1: %s k %s\n", 
                     searchV1(a, b), n / 2);

        assert c[n / 2 - 1] == searchV1(a, b);
    }


    public static void testV2(int n){
        int s = StdRandom.uniformInt(n + 1);

        int[] a = StdRandom.permutation(n, s  );
        int[] b = StdRandom.permutation(n, n - s);

        Arrays.sort(a);
        Arrays.sort(b);

        int[] c = merge(a, b);

        System.out.printf("Arrays:\n%s\n%s\n%s\n", 
                     Arrays.toString(a), Arrays.toString(b), 
                     Arrays.toString(c));

        System.out.printf("Value V2: %s k %s\n", 
                     searchV2(a, b), n / 2);

        assert merge(a, b)[n / 2 - 1] == searchV2(a, b);
    }

    public static void testV3(int n){
        int s = StdRandom.uniformInt(n + 1);
        int k = StdRandom.uniformInt(1, n + 1);

        int[] a = StdRandom.permutation(n, s  );
        int[] b = StdRandom.permutation(n, n - s);

        Arrays.sort(a);
        Arrays.sort(b);

        int[] c = merge(a, b);


        System.out.printf("Arrays:\n%s\n%s\n%s\n", 
                     Arrays.toString(a), Arrays.toString(b), 
                     Arrays.toString(c));

        System.out.printf("Value V2: %s k %s\n", 
                     searchV3(a, b, k), k);

        assert merge(a, b)[k - 1] == searchV3(a, b, k);
    }

    public static int searchV1(int[] a, int[] b) {
        if(a.length != b.length) 
            throw new IllegalArgumentException();

        int n = a.length * 2;

        int l = 0, r = 0, k =  n / 2 - 1;
        int v = -1;
        for(int i = 0; i < n && i - 1 != k; i++) {
            if     (l >= a.length)         v = b[r++];    
            else if(r >= b.length)         v = a[l++];    
            else if(a[l] < b[r])           v = a[l++];    
            else                           v = b[r++];    
        }

        return v;
    }


    public static int searchV2(int[] a, int[] b) {
        int n = a.length  + b.length;

        int l = 0, r = 0, k =  n / 2 - 1;
        int v = -1;
        for(int i = 0; i < n && i - 1 != k; i++) {
            if     (l >= a.length)         v = b[r++];    
            else if(r >= b.length)         v = a[l++];    
            else if(a[l] < b[r])           v = a[l++];    
            else                           v = b[r++];    
        }

        return v;
    }


    public static int searchV3(int[] a, int[] b, int k) {
        int n = a.length  + b.length;

        k = k - 1;
        int l = 0, r = 0;
        int v = -1;
        for(int i = 0; i < n && i - 1 != k; i++) {
            if     (l >= a.length)         v = b[r++];    
            else if(r >= b.length)         v = a[l++];    
            else if(a[l] < b[r])           v = a[l++];    
            else                           v = b[r++];    
        }

        return v;
    }

	private static int[] merge(int[] a, int[] b) {
        int n = a.length + b.length;

        int[] dst  = new int[n];

        int l = 0, r = 0; 
        for(int i = 0; i < n; i++) {
            if     (l >= a.length)        dst[i] = b[r++];    
            else if(r >= b.length)        dst[i] = a[l++];    
            else if(a[l] < b[r])          dst[i] = a[l++];    
            else                          dst[i] = b[r++];    
        }

        return dst;

	}	
}

