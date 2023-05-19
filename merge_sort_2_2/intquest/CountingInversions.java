package merge_sort_2_2.intquest;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;
import utils.Utils;

/**
 * @author deuru
 * Counting inversions. 
 * An inversion in an array a[ ]a[] is a pair of 
 *  entries a[i]a[i] and a[j]a[j] such that i<ji<j but a[i]>a[j]a[i]>a[j]. 
 * Given an array, design a linearithmic algorithm
 * 	to count the number of inversions.
 * 
 * Hint: count while mergesorting. 
 */
public class CountingInversions {

	public static void main(String[] args) {

		int[] a = StdRandom.permutation(args.length == 1 ? Integer.parseInt(args[0]) : 10);
		System.out.println(Arrays.toString(a));
		System.out.println("Number of inversion is " + count(a));
		
		assert Utils.isSortedAsc(a);

	}
	
	public static int count(int[] a) {
		return sort(a, new int[a.length], 0, a.length - 1);
	}
	
	
	private static int sort(int[] a, int[] aux, int lo, int hi) {
		if(lo >= hi) return 0;

		int count = 0 ;
		
		int mid = lo + (hi - lo) / 2;
		count += sort(a, aux, lo, mid);
		count += sort(a, aux, mid + 1, hi);
		count += merge(a, aux, lo, mid, hi);

		return count;
	}


	private static int merge(int[] a, int[] aux, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) 
			aux[i] = a[i];
			
		int l = lo, r = mid + 1, count = 0;

		for (int i = lo; i <= hi; i++) {
			if	   (l > mid) 			a[i] = aux[r++];
			else if(r > hi) 			a[i] = aux[l++];
			else if(aux[l] < aux[r])	a[i] = aux[l++]; 	
			else 					{
				a[i] = aux[r++];
				count += mid - l + 1;
			}
		}

		return count;
	}
}
