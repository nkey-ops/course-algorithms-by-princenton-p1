package analysis_1_4.webex.ex_7;

import java.util.Arrays;

public class SecondSmallest {
	public static void main(String[] args) {
		show(new int[] {5, 1, 4, 6, 2, 0}, new int[] {0, 1});
		show(new int[] {1, 1, 1, 1}, new int[] {1});
		show(new int[] {}, new int[] {});
	}
    public static void show(int[] arr, int[] r) {
    	int[] a = secondSmallest(arr);
    	System.out.println(
    			" a: " + Arrays.toString(a) + 
    			" e: " + Arrays.toString(r) + 
    			" arr" + Arrays.toString(arr));

    }

	
	public static int[] secondSmallest(int[] arr) {
		if(arr.length == 0) return new int[] {};
		
		Integer s1 = null , s2 = null;
		for (int i = 0; i < arr.length; i++) {
			if(s1 == null || arr[i] < s1) {
				s2 = s1;
				s1 = arr[i];
			}
		}

		return s2 == null ?  new int[] {s1} : new int[] {s1, s2} ;
	}
}
