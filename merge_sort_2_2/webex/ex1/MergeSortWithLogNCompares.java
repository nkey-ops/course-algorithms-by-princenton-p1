package merge_sort_2_2.webex.ex1;

import static edu.princeton.cs.algs4.StdRandom.permutation;
import static java.lang.Integer.parseInt;

import java.util.Arrays;

import utils.Utils;

/**
 * @author dueru
 * Merge with at most log N compares per item. 
 * Design a merging algorithm such that 
 * 	each item is compared at most a logarithmic number of times. 
 * (In the standard merging algorithm, 
 * 	an item can be compared N/2 times when merging two subarrays of size N/2.) 
 */
public class MergeSortWithLogNCompares {
	public static void main(String[] args) {
		int[] a = permutation(args.length == 1 ? parseInt(args[0]) : 10);

		System.out.println(Arrays.toString(a));
		sort(a);
		System.out.println(Arrays.toString(a));
}
	
	public static void sort(int[] arr) {
		sort(arr, new int[arr.length],  0, arr.length - 1);
	}
	
	private static void sort(int[] arr, int[] aux, int lo, int hi) {
		if(lo >= hi) return;

		int mid = lo + (hi - lo) / 2;
		sort(arr, aux, lo, mid);
		sort(arr, aux, mid + 1, hi);
		merge(arr, aux, lo, mid, hi);

		assert Utils.isSortedAsc(arr, lo, hi);

	}

	private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		assert Utils.isSortedAsc(a, lo, mid); 
		assert Utils.isSortedAsc(a, mid + 1, hi); 
	
		for (int i = lo; i <= hi; i++) 
			aux[i] = a[i];

		 int l = lo, r = mid+1;
		 for (int k = lo; k <= hi; k++) {
			if      (l > mid)              a[k] = aux[r++];
			else if (r > hi)               a[k] = aux[l++];
			else {
			int ri = getLesserThan(aux, aux[l], r, hi);

			if(ri != -1) {
				for (int i = r; i <= ri; i++) 
					a[k++] = aux[i];
				r = ri + 1;
			}

			a[k] = aux[l++];
			}
		 }	
	        
	    assert Utils.isSortedAsc(a, lo, hi);
	}

	
	private static int getLesserThan(int[] a, int key, int lo, int hi) {
		if(a != null && lo < 0 && hi >= a.length) 
			throw new IllegalArgumentException(); 

		assert Utils.isSortedAsc(a, lo, hi) ;

		int i = 1;
		while(lo + i <= hi && a[i + lo] < key )
			i*=2;
		
		hi = lo + i > hi ? hi : lo + i;; 

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) 
            	if(lo > mid - 1) return mid - 1; 
            	else hi = mid - 1;
            else 
            	if(mid + 1 > hi) return mid;
            	else lo = mid + 1;
        }

        return -1;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
