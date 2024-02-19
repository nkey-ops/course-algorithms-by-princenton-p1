package elementary_sorts_2_1.webex.ex_4;

import java.util.Arrays;

import utils.Utils;

/**
 * <pre> 
 * Optimal oblivious sorting (challenging).
 * Find an optimal sorting network for 6, 7, and 8 inputs, using 12, 16, and 19 if statements 
 * of the form in the previous problem, respectively. 
 * </pre>
 */
public class OptimalObliviousSortingChallenge {

  public static void main(String[] args) {
   for (byte[] arr : Utils.permutations(6)) {
     System.out.print(Arrays.toString(arr) + " "); 
     sort(arr[0],arr[1],arr[2], arr[3], arr[4], arr[5]);
   } 
  }

  public static void sort(int a, int b, int c, int d, int e, int f) {
    int tmp;

    if(a > b) {tmp = a; a = b; b = tmp;} 
    if(c > d) {tmp = c; c = d; d = tmp;}
    if(e > f) {tmp = e; e = f; f = tmp;}


    if(c > e) {tmp = c; c = e; e = tmp;}
    if(a > c) {tmp = a; a = c; c = tmp;}

    //a <<
    if(b > d) {tmp = b; b = d; d = tmp;}
    if(d > f) {tmp = d; d = f; f = tmp;}

    //f >>
 
    if(b > c) {tmp = b; b = c; c = tmp;}
    if(d > e) {tmp = d; d = e; e = tmp;}

    if(c > e) {tmp = c; c = e; e = tmp;}
    if(b > d) {tmp = b; b = d; d = tmp;}

    if(c > d) {tmp = c; c = d; d = tmp;}


    assert a <= b && b <= c && c <= d && d <= e && e <= f;
    System.out.printf("%s %s %s %s %s %s" + System.lineSeparator(), a, b, c, d, e, f);
  }
}
