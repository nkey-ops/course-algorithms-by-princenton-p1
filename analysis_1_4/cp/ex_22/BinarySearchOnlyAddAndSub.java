package analysis_1_4.cp.ex_22;

import java.util.Arrays;

public class BinarySearchOnlyAddAndSub {
	public static void main(String[] args) {
		
		int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};
		
		for (int i = 0; i < arr.length; i++) {
			show(arr, i, true);
		}
		show(arr, 10, false);
		show(arr, -1, false);
		show(new int[] {1}, 1, true);
		show(new int[] {1}, -1, false);
	
	}
	
	private static void show(int[] arr, int v, boolean r) {
		System.out.printf("Expected %s, actual %s contains %s in %s\n",
				r, contains(arr, v), v,  Arrays.toString(arr));
	}

	private static boolean contains(int[] arr, int v) {
		if (arr.length == 0)
			return false;

		int low = 0, high = 1;
		int mid = 0;
		boolean side = true;
		
		int tmp;
		while (low <= high) {
			tmp = high;
			high = high + low;
			low = tmp;

			mid = side ? mid + low : mid - low;
			mid = mid < 0 ?  0 : mid >= arr.length ? arr.length - 1 : mid;
			
			if (arr[mid] == v)
				return true;
			if(arr[mid] < v && !side) {
				low = 0; high = 1;
				side = true;
			}else if (arr[mid] > v && side) {
				low = 0; high = 1;
				side = false;
			}
		}

		return false;
	}
}
