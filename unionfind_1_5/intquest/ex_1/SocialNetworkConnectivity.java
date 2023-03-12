package unionfind_1_5.intquest.ex_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SocialNetworkConnectivity {
	private int[] users;
	private int[] size;
	
	private int count;

	public SocialNetworkConnectivity(int n) {
		users = new int[n];
		size = new int[n];
		count = n;
		for (int i = 0; i < n; i++) {
			users[i] = i;
			size[i] = 1;
		}
	}

	public int find(int p) {
		while (users[p] != p) {
			p = users[p];
		}
		
		return p;
	}

	public boolean union(int f1, int f2) {
		if(f1 == f2) return false;
		
		int f1R = find(f1);
		int f2R = find(f2);

		if(f1R == f2R) return false;
		
		
		if(size[f1R] > size[f2R]) {
			users[f2R] = f1R;
			size[f1R] += size[f2R];
		} else {
			users[f1R] = f2R;
			size[f2R] += size[f1R];
		}
		
		count--;
		
		return true;
	}

	public int count() {
		return count;
	}

	public static void main(String[] args) {
		int n = StdIn.readInt();
		SocialNetworkConnectivity sc = new SocialNetworkConnectivity(n);

		long timestamp = -1;
		while (sc.count() != 1 ) {
			int f1 = StdIn.readInt();
			int f2 = StdIn.readInt();
			timestamp = StdIn.readInt();

			if (sc.union(f1, f2))
				System.out.println(f1+ " " + f2 + " time: " + timestamp);
		}
			
		StdOut.println(timestamp);
	}
}
