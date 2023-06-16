package unionfind_1_5.ex;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF {
	private int[] data;
	private int count;
	
	public QuickUnionUF(int n) {
		if (n < 0)
			throw new IllegalArgumentException("N cannot be below zero");
		
		count = n;
		data = new int[n];
		
		for (int i = 0; i < n; i++) {
			data[i] = i;
		}
	}

	public int find(int p) {
		validate(p);
		
		int i = p;
		while(data[i] != i)
			i = data[i];
			
		return i;
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		validate(p);
		validate(q);
		
		return find(p) == find(q);
	}

	public void union(int p, int q) {
		validate(p);
		validate(q);
		
		int pR = find(p);
		int qR = find(q);
		
		data[pR] = qR;
		count--;
	}
	
	private void validate(int p) {
		if (p < 0 || p >= data.length)
			throw new IllegalArgumentException("p cannot be below zero or higher than " + (data.length - 1));
	}

	public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
	
}