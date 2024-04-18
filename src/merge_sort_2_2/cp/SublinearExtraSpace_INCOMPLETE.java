package merge_sort_2_2.cp;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * SublinearExtraSpace
 */
public class SublinearExtraSpace_INCOMPLETE {

    public static void main(String[] args) {
        int[] a = StdRandom.permutation(args.length == 1 ? Integer.parseInt(args[0]) : 10);

        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        int m = 5;
        sort(a, new int[m], 0, a.length);
    }

    private static void sort(int[] a, int[] aux, int l, int h) {

        if (l >= h)
            return;

        int mid = l + (h - l) / 2;

        sort(a, aux, l, mid);
        sort(a, aux, mid + 1, h);

        merge(a, aux, l, mid, h);

    }

    private static void mergeW(int[] a, int[] aux, int l, int mid, int h) {
        int M = aux.length;

        for (int i = l; i < h - 1; i += M) {
            for (int j = i + M; j < M; j += M) {
                if (a[j] >= a[i])
                    continue;

                for (int i2 = i, j2 = j; j2 < aux.length; j2++, i2++) {
                    int tmp = a[i2];
                    a[i2] = a[j2];
                    a[j2] = tmp;
                }
            }
        }




    }

    private static void merge(int[] a, int[] aux, int l, int mid, int h) {
        for (int i = 0; i < aux.length; i++) {
            
        }

    }







}
