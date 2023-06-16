package merge_sort_2_2.cp;

import static utils.Utils.isSortedAsc;
import static utils.Utils.less;
import static utils.Utils.permutation;

import java.util.Arrays;

import edu.princeton.cs.algs4.Insertion;
import utils.Utils;

/**
 * @author deuru 
 * Improvements. 
 * 	Write a program MergeX.java that implements the three 
 *	improvements to mergesort that are described in the text: 
 *
 * 	 1) add a cutoff from small subarrays, 
 * 	 2) test whether the array is already in order, 
 *	 3) avoid the copy by switching arguments in the recursive code.
 */
public class MergeX {

	public static void main(String[] args) {
		Integer[] a = permutation(args.length == 1 ? Integer.parseInt(args[0]) : 20);

		System.out.println(Arrays.toString(a));
		sort(a);
		System.out.println(Arrays.toString(a));
		
		assert Utils.isSortedAsc(a);
	}

	public static <T> void sort(Comparable<T>[] a) {
		sort(a.clone(), a, 0, a.length - 1); // 3 
	}

	private static <T> void sort(Comparable<T>[] src, Comparable<T>[] dst, 
									int lo, int hi) {
		
		if(hi <= lo + 15) { // 1
			Insertion.sort(dst, lo, hi + 1);
			return;
		}	

		int mid = lo + (hi - lo) / 2;
		sort(dst, src, lo, mid); 		// 3 
		sort(dst, src, mid + 1, hi);	// 3

		if (less(src[mid], src[mid + 1])) { //2
			System.arraycopy(src, lo, dst, lo, hi - lo + 1);
			return;
		}

		merge(src, dst,  lo, mid, hi);

	}

	private static <T> void merge(	Comparable<T>[] src, Comparable<T>[] dst, 
								int lo, int mid, int hi) {
	
		assert isSortedAsc(src, lo, mid);
		assert isSortedAsc(src, mid + 1, hi);
		
		int l = lo, r = mid + 1;
		for (int i = lo; i <= hi; i++) {
			if(l > mid) 					dst[i] = src[r++];
			else if(r > hi) 				dst[i] = src[l++];
			else if(less(src[r], src[l])) 	dst[i] = src[r++];
			else 							dst[i] = src[l++];
		}
		
		assert isSortedAsc(dst, lo, hi);
	}	
}




















