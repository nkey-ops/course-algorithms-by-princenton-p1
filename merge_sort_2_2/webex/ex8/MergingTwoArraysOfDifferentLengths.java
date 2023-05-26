package merge_sort_2_2.webex.ex8;

import static java.lang.Integer.parseInt;
import static utils.Utils.isSortedAsc;
import static utils.Utils.less;
import static utils.Utils.permutation;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;
import merge_sort_2_2.cp.MergeX;
import utils.Utils;

/**
 * @author deuru 
 * Merging two arrays of different lengths. 
 * Given two sorted arrays a[] and b[] of sizes M and N where M ≥ N, 
 *	 devise an algorithm to merge them into 
 *	 a new sorted array c[] using ~ N lg M compares. 
 */
public class MergingTwoArraysOfDifferentLengths {

	public static void main(String[] args) {
		Integer[] arr = permutation(args.length == 1 ? parseInt(args[0]) : 10);
		int sep = StdRandom.uniformInt(1, arr.length + 1);
		Integer[] a = new Integer[sep];
		Integer[] b = new Integer[arr.length - sep];
	
		for (int i = 0; i < arr.length; i++) {
			if(i < sep)    			a[i] = arr[i];
			else 				 	b[i - sep] = arr[i];
		}
		MergeX.sort(a);
		MergeX.sort(b);
		

		System.out.printf("Merging: \n%s\n%s\n", Arrays.toString(a), Arrays.toString(b));
		System.out.println("Merged: \n" + Arrays.toString(merge(a,b)));

	}
	
	@SuppressWarnings("unchecked")
	public static <T> Comparable<T>[] merge(
								Comparable<T>[] a, Comparable<T>[] b) {
		if(a.length == b.length) 
			throw new IllegalArgumentException();

		assert(Utils.isSortedAsc(a));
		assert(Utils.isSortedAsc(b));

		Comparable<T>[] ba, sa, 
		ra = new Comparable[a.length + b.length];

		if(a.length > b.length) {
			ba = a; sa = b;
		}else { 
			ba = b; sa = a;
		}
		
		int ib = 0, is = 0;
		for (int i = 0; i < ba.length + sa.length; i++) {
			if(is >= sa.length)  			ra[i] = ba[ib++];	
			else if(ib >= ba.length) 	    ra[i] = ba[is++];	
			else {
				int r = lesserThan(sa[is], ba);
				while (r != -1 && ib <= r) 
					ra[i++] = ba[ib++];
				
				ra[i] = sa[is++];
			}	

		}

		assert(isSortedAsc(ra));
		return ra;
	}

	
	/**
	 * Uses binary search to find index of 
	 *  the BIGGEST value that is LOWER than the key.
	 *  
	 * @param key
	 * @param src
	 * @return index of the BIGGEST value that is LOWER than the key
	 * 			otherwise -1 
	 */
	public static <T> int lesserThan(Comparable<T> key, Comparable<T>[] src) {
		int lo = 0, hi = src.length - 1;

		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if(less(key, src[mid]))  
            	if(lo > mid - 1) return mid - 1; 
            	else hi = mid - 1;
            else 
            	if(mid + 1 > hi) return mid;
            	else lo = mid + 1;
		}
		
		return -1; 
	}

}






























