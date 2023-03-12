package unionfind_1_5.intquest.ex_2;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFindWithSpecificCanonicalElement {
	private int[] data;
	private int[] size;
	private int count;
	private int[] max;
	
	public UnionFindWithSpecificCanonicalElement(int n) {
		if (n < 0)
			throw new IllegalArgumentException("N cannot be below zero");

		count = n;
		data = new int[n];
		size = new int[n];
		max = new int[n];
		
		for (int i = 0; i < n; i++) {
			data[i] = i;
			size[i] = 1;
			max[i] = i;
		}
	}

	public int find(int p) {
		validate(p);

		int root = p;
		while (data[root] != root)
			root = data[root];

		return max[root];
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

		if (size[pR] > size[qR]) {
			data[qR] = pR;
			size[pR] += size[qR];
		} else {
			data[pR] = qR;
			size[qR] += size[pR];
		}
		
		max[pR] = max[qR] = StrictMath.max(max[pR], max[qR]);

		count--;
	}

	@Override
	public String toString() {
		return Arrays.toString(data);
	}

	public String toStringMax() {
		return Arrays.toString(max);
	}

	private void validate(int p) {
		if (p < 0 || p >= data.length)
			throw new IllegalArgumentException("p cannot be below zero or higher than " + (data.length - 1));
	}

	public static void main(String[] args) {
		int n = StdIn.readInt();
		
		UnionFindWithSpecificCanonicalElement uf = 
				new UnionFindWithSpecificCanonicalElement(n);
		
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.find(p) == uf.find(q))
				continue;
			uf.union(p, q);

			StdOut.println(p + " " + q);
			System.out.println(uf);
			System.out.println(uf.toStringMax());
		}

		StdOut.println(uf.count() + " components");
	}

}