package elementary_sorts_2_1.intquest;

import java.util.Arrays;
import java.util.Objects;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author deuru
 * Permutation. 
 * 	Given two integer arrays of size n, 
 * 	 design a subquadratic algorithm to determine 
 * 	 whether one is a permutation of the other. 
 * 	That is, do they contain exactly the same entries but, 
 * 	 possibly, in a different order.
 */
public class Permutation {

	public static void main(String[] args) {
		int[] a = StdRandom.permutation(20 );
		int[] b = StdRandom.permutation(20);

		StdOut.println(Arrays.toString(a));
		StdOut.println(Arrays.toString(b));

		
		System.out.println(intersection(a, b));
	}

	/**
	 * Sorts arrays a and b using shell sort O((a + b)^3/4) 
	 * And compares each entry if they're the same or not.
	 * If not returns false
	 * After reaching the end, returns true
	 *  
	 * @param a integer array
	 * @param b integer array
	 * @return whether one array is permutation on another
	 */
	public static boolean intersection(int[] a, int[] b) {
		Objects.requireNonNull(a);
		Objects.requireNonNull(b);

		if(a.length != b.length) return false;
			
		shellSort(a);
		shellSort(b);
		

		for (int i = 0; i < b.length; i++) 
			if(a[i] != b[i] ) return false;
		
		return true;
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
