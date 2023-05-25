package merge_sort_2_2.webex.ex3;

import static java.lang.Integer.parseInt;
import static utils.Utils.isSortedAsc;

import java.util.Arrays;

import utils.Utils;

/**
 * @author deuru 
 * 	Given an array a of size 2N with N items in sorted order in positions 0 through N-1, 
 * 	 and an array b of size N with N items in ascending order, 
 * 	 merge the array b into a so that a contains all of the items in ascending order. 
 * 	Use O(1) extra memory. 
 * 
 *  Hint: merge from right to left
 */
public class MergeTwoArrays {
	
	public static void main(String[] args) {
		int n = args.length == 1 ? parseInt(args[0]) : 10;

		int[] a = new int[n * 2];
		int[] b = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = i; 
			b[i] = n - i - 1; 
		}
		
		System.out.println("Array: " + Arrays.toString(a));
		System.out.println("Array: " + Arrays.toString(b));
		
		merge(a, b);

		System.out.println("Array: " + Arrays.toString(a));
		assert isSortedAsc(a);
	}

	private static void merge(int[] a, int[] b) {
		if(a.length != b.length * 2) 
			throw new IllegalArgumentException();

		int n = b.length;
	
		int l = n - 1, r = 0;
		for (int i = n * 2 - 1; i >= 0; i--) {
			System.out.println(i);
			if( l < 0 ) 			a[i] = b[r++];
			else if( r > n - 1 )	a[i] = a[l--];
			else if( a[l] < b[r] ) 	a[i] = b[r++];
			else  					a[i] = a[l--];
		}
	}


	
	
	
	
	
	
	
	
	

}
