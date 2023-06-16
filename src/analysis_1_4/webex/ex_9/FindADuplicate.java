package analysis_1_4.webex.ex_9;

import java.util.Arrays;

public class FindADuplicate {
	public static void main(String[] args) {
		show(new int[] {5, 1, 2, 3, 2, 0}, 2);
		show(new int[] {1, 2, 3, 0}, -1);
		show(new int[] {}, -1);
	}
    public static void show(int[] arr, int r) {
    	int a = containsDuplicate(arr);
    	System.out.println(
    			" a: " + a + 
    			" e: " + r + 
    			" arr" + Arrays.toString(arr));

    }
	
	public static int containsDuplicate(int[] arr) {
		boolean[] r = new boolean[arr.length];
		
		for (int i = 0; i < r.length; i++) {
			if(r[arr[i]]) return arr[i];
			else {
				r[arr[i]] = true;
			}
			
		}
		return -1;
	}
}
