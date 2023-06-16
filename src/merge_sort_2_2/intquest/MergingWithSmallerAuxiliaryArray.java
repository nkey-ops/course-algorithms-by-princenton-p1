package merge_sort_2_2.intquest;

import static java.lang.Math.ceil;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author dueru Question 1
 * 
 * Merging with smaller auxiliary array. Suppose that the subarray
 * 	a[0]a[0] to a[n−1]a[n−1] is sorted and the subarray a[n]a[n] to
 * 	a[2∗n−1]a[2∗n−1] is sorted.
 *
 * How can you merge the two subarrays so that a[0]a[0] to
 * 	a[2∗n−1]a[2∗n−1] is sorted using an auxiliary array of length n
 * 	(instead of 2n2n)?
 * 
 * Hint: copy only the left half into the auxiliary array.
 * 
 */
public class MergingWithSmallerAuxiliaryArray {

	public static void main(String[] args) {

		int[] a = StdRandom.permutation(args.length == 1 ? Integer.parseInt(args[0]) : 10);

		System.out.println(Arrays.toString(a));
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void sort(int[] a) {
		sort(a, new int[ (int) ceil(a.length / 2.0)], 0, a.length - 1);
	}
	
	
	private static void sort(int[] a, int[] aux, int lo, int hi) {
		if(lo >= hi) return;
		
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}


	private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		if(a != null && lo < 0 && hi >= a.length
				 && aux.length >= a.length / 2) 
			throw new IllegalArgumentException(); 
		
		int l = 0, r = mid + 1;

		for (int i = lo; i <= mid; i++) 
			aux[i - lo] = a[i];
			
		for (int i = lo; i <= hi; i++) {
			if(l > mid - lo) 			a[i] = a[r++];
			else if(r > hi) 		a[i] = aux[l++];
			else if(aux[l] < a[r]) 	a[i] = aux[l++];
			else 					a[i] = a[r++];
		}
	}
}
