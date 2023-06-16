package merge_sort_2_2.cp;

import static utils.Utils.less;

import java.util.Arrays;

import utils.Utils;

/**
 * @author deuru 
 * Index sort. 
 *	 Develop a version of Merge.java that does not rearrange the array, 
 *   but returns an int[] perm such that perm[i] is
 *   the index of the ith smallest entry in the array.
 */
public class MergeIndexSort {
	
	public static void main(String[] args) {
		Integer[] a = Utils.permutation(args.length == 1 ? Integer.parseInt(args[0]) : 10);
		
		System.out.println("Array:      " + Arrays.toString(a));
		int[] per = indexSort(a);
		System.out.println("Permutation: " + Arrays.toString(per));

		assert isIndexSorted(per, a, 0, per.length - 1);
	}
	
	public static <T> int[] indexSort(Comparable<T>[] a) {
		int[] per = new int[a.length];
		for (int i = 0; i < per.length; i++) 
			per[i] = i;

		indexSort(a, new int[a.length], per , 0, a.length - 1);
		return per;
	}


	private static <T> void indexSort(Comparable<T>[] a, int[] aux, 
									int[] per, int lo, int hi) {
		
		if(hi <= lo) return;
		
		int mid = lo + (hi - lo) / 2;
		indexSort(a, aux, per, lo, mid);
		indexSort(a, aux, per, mid + 1, hi);

		merge(a, aux, per, lo, mid, hi);
	}

	private static <T> void merge(Comparable<T>[] a, int[] aux, 
							int[] per, int lo, int mid, int hi) {

		assert isIndexSorted(per, a, lo, mid);
		assert isIndexSorted(per, a, mid + 1, hi);

		for (int i = lo; i <= hi; i++) 
			aux[i] = per[i];

		int l = lo, r = mid + 1;
		for (int i = lo; i <= hi; i++) {
			if(l > mid) 							per[i] = aux[r++];
			else if(r > hi) 						per[i] = aux[l++];
			else if(less(a[aux[r]], a[aux[l]])) 	per[i] = aux[r++]; 
			else 									per[i] = aux[l++];
		}

		assert isIndexSorted(per, a, lo,  hi);
	}
	
	private static <T> boolean isIndexSorted(int[] per, Comparable<T>[] a, int lo, int hi) {
		if(per.length != a.length || lo < 0 || hi >= a.length) 
			throw new IllegalArgumentException();
		
		for (int i = lo + 1; i <= hi; i++) 
			if(less(a[per[i]], a[per[i - 1]])) {
				return false;
			}
			
		return true;
	}
}






















