package merge_sort_2_2.webex.ex7;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import merge_sort_2_2.cp.MergeIndexSort;

/**
 * @author deuru
 * Write a program SecureShuffle.java to read in a 
 * sequence of string from standard input and 
 * securely shuffle them. 
 * 
 * Use the following algorithm: 
 * associate each card with a random real number  between 0 and 1. 
 * Sort the values based on their associated real numbers. 
 * 
 * Use java.security.SecureRandom to generate the random real numbers. 
 * Use Merge.indexSort() to get the random permutation.6
 */
public class SecureShuffle {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String[] strings = StdIn.readAllStrings();

		System.out.println("Secure Shuffling:\n" + Arrays.toString(strings));
		shuffle(strings);
		System.out.println("Secure Shuffled:\n" + Arrays.toString(strings));
		
	}

	@SuppressWarnings("unchecked")
	private static <T> void shuffle(Comparable<T>[] chars) throws NoSuchAlgorithmException {
		int length = chars.length;
		SecureRandom s =  SecureRandom.getInstanceStrong();

		Double[] randomNums = new Double[length];
		Comparable<T>[] charsCopy = new Comparable[length];
		for (int i = 0; i < length; i++) {
			randomNums[i] = s.nextDouble(); 
			charsCopy[i] =  chars[i];
		}
		
		int[] indexes = MergeIndexSort.indexSort(randomNums);
		for (int i = 0; i < length; i++) 
			chars[i] = charsCopy[indexes[i]];
	}
	
}
