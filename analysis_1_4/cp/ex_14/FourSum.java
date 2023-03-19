package analysis_1_4.cp.ex_14;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class FourSum {

	private FourSum () { }
	
	private static void printAll(int[] a ) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				for (int k = j + 1; k < a.length; k++) {
					for (int d = k + 1; d < a.length; d++) {
						if(a[i] + a[j] + a[k] + a[d] == 0)
							StdOut.println(a[i] + " " + a[j] + " " + a[k] + " " + a[d]);
					}
				}
			}
		}
	}
	
	private static int count(int[] a ) {
		int n = a.length;
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					for (int d = k + 1; d < n; d++) {
						if(a[i] + a[j] + a[k] + a[d] == 0)
							StdOut.println(a[i] + " " + a[j] + " " + a[k] + " " + a[d]);
					}
				}
			}
		}
		
		return count;
	}
	
	
	public static void main(String[] args)  {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    }
}
