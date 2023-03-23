package analysis_1_4.webex.ex_8;

import java.util.Arrays;

public class FindADuplicate {
	public static void main(String[] args) {
		show(new int[] {5, 1, 2, 3, 2, 0}, true);
		show(new int[] {1, 2, 3, 0}, false);
		show(new int[] {}, false);
	}
    public static void show(int[] arr, boolean r) {
    	boolean a = containsDuplicate(arr);
    	System.out.println(
    			" a: " + a + 
    			" e: " + r + 
    			" arr" + Arrays.toString(arr));

    }
	
	public static boolean containsDuplicate(int[] arr) {
		boolean[] r = new boolean[arr.length];
		
		for (int i = 0; i < r.length; i++) {
			if(r[arr[i]]) return true;
			else {
				r[arr[i]] = true;
			}
			
		}
		return false;
	}
}
