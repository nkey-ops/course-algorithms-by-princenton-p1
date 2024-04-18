package merge_sort_2_2;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;
import utils.Utils;

/**
 * Test2
 */
public class Test2 {
  public static void main(String[] args) {


    sort(StdRandom.permutation(3));  
    System.out.println();
    sort(StdRandom.permutation(55));  
  }

  public static void sort(int[] arr) {
    int[] aux = new int[arr.length];
    System.out.println(Arrays.toString(arr));


    for (int i = 1; i < arr.length; i*=2) {
      for (int lo = 0; lo < arr.length - i; lo+= i * 2) {
        merge(arr, aux, lo , lo + i - 1, Math.min(lo + i * 2 - 1, arr.length - 1));  
      }
    } 

  } 


  public static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
   if( lo < 0 || lo >= arr.length || mid < 0 || mid >= arr.length || hi < 0 || hi >= arr.length) 
     throw new IllegalArgumentException();
   
    assert Utils.isSortedAsc(arr, lo, mid);
    assert Utils.isSortedAsc(arr, mid + 1, hi);

    for (int i = lo; i <= hi; i++) {
      aux[i] = arr[i];
    }

    int l = lo, r = mid + 1;

    for (int i = lo; i <= hi; i++) {

     if(l > mid)              arr[i] = aux[r++];
     else if(r > hi)          arr[i] = aux[l++];
     else if(aux[l] < aux[r]) arr[i] = aux[l++];
     else                     arr[i] = aux[r++];

    }
    
    System.out.println(Arrays.toString(arr));
    assert Utils.isSortedAsc(arr, lo, hi);
  }

}
