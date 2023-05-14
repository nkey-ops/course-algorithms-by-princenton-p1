package analysis_1_4.intquest;

import java.util.Arrays;

public class BitonicSearch {
	public static void main(String[] args) {
		int l = Integer.parseInt(args[0]);
	
		int[] arr  = new int[l];

		for (int i = 0, d = 0; i < l / 2; i++, d +=2) 
			arr[i] = d;	
		for (int i = l - 1, d = 1; i > l / 2 - 1; i--, d+=2) 
			arr[i] = d;	

		
		System.out.println(Arrays.toString(arr));

		for (int j = 0; j < arr.length; j++) 
			if(!contains2lgN(arr, arr[j])) 
				throw new RuntimeException("Contains 2lgN didn't find " + arr[j]);

		if(contains2lgN(arr, -1)) 
				throw new RuntimeException("Contains 2lgN found unexisting value");


		for (int j = 0; j < arr.length; j++) 
			if(!contains3lgN(arr, arr[j])) 
				throw new RuntimeException("Contains 3lgN didn't find " + arr[j]);
		
		if(contains3lgN(arr, -1)) 
				throw new RuntimeException("Contains 3lgN found unexisting value");

	
	}

	/**
	 * 
	 * Time  Complexity O(2 lg N)
	 * 
	 * @param a - a bitonic array
	 * @param v - value to be found
	 * @return if the value present
	 */
	public static boolean contains2lgN(int[] a, int v) {
		if (a.length == 0)
			return false;
	
		int l = 0, h = a.length - 1; 
		
		while(l <= h) {
			int mid =  l + (h - l) / 2;
			
			if(a[mid] == v) return true;
			else if(a[mid] < a[mid + 1] && a[mid] < v) {
				l = mid + 1;
			} else if( a[mid] >  a[mid + 1] && a[mid] < v) {
				h = mid - 1;
			}else {
				return ascBinarySearch(a, v, l, mid - 1) || 
						descBinarySearch(a, v, h, mid + 1);
			}
		}
		
		return false;
	}
	
	private static boolean descBinarySearch(int[] a, int v, int l, int h) {
		if(h < 0 || l >= a.length ) 
			throw new IllegalArgumentException();
			
		while(h <= l) {
			int mid =  h + (l - h) / 2;
			
			if(a[mid] < v) 
				l = mid - 1;
			else if(a[mid] > v) 
				h = mid + 1;
			else 
				return true;
		}

	return false;
}

	private static boolean ascBinarySearch(int[] a, int v, int l, int h) {
		if(l < 0 || h >= a.length ) 
			throw new IllegalArgumentException();

		while(l <= h) {
			int mid = l + (h - l) / 2;

			if(a[mid] < v) 
				l = mid + 1;
			else if(a[mid] > v) 
				h = mid - 1;
			else 
				return true;
		}

	return false;
}

	/**
	 * Time  Complexity O(3 lg N)
	 * 
	 * @param a - a bitonic array
	 * @param v - value to be found
	 * @return if the value present
	 */
	public static boolean contains3lgN(int[] a, int v) {
		if (a.length == 0)
			return false;

		int max = peekMaxIndex(a);
		if (max == -1)
			throw new IllegalArgumentException("Array is not bitonic");

		return contains(a, v, max);
	}


	/**
	 * Time Complexity O(2lg n)
	 * @param a
	 * @param v
	 * @param max
	 * @return
	 */
	private static boolean contains(int[] a, int v, int max) {
		if (v > a[max])
			return false;

		int high = a.length - 2;
		int low = 0, mid = max;
		boolean isLeftWing = true;

		while (low <= high) {

			if (a[mid] == v)
				return true;

			if (isLeftWing ? v > a[mid] : v < a[mid])
				low = mid + 1;
			else
				high = mid - 1;

			// v was't found in increasing side go to the decreasing
			if (low > high && isLeftWing) {
				low = max + 1;
				high = a.length - 1;
				isLeftWing = false;
			}

			mid = low + (high - low) / 2;

		}

		return false;
	}


	/**
	 * Time Complexity: O(lg n)
	 * 
	 * @param a
	 * @return
	 */
	private static int peekMaxIndex(int[] a) {
		int low = 1;
		int high = a.length - 2;
		while (low <= high) {
			int mid = low + ((high - low) / 2);

			if (a[mid - 1] < a[mid] && a[mid] > a[mid + 1]) {
				return mid;
			} else if (a[mid] < a[mid + 1]) {
				low = mid + 1;
			} else
				high = mid - 1;
		}

		return -1;
	}
}
