package merge_sort_2_2.webex.ex9;

import static java.lang.Integer.parseInt;
import static utils.Utils.permutation;

import java.util.Arrays;

import edu.princeton.cs.algs4.Merge;
import utils.Utils;

/**
 * @author deuru
 *  Merging three arrays. 
 *  Given three sorted arrays a[], b[], and c[], each of size N, 
 *	  design an algorithm to merge them into a new sorted array d[] 
 *	  using at most ~ 6 N compares in the worst case 
 *	 (or, even better, ~ 5 N compares). *
 */
public class MergingThreeArrays {

	
	public static void main(String[] args) {
		int n3  = args.length == 1 ? parseInt(args[0]) : 9;

		Integer[] arr = permutation(n3 - (n3 % 3));

		int n =  arr.length / 3;
		Integer[] a = new Integer[n], 
				  b = new Integer[n], 
				  c = new Integer[n];

		for (int i = 0, j = 0; i < arr.length; i++, j++) {
			if( i < n) 				a[j] = arr[i];
			else if(i < n * 2)      b[j - n] = arr[i];
			else 					c[j - (n * 2)] = arr[i];
		}
	
		Merge.sort(a);
		Merge.sort(b);
		Merge.sort(c);

		System.out.printf("Merging: \n%s\n%s\n%s\n", 
					Arrays.toString(a), Arrays.toString(b), Arrays.toString(c));
		System.out.println("Merge: \n" + Arrays.toString(merge(a, b, c)));
		 
	}

	private static <T> Comparable<T>[] merge(Comparable<T>[] a, 
									Comparable<T>[] b, Comparable<T>[] c) {

		return merge(merge(a, b), c); 
	}

	@SuppressWarnings("unchecked")
	private static <T> Comparable<T>[] merge(Comparable<T>[] a, Comparable<T>[] b) {
		assert Utils.isSortedAsc(a);
		assert Utils.isSortedAsc(b);
		
		Comparable<T>[] c = new Comparable[a.length + b.length];
		
		int l = 0, r = 0; 
		for (int i = 0; i < c.length; i++) {
			if(l >= a.length)	 		     c[i] = b[r++];
			else if(r >= b.length)	 		 c[i] = a[l++];
			else if(Utils.less(a[l], b[r]))  c[i] = a[l++];
			else 							 c[i] = b[r++];	
		}
		
		assert Utils.isSortedAsc(c);

		return c;
	}



	
	
	
	
	
	
	
	
	
}
