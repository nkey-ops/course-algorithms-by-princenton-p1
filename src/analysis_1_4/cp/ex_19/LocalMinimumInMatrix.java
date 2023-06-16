package analysis_1_4.cp.ex_19;

import java.util.Arrays;

public class LocalMinimumInMatrix {
	public static void main(String[] args) {
		
		show(new int[][] {
			{0, -1, 5},
			{1, 2, 3},
			{1, 2, 3}
		}, new int[] {0, 1});

		show(new int[][] {
			{4, 6, 5},
			{1, 0, 3},
			{7, 2, 9}
		}, new int[] {1, 1});
		
		show(new int[][] {
			{5, 6, 7},
			{2, 3, 4},
			{0, -1, 1}
		}, new int[] {2, 1});
		
		
	}
	
	public static void show(int[][] arr, int[] e) {
		int[] a = getLocalMinimum(arr);
		System.out.println(Arrays.equals(a, e) + 
				" a:" + Arrays.toString(a) + 
				" e:" + Arrays.toString(e) + 
				" " +Arrays.deepToString(arr));
	}
	
	public static int[] getLocalMinimum(int[][] arr) {
		int low = 0;
		int high = arr.length - 1;

		int mid;
		while(low <= high) {
			mid = low + (high - low) / 2;
		
			int x = getLowest(arr[mid]);
			
			
			if(isLocalMinimum(arr, mid, x))
				return new int[] {mid, x};
			else if(mid - 1 == -1)
				break;
			else if(arr[mid - 1][x] < arr[mid][x])
				high = mid - 1;
			else
				low = mid + 1;
				
		}
		
		
		return new int[0];
	}

	private static boolean isLocalMinimum(int[][] arr, int y, int x) {
		//@// @formatter:off
		int[] yx = new int[] {   -1, 0,  
							 0, -1 ,   0, 1,
								  1, 0};
		// @formatter:on

		for (int i = 0; i < yx.length; i += 2) {
			int y2 = y + yx[i];
			int x2 = x + yx[1 + 1];
			
			if( y2 >= 0 && y2 < arr.length && x2 >= 0 && x2 < arr.length 
					&& arr[y2][x2] < arr[y][x])
				return false;
		}
		
		return true;
	}
	
	private static int getLowest(int[] arr) {
		if (arr.length == 0) 
			throw new IllegalArgumentException();;
		
		int iL = 0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[iL])
				iL = i;
		}
		
		return iL;
	}
}
