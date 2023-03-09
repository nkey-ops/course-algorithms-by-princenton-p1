package unionfind_1_5.cp.ex_12;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionWithPathCompression {
		private int[] data;
		private int count;
		
		public QuickUnionWithPathCompression (int n) {
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
		
		public int find2(int p) {
			validate(p);
			
			if(data[p] == p) return p;
			
			int r = find2(p);
				data[p] = r;
			
			return r;
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

			if(connected(p, q)) return;
			
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
	        QuickUnionWithPathCompression uf = new QuickUnionWithPathCompression(n);
	        while (!StdIn.isEmpty()) {
	            int p = StdIn.readInt();
	            int q = StdIn.readInt();
	            if (uf.find(p) == uf.find(q)) continue;
	            uf.union(p, q);

	            StdOut.println(p + " " + q);
	        }

	        StdOut.println(uf.count() + " components");
	        System.out.println(uf);
		}
		
}