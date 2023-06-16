package unionfind_1_5.webex.ex_6;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomQuickUnion {
	private int[] data;
	private int count;

	public RandomQuickUnion(int n) {
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
	
		int root = p;
		while(data[root] != root)
			root =  data[root];

		while(data[p] != p) {
			int tmp = p;
			p = data[p];
			data[tmp] = root;
		}

		return root;
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

		if (connected(p, q))
			return;
		
		int pR = find(p);
		int qR = find(q);

		if(pR > qR)
			data[qR] = pR;
		else
			data[pR] = qR;
		
		count--;
	}

	@Override
	public String toString() {
		
		
		return Arrays.toString(data);
	}

	private void validate(int p) {
		if (p < 0 || p >= data.length)
			throw new IllegalArgumentException("p cannot be below zero or higher than " + (data.length - 1));
	}

	public static void main(String[] args) {
		if(args.length != 1) {
			System.err.printf("Usage [n]\n "
							+ "n - [0, n)");
			System.exit(1);
		}
		
		int n = Integer.parseInt(args[0]);
		RandomQuickUnion uf = new RandomQuickUnion(n);
		
		for (int i = 0; i < n; i++) {
			int p = StdRandom.uniformInt(n);
		
			if (uf.find(i) == uf.find(p))
				continue;
			uf.union(i, p);

			StdOut.println(p + " " + i);
		}

		System.out.println(uf);
		StdOut.println(uf.count() + " components");
	}

}