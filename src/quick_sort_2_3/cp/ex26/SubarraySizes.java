package quick_sort_2_3.cp.ex26;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.StdRandom;
import utils.Utils;

/**
 * SubarraySizes
 * Subarray sizes.
 * Write a program that plots a histogram of the subarray sizes left
 * for insertion sort when you run quicksort for an array of size N with a
 * cutoff for subarrays of size less than M.
 * Run your program for M=10, 20, and 50 and N = 105.
 *
 * Result:
 *  Histogram [5]: rec num 33172 avg 2 min 0 max 4
 *  Histogram [10]: rec num 18064 avg 4 min 0 max 9
 *  Histogram [20]: rec num 9444 avg 9 min 0 max 19
 *  Histogram [50]: rec num 3911 avg 24 min 0 max 49
 */
public class SubarraySizes {

    public static class Histogram {
        final int avg;
        final int min;
        final int max;
        final int m;
        final int recNum;

        public Histogram(List<Integer> sort, int m) {
            int tAvg = 0;
            int tMin = 0;
            int tMax = 0;

            for (int i = 0; i < sort.size(); i++) {
                Integer integer = sort.get(i);
                if (integer < tMin)
                    tMin = integer;
                else if (integer > tMax)
                    tMax = integer;

                tAvg += integer;
            }

            avg = tAvg / sort.size();
            min = tMin;
            max = tMax;
            this.m = m;
            recNum = sort.size();
        }

        @Override
        public String toString() {
            return String.format(
                    "Histogram [%s]: rec num %s avg %s min %s max %s", m, recNum, avg, min, max);
        }

    }

    public static void main(String[] args) {
        List<List<Double[]>> generateData = generateData(1, 5, 5);

        System.out.println(sort(generateData.get(0).get(0).clone(), 5));
        System.out.println(sort(generateData.get(0).get(0).clone(), 10));
        System.out.println(sort(generateData.get(0).get(0).clone(), 20));
        System.out.println(sort(generateData.get(0).get(0).clone(), 50));

    }

    private static <T> Histogram sort(Comparable<T>[] a, int M) {
        /// StdRandom.shuffle(a); commented out to provide consistency between tests
        List<Integer> list = new ArrayList<>();
        if (M < 1)
            throw new IllegalArgumentException();

        sort(a, 0, a.length - 1, M, list);

        assert Utils.isSortedAsc(a);

        return new Histogram(list, M);
    }

    private static <T> void sort(Comparable<T>[] a, int lo, int hi, int m,
            List<Integer> histogram) {
        if (hi - lo + 1 < m) {
            insertionSort(a, lo, hi + 1);
            histogram.add(hi - lo + 1);
            return;
        }

        int j = partition(a, lo, hi);

        sort(a, lo, j - 1, m, histogram);
        sort(a, j + 1, hi, m, histogram);

    }

    private static <T> int partition(Comparable<T>[] a, int lo, int hi) {
        int l = lo, r = hi + 1;
        Comparable<T> v = a[l];
        while (true) {
            while (isLess(a[++l], v) && l < hi) ;
            while (isLess(v, a[--r])) ;

            if (l >= r)
                break;
            exch(a, l, r);
        }

        exch(a, lo, r);

        return r;

    }

    private static List<List<Double[]>> generateData(int times, int powMi, int powMa) {
        List<List<Double[]>> arrays = new ArrayList<>();

        for (int i = powMi; i <= powMa; i++) {
            List<Double[]> d = new ArrayList<>();
            for (int j = 0; j < times; j++)
                d.add(newArray((int) Math.pow(10, i)));

            arrays.add(d);
        }

        return arrays;
    }

    private static Double[] newArray(int N) {
        Double[] array = new Double[N];
        for (int i = 0; i < N; i++)
            array[i] = StdRandom.uniformDouble();

        return array;
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
