package analysis_1_4.intquest;

public class BitonicSearch {
	public static void main(String[] args) {
		int[] arr = new int[] { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 };
		
		System.out.println("Expected true");
		for (int i : arr) {
			System.out.println("Is " + i + " present " + contains3lgN(arr, i));
		}
		
		System.out.println("Expected false");
		System.out.println("Is " + 30 + " present " + contains3lgN(arr, 30));
		System.out.println("Is " + 46 + " present " + contains3lgN(arr, 46));
		System.out.println("Is " + 31 + " present " + contains3lgN(arr, 31));
		System.out.println("Is " + 91 + " present " + contains3lgN(arr, 91));
	}

//	private static boolean contains2lgN(int[] a, int v) {
//		int high = a.length - 2;
//		int low = 0,mid = high;
//
//		boolean isLeftWing = true;
//
//		while (low <= high) {
//
//			if (a[mid] == v)
//				return true;
//
//			if (isLeftWing ? v > a[mid] : v < a[mid])
//				low = mid + 1;
//			else
//				high = mid - 1;
//
//			// v was't found in increasing side go to the decreasing
//			if (low > high && isLeftWing) {
//				low = high + 1;
//				high = a.length - 1;
//				isLeftWing = false;
//			}
//
//			mid = low + (high - low) / 2;
//
//		}
//
//		return false;
//	}




	/**
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
