package unionfind_1_5.webex.ex_5;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionPathSplittingUF {
	private int[] data;
	private int count;

	public QuickUnionPathSplittingUF(int n) {
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
		while (data[root] != root) {
			int parent = data[root];
			data[root] = data[parent];
			root = parent;
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
		int n = StdIn.readInt();
		QuickUnionPathSplittingUF uf = new QuickUnionPathSplittingUF(n);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.find(p) == uf.find(q))
				continue;
			uf.union(p, q);

			StdOut.println(p + " " + q);
		}

		System.out.println(uf);
		StdOut.println(uf.count() + " components");
	}

}