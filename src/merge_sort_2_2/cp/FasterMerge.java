package merge_sort_2_2.cp;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author deuru 
 * Faster merge 
 * 	Implement a version of merge() that copies the second half of a[] to aux[] 
 * 	  in decreasing order  and then does the merge back to a[]. 
 *    This change allows you to remove the code to test
 *    that each of the halves has been exhausted from the inner loop. 
 *    
 *    Note: the resulting sort is not stable.
 */
public class FasterMerge {
	public static void main(String[] args) {
		int[] a = StdRandom.permutation( args.length == 1 ? Integer.parseInt(args[0]) : 10);

		System.out.println(Arrays.toString(a));
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void sort(int[] a ) {
		sort(a, new int[a.length], 0 , a.length - 1);
	}

	private static void sort(int[] a, int[] aux, int lo, int hi) {
		if(lo >= hi) return;

		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid );
		sort(a, aux, mid + 1, hi );
		merge(a, aux, lo, mid, hi);
	}

	private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		
		for (int i = lo; i <= mid; i++) 
			aux[i] = a[i];
	
		for (int i = mid + 1; i <= hi; i++) 
			aux[i] = a[hi - i + mid + 1 ];
	
		int l = lo, r = hi;
		for (int i = lo; i <= hi; i++) 
			if(aux[l] < aux[r])		a[i] = aux[l++];
			else 					a[i] = aux[r--];
	}
	
}
