package utils;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class Utils {

	public static <T> boolean isSortedAsc(Comparable<T>[] arr) {
		for (int i = 1; i < arr.length; i++) 
			if(less(arr[i], arr[i - 1])) return false;
		
		return true;
	}

	public static <T> boolean isSortedAsc(Comparable<T>[] arr, int lo, int hi) {
		if(lo < 0 || hi >= arr.length 
				|| lo > hi) throw new IllegalArgumentException();
		
		for (int i = lo + 1; i <= hi; i++) 
			if(less(arr[i], arr[i - 1])) return false;
		
		return true;
	}

	public static <T> boolean isSortedAsc(int[] arr) {
		return isSortedAsc(arr, 0, arr.length - 1);
	}

	public static <T> boolean isSortedAsc(int[] arr, int lo, int hi) {
		if(lo < 0 || hi >= arr.length 
				|| lo > hi) throw new IllegalArgumentException();
		
		for (int i = lo + 1; i <= hi; i++) {
			if(arr[i - 1] > arr[i])
				return false;
		}
		
		return true;
	}

	@SuppressWarnings("unchecked")
	public static <T> boolean less(Comparable<T> v, Comparable<T> w) {
		return v.compareTo((T) w) < 0;
	}
	 
	public static Integer[] permutation(int i) {
		 int[] p =	StdRandom.permutation(i, i);

		 return Arrays.stream(p).boxed().toArray( Integer[]::new ); 
	}

	public static Integer[] permutation(int i, int k) {
		 int[] p =	StdRandom.permutation(i, k);

		 return Arrays.stream(p).boxed().toArray( Integer[]::new ); 
	}

	

}
