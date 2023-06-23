package utils;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import elementary_sorts_2_1.exp.ex23_24.InsertionX;
import merge_sort_2_2.cp.MergeX;
import quick_sort_2_3.webex.ex2.RandomizedQuicksort;

public class SortCompare {
	public static double time(String alg, Double[] a) {
		Stopwatch timer = new Stopwatch();

		switch (alg) {
		case "Insertion" -> Insertion.sort(a);
		case "InsertionX" -> InsertionX.sort(a);
		case "Selection" -> Selection.sort(a);
		case "Shell" -> Shell.sort(a);
		case "Merge" -> Merge.sort(a);
		case "MergeX" -> MergeX.sort(a);
		case "quick" -> Quick.sort(a);
		case "rquick" -> RandomizedQuicksort.sort(a);
		case "Heap" -> Heap.sort(a);
		}

		double elapsedTime = timer.elapsedTime();

		return elapsedTime;
	}

	
	
	@SuppressWarnings("unchecked")
	private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
		return v.compareTo((T) w) < 0;
	}

	public static double timeRandomInput(String alg, int N, int T) { // Use alg to sort T random arrays of length N.
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++) { // Perform one experiment (generate and sort an array).
			for (int i = 0; i < N; i++)
				a[i] = StdRandom.uniformDouble();
			total += time(alg, a);
		}

		return total;
	}

	public static void main(String[] args) {
		if (args.length != 4) {
			System.err.println("Usage [sorting][sorting][values][times]");
			System.exit(-1);
		}

		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		
		if (!isSorted(alg1))
			throw new RuntimeException(alg1 + " Didn't sort an array");
		if (!isSorted(alg2))
			throw new RuntimeException(alg2 + " Didn't sort an array");


		double t1 = timeRandomInput(alg1, N, T); // total for alg1
		double t2 = timeRandomInput(alg2, N, T); // total for alg2
		StdOut.printf("For %d random Doubles\n %s is", N, alg1);
		StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
	}

/***************************************************************************
	 * Check if array is sorted - useful for debugging.
	 ***************************************************************************/
	private static <T> boolean isSorted(String arr) {
		Double[] a = new Double[100];
	
		for (int i = 0; i < a.length; i++)
				a[i] = StdRandom.uniformDouble();
		
		time(arr, a);

		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;

		return true;
	}
}
