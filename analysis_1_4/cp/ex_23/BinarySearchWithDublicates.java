package analysis_1_4.cp.ex_23;

public class BinarySearchWithDublicates {
	public static void main(String[] args) {
		System.out.println(
				getMin(new int[] {1, 7, 7, 7, 8, 9, 10}, 7));
		System.out.println(
				getMax(new int[] {1, 7, 7, 7, 8, 9, 10}, 7));
	}
	
	
	public static int getMin(int[] a, int v) {
		if(a.length == 0) return -1;
		
		int r = -1;
		
		int low = 0, high = a.length - 1;
		int mid = -1;
		
		while(low <= high) {
			mid = low + (high - low) / 2;

			if(v == a[mid]) r =  mid;
			
			if(v > a[mid])
				low = mid + 1;
			else 
				high = mid - 1;
		}
	
		return r;
	}

	public static int getMax(int[] a, int v) {
		if(a.length == 0) return -1;
		
		
		int low = 0, high = a.length - 1;
		int r = -1, mid = -1;
		
		while(low <= high) {
			mid = low + (high - low) / 2;
			
			if(v == a[mid]) r =  mid;
			
			if(v >= a[mid])
				low = mid + 1;
			else 
				high = mid - 1;
		}
		
		return r;
	}
}
