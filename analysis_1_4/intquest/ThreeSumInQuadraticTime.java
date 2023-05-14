package analysis_1_4.intquest;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.ThreeSumFast;

/**
 * @author deuru
 * 3-SUM in quadratic time. 
 * Design an algorithm for the 3-SUM problem that takes time proportional to n^2 
 * in the worst case. You may assume that you can sort the 
 * n integers in time proportional to n^2 or better.
 */
public class ThreeSumInQuadraticTime {
	
	public static void main(String[] args) {
		int l  = Integer.parseInt(args[0]);

		int[] arr = new int[l * 2];
		for (int i = 0 ; i < l * 2 ; i++) {
			arr[i] = i - l;
		}
		
		StdRandom.shuffle(arr);
		
		int[] arr2 = Arrays.copyOf(arr, arr.length); 
		int result = count(arr);
		
		System.out.printf("The result is %s for array \n%s is ", 
				result, Arrays.toString(arr));
		
		assert result == ThreeSumFast.count(arr2);
	}


	public static int count(int[] arr) {
		if(arr.length < 3) return 0;
		
		Arrays.sort(arr);

		int count = 0;

		for (int x = 0; x < arr.length; x++) {  // O(n)
			int i = x + 1, j = arr.length - 1;
					
			while(i < j) { //O(n)
				System.out.println(i + " " + j);
					
				if (arr[i] + arr[j]  > -arr[x] ) 
					j--;
				else if(arr[i] + arr[j] <  -arr[x]) 
					i++;
				else {
					count++;
					j--;
					i++;
				}
				
			}
		}

		return count;
	}
}
