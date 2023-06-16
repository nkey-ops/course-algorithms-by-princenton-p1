package analysis_1_4.webex.ex_4;

public class Identity {
	public static void main(String[] args) {
		int[] arr = new int[] { -1, 0, 1, 3, 5, 6, 7 };
		System.out.println(idendity(arr) + " exp 3");

		int[] arr1 = new int[] { 0, 2, 3, 4, 5, 6, 7 };
		System.out.println(idendity(arr1) + " exp 0");
		
		int[] arr2 = new int[] { -1, 0, 1, 2, 3, 4, 6 };
		System.out.println(idendity(arr2) + " exp 6");

		int[] arr3 = new int[] { -1, 0, 1, 2, 3, 5, 7 };
		System.out.println(idendity(arr3) + " exp 5");
		
		int[] arr4 = new int[] { -1, 1, 3, 4, 5, 6, 7 };
		System.out.println(idendity(arr4) + " exp 1");

	}	
	public static int idendity(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			
			if(arr[mid] == mid)
				return mid;
			else if (arr[mid] > mid)
				high = mid - 1;
			else 
				low = mid + 1;
		}  

		return -1 ;
	}

}
