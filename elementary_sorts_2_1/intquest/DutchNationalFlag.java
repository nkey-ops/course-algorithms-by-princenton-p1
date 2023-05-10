package elementary_sorts_2_1.intquest;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Admin
 * Dutch national flag. 
 * Given an array of n buckets, 
 *  each containing a red, white, or blue pebble, sort them by color. 
 * The allowed operations are: 
 * 
 * swap(i,j):  swap the pebble in bucket i with the pebble in bucket j.
 * color(i): determine the color of the pebble in bucket i. 
 * 
 * The performance requirements are as follows: n calls to color().
 * At most n calls to swap().
 * Constant extra space.
 */
public class DutchNationalFlag {
	private int[] buckets;
	
	public static void main(String[] args) {
		int[] buckets = new int[20];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = StdRandom.uniformInt(1, 4);
		}

		DutchNationalFlag d =  new DutchNationalFlag();
		d.buckets = buckets;

		StdOut.println(Arrays.toString(d.buckets));
		d.sort();
		StdOut.println(Arrays.toString(d.buckets));
	}

	
	/**
	 * Sorts {1, 2, 3} integers using 3-way-partitioning
	 *  
	 * Time Complexity O(N)
	 * Auxiliary Space O(1)
	 * 
	 * @param a
	 */
	public void sort() {
	//		index of checked colors
		int lo = 0, hi = buckets.length - 1;

		for (int i = 0; i <= hi; i++) {
			int v = color(i); 
			if(v == 1) swap(i, lo++);
			else if(v == 3) swap(i--, hi--);
		}	
	}

	private int color(int i) { return buckets[i] ;}

	private void swap(int i, int j) {
		int tmp = buckets[i]; 
		buckets[i] = buckets[j];
		buckets[j] = tmp;
	}
}
