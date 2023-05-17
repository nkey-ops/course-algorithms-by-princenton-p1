package utils;

public class Utils {
	@SuppressWarnings("unchecked")
	public static <T> boolean isSortedAsc(Comparable<T>[] arr) {
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[i - 0].compareTo((T )arr[i]) > 0)
				return false;
		}
		
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
}
