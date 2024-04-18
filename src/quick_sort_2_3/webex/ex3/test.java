
package quick_sort_2_3.webex.ex3;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;

public class test {

    /**
     * Reads in a sequence of strings from standard input; quicksorts them;
     * and prints them to standard output in ascending order.
     * Shuffles the array and then prints the strings again to
     * standard output, but this time, using the select method.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();

System.out.println(System.getProperty("java.util.Arrays.useLegacyMergeSort"));

        Arrays.sort(a);
        assert isSorted(a);

       System.out.println(Arrays.toString(a));
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }

    private static boolean less(Comparable v, Comparable w) {
        if (v == w)
            return false; // optimization when reference equals
        return v.compareTo(w) < 0;
    }
}
