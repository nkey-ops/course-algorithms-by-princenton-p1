
import java.util.*;

/**
 * 
 * Floor and ceiling. Given a set of comparable elements, the ceiling of x is
 * the smallest element in the set greater than or equal to x, and the floor is
 * the largest element less than or equal to x. Suppose you have an array of N
 * items in ascending order.
 *
 * Give an O(log N) algorithm to find the floor and ceiling of x.
 *
 */
public class FloorAndCeiling {
	public static void main(String[] arg) {
		int[] arr = new int[] { 0, 1, 2, 3, 5, 6, 7 };
		System.out.println(Arrays.toString(floorAndCeiling(arr, 4)) + " exp [3, 5]");

		System.out.println(Arrays.toString(floorAndCeiling(arr, 0)) + " exp []");
		System.out.println(Arrays.toString(floorAndCeiling(arr, 7)) + " exp []");
		System.out.println(Arrays.toString(floorAndCeiling(arr, 10)) + " exp []");
	}

	public static int[] floorAndCeiling(int[] arr, int x) {
		int low = 0, high = arr.length - 1;
		int mid;
		while (low <= high) {
			mid = low + (high - low) / 2;

			if ((mid != 0 && arr[mid] > x && arr[mid - 1] < x) || 
					(mid != arr.length - 1 && arr[mid] < x && arr[mid + 1] > x)) {

				int f = arr[mid] > x ? arr[mid - 1] : arr[mid];
				int c = arr[mid] > x ? arr[mid] : arr[mid + 1];

				return new int[] { f, c };
			} else if (arr[mid] > x)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return new int[] {};
	}
}
