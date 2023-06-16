package analysis_1_4.cp.ex_18;

import java.util.Arrays;

public class LocalMinimum {
	public static void main(String[] args) {
		
		int[] a3 = new int[] { 2, 1, 3};
		System.out.println( Arrays.toString(a3) + ((getLocalMinimum(a3)) == 1));

		int[] a4 = new int[] { 9, 6, 3, 14, 5, 7, 4 };
		System.out.println(  Arrays.toString(a4) + " "  + ((getLocalMinimum(a4)) == 2));

		int[] a5 = new int[] { 1, 2, 3 };
		System.out.println( Arrays.toString(a5) + " "  + ((getLocalMinimum(a5)) == 0) );
		
		int[] a6 = new int[] { 1, 2, 3, 4, 5, 7, 6, 8, 9};
		System.out.println(Arrays.toString(a6) + " "  + ((getLocalMinimum(a6)) == 0) );
		
		int[] a7 = new int[]{ 23, 8, 15, 2, 3};
		System.out.println( Arrays.toString(a7) + " " + ((getLocalMinimum( a7 )) == 1) );

		int[] a8 = new int[] { 4, 3, 6, 14, 16, 40};
		System.out.println( Arrays.toString(a8) + " " + ((getLocalMinimum(a8)) == 1) );

		int[] a9 = new int[] { 4, 3, 15, 14, 10, 9, 8};
		System.out.println( Arrays.toString(a9) + " " + ((getLocalMinimum(a9)) == 6) );
		
		int[] a10 = new int[] { 4, 3, 15, 14, 10, 9, 20};
		System.out.println( Arrays.toString(a10) + " " + ((getLocalMinimum(a10)) == 5) );
		
	}

	public static int getLocalMinimum(int[] a) {
		if (a.length == 0)
			return -1;
		if (a.length == 1)
			return 0;

		int low = 0, high = a.length - 1;
		int mid =  - 1;
		while (low <= high) {

			mid = low + (high - low) / 2;

			if ( (mid == 0 && high == low && a[mid] < a[mid + 1] ) 
					|| (mid == a.length - 1 && high == low && a[mid] < a[mid - 1] )
					|| (mid != 0 && a[mid] < a[mid - 1] && a[mid] < a[mid + 1]))
				return mid;

			else if (mid != 0 && a[mid] >= a[mid - 1])
				high = mid - 1;
			else
				low = mid + 1;

		}
	
		return -1;
	}
}
