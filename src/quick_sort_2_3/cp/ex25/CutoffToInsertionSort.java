package quick_sort_2_3.cp.ex25;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.StdRandom;
import utils.Utils;

/**
 * Cutoff to insertion sort. 
 * Implement quicksort with a cutoff to insertion sort for subarrays with 
 * less than M elements, and empirically determine the value of M for
 * which quicksort runs fastest in your computing environment to 
 * sort random arrays of N doubles, for N = 103, 104, 105, and 106. 
 * Plot average running times for M from 0 to 30 for each value of M. 
 *
 * Note : You need to add a three-argument sort() method to Algorithm 2.2 
 * for sorting subarrays such that the call Insertion.sort(a, lo, hi)
 * sorts the subarray a[lo..hi].
 *
 * Results: 
 *
 * /algorithms/src/quick_sort_2_3/cp/ex25$ jal CutoffToInsertionSort.java 50
 *         N3      N4      N5      N6
 * M1      0.18    2.76    15.48   63.58
 * M2      0.06    0.84    3.4     415.92
 * M3      0.08    1.12    6.84    242.36
 * M4      0.06    0.96    13.28   231.96
 * M5      0.06    0.96    12.96   229.08
 * M6      0.08    0.68    5.92    106.36
 * M7      0.08    0.78    5.34    199.14
 * M8      0.08    0.96    13.02   208.86
 * M9      0.08    0.94    13.14   487.44
 * M10     0.08    1.16    15.84   208.12
 * M11     0.06    0.88    13.12   209.14
 * M12     0.08    0.92    32.5    153.84
 * M13     0.08    0.7     3.2     46.38
 * M14     0.08    0.82    12.94   178.08
 * M15     0.08    1.02    12.94   502.06
 * M16     0.08    0.98    12.82   210.3
 * M17     0.08    0.76    3.68    222.18
 * M18     0.08    0.96    12.7    226.16
 * M19     0.06    1.0     12.88   224.84
 * M20     0.08    0.96    12.82   212.88
 * M21     0.08    0.94    13.16   231.66
 * M22     0.06    1.0     13.06   217.08
 * M23     0.08    1.0     13.06   180.22
 * M24     0.08    0.82    3.68    228.08
 * M25     0.1     0.96    13.1    223.12
 * M26     0.08    1.02    13.3    229.08
 * M27     0.06    1.04    74.58   219.18
 * M28     0.1     0.96    13.36   230.88
 * M29     0.06    1.04    13.94   226.02
 * M30     0.08    1.08    14.06   228.58
 */
public class CutoffToInsertionSort {

    public static void main(String[] args) {
        int times = args.length == 1 ? Integer.parseInt(args[0]) : 10;
        int M = 30;
        int powMi = 3, powMa = 6;

        System.out.print("\t");
        for (int i = powMi; i <= powMa; i++) {
            System.out.printf("N%s\t", i);
        } 
        System.out.print("\n");


        List<List<Double[]>> arrays = generateData(times, powMi, powMa);
        for (int i = 1; i <= M; i++) {
            System.out.printf("M%s\t", i);
            
            for (int j = 0; j < arrays.size(); j++) {
                System.out.printf("%.7s\t", getAvgRuntime(arrays.get(j), i));
            }
            System.out.print("\n");
        }

    }

    private static List<List<Double[]>> generateData(int times, int powMi, int powMa) {
        List<List<Double[]>> arrays = new ArrayList<>();

        for (int i = powMi; i <= powMa ; i++) {
            List<Double[]> d = new ArrayList<>();
            for (int j = 0; j < times; j++)
                d.add(newArray((int) Math.pow(10, i)));

            arrays.add(d);
        }

        return arrays;
    }

    public static double getAvgRuntime(List<Double[]> arr, int M) { // Use alg to sort T random arrays of length N.
        double total = 0.0;

        for (Double[] doubles : arr)
            total += time(doubles.clone(), M);

        return  total / arr.size();
    }

    private static Double[] newArray(int N) {
        Double[] array = new Double[N];
        for (int i = 0; i < N; i++)
            array[i] = StdRandom.uniformDouble();

        return array;
    }

    private static double time(Double[] a, int M) {
        long begin = System.currentTimeMillis();
        sort(a, M);
        long end = System.currentTimeMillis();

        return end - begin;
    }

    private static <T> void sort(Comparable<T>[] a, int M) {
///        StdRandom.shuffle(a); commented out to provide consistency between tests 
        
        if(M < 1) 
            throw new IllegalArgumentException();
        sort(a, 0, a.length - 1, M);

        assert Utils.isSortedAsc(a);
    }

    private static <T> void sort(Comparable<T>[] a, int lo, int hi, int m) {
        if (hi - lo + 1 <= m) {
            insertionSort(a, lo, hi + 1);
            return;
        }
        
        int j = partition(a, lo, hi);

        sort(a, lo, j - 1, m);
        sort(a, j + 1, hi, m);

    }

    private static <T> int partition(Comparable<T>[] a, int lo, int hi) {
        int l = lo, r = hi + 1;
        Comparable<T> v = a[l];
        while (true) {
            while (isLess(a[++l], v) && l < hi);
            while (isLess(v, a[--r]));

            if (l >= r)
                break;
            exch(a, l, r);
        }

        exch(a, lo, r);

        return r;

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

    public static <T> void insertionSort(Comparable<T>[] a, int lo, int hi) {

        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo && isLess(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }

    }
}
