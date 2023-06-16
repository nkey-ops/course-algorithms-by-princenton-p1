package elementary_sorts_2_1.intquest;

import java.util.Arrays;
import java.util.Objects;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author deuru
 * 
 *         Intersection of two sets. Given two arrays a[] and b[], each
 *         containing n distinct 2D points in the plane, design a subquadratic
 *         algorithm to count the number of points that are contained both in
 *         array a[] and array b[].
 */
public class IntersectionOfTwoSets {

	public static void main(String[] args) {
		int[] a = StdRandom.permutation(20, 10);
		int[] b = StdRandom.permutation(20, 10);

		StdOut.println(Arrays.toString(a));
		StdOut.println(Arrays.toString(b));

		System.out.println(intersection(a, b));
	}

	/**
	 * Sort array a and b using shell sort O((a + b)^3/4) 
	 * Go through these arrays at the same time till 
	 * 	we reach the end of the shortest one. O(1/2(a + b)) 
	 * 
	 * Expected Result: O((a + b)^(3/4)) + O(1/2(a + b))
	 *
	 * 1/2n + n^3/4 <= n^1/2
	 * 
	 * 
	 * Task: not to exceed O((a + b)^1/2)
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int intersection(int[] a, int[] b) {
		shellSort(a);
		shellSort(b);

		int count = 0;

		for (int ai = 0, bi = 0; ai < a.length && bi < b.length;) {
			if (a[ai] < b[bi])
				ai++;
			else if (a[ai] > b[bi])
				bi++;
			else {
				ai++;
				bi++;
				count++;
			}

		}

		return count;
	}

	private static void shellSort(int[] a) {
		Objects.requireNonNull(a);
		if (a.length <= 1)
			return;

		int h = 1;
		while (h <= a.length / 3)
			h = 3 * h + 1;

		while (h >= 1) {

			for (int i = h; i < a.length; i++) {

				int tmp = a[i];
				int j;

				for (j = i; j >= h && tmp < a[j - h]; j -= h) {
					a[j] = a[j - h];
				}

				a[j] = tmp;
			}

			h /= 3;
		}
	}
}
