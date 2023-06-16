package analysis_1_4.webex.ex_1;

import java.util.Arrays;

/** 
 *  Let f be a monotonically increasing function with f(0) < 0 and f(N) > 0. 
 *  Find the smallest integer i such that f(i) > 0. 
 *  Devise an algorithm that makes O(log N) calls to f().
 */
  public class ex1 {
    public static void main(String[] args) {
      show(new int[]{-1, 0, 1, 2, 3, 4}, 1);
      show(new int[]{0, 1, 2, 3, 4}, 1);
      show(new int[]{-1, 0, 1}, 1);

      show(new int[]{}, -1);
      show(new int[]{0}, -1);
      show(new int[]{1}, -1);
      show(new int[]{-1, 1}, -1);

    }

    public static void show(int[] arr, int r) {
    	int a = f(arr);
    	System.out.println(( a == r) + " a: " + a + " e: " + r + " " + Arrays.toString(arr));

    }

  public static int f(int[] arr) {
	  if(arr.length == 0) return -1;

    int low = 0, high = arr.length; 
    int mid;

    while(low <= high) {
      mid = low + (high - low) / 2 ; 

      if(arr[mid] == 0) 
        return mid + 1 < arr.length ? arr[mid + 1] : -1;
      else if(arr[mid] > 0) 
        high = mid - 1;
      else 
        low = mid + 1;
    }

    return -1;
  }


}
