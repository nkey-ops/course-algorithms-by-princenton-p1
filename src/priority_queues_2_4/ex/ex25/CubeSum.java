package priority_queues_2_4.ex.ex25;

import java.util.Arrays;
import java.util.stream.Stream;

import edu.princeton.cs.algs4.MinPQ;

/**
 * Computational number theory.
 *
 * Write a program CubeSum.java that prints out all
 * integers of the form a^3+b^3 where a and b are integers between 0 and N 
 * in sorted order, without using excessive space. 
 *
 * That is, instead of computing an array of the n^2 sums and sorting them,
 * build a minimum-oriented priority queue, 
 * initially containing (0^3,0,0),(1^3,1,1),(2^3,2,2),…,(n^3,n,n).
 *
 * Then, while the priority queue is nonempty, remove the smallest item
 * i3+j3,i,j), print it, and then, 
 * if j<n, insert the item (i3+(j+1)3,i,j+1).
 *
 * Use this program to find all distinct integers a,b,c, 
 * and d between 0 and 106
 * such that a3+b3 = c3+d3, such as 1729=93+103=13+123
 */

 public class CubeSum {
       final int sum;
       final int i;
       final int j;

       public CubeSum(int sum, int i, int j) {
           this.sum = sum;
           this.i = i;
           this.j = j;
       }

       @Override
        public String toString() {
            return sum + " = " + i + "^3 + " + j + "^3";
        }

        
    public static void main(String[] args) {
        int n = 13;
        CubeSum[] sumBrute = sumBrute(n);
        CubeSum[] sum = sum(n);

        Stream.of(sumBrute).forEach(System.out::println);
        System.out.println();
        Stream.of(sum).forEach(System.out::println);

        assert Arrays.compare(sumBrute, sum, 
                (a, b) -> Integer.compare(a.sum, b.sum)) == 0;

    }

    /**
     * populate with n*3 times 
     *  O n 
     *  O n log n 
     *
     * Time Complexity: O 2N log n
     * Space Comlexity: O n 
     */
    private static CubeSum[] sum(int n) {
        MinPQ<CubeSum> heap = new MinPQ<>(
                (a, b) -> Integer.compare(a.sum, b.sum));

        CubeSum[] arr = new CubeSum[n * n];
        int in = 0;

        for (int i = 0; i < n; i++) {
            heap.insert(
                    new CubeSum((int) Math.pow(i, 3), i, 0)); 
        }
        

        while(!heap.isEmpty()) {
           CubeSum num =  heap.delMin();
           arr[in++] = num; 

           if(num.j < n - 1) heap.insert(
                   new CubeSum(
                       (int) (Math.pow(num.i, 3) + Math.pow(num.j + 1, 3)),
                       num.i, num.j + 1));
        }

        return arr;
    }


    /**
     * O 3n log n
     *
     */
    public static CubeSum[] sumBrute(int n ) {
        CubeSum[] arr = new CubeSum[n * n];

        for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
                arr[i * n + j] = 
                    new CubeSum( 
                        (int) (Math.pow(i, 3) + Math.pow(j, 3)),
                              i, j); 
           }   
        } 

        Arrays.sort(arr, 
                (a, b) -> Integer.compare(a.sum, b.sum));
        
        return arr;
    }

}
