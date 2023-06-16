

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		if(n <= 0) return;
		
		RandomizedQueue<String> d = new RandomizedQueue<>();

		while(!StdIn.isEmpty()) {
			String s = StdIn.readString();
			d.enqueue(s);
		}
		
		while(d.size() != n)
			d.dequeue();
		
		for (String string : d) {
			System.out.println(string);
		}
	}
}
