package unionfind_1_5.cp.ex_17;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.UF;

public class RandomConnections {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.err.printf("Usage [n]\n "
							+ "n - [0, n)");
			System.exit(1);
		}
		
		int n = Integer.parseInt(args[0]);
		
		System.out.println(count(n));
	}

	private static int count(int n) {
		UF uf =  new UF(n);
		int con = 0;
		
		while (uf.count() != 1) {
			int n1 = StdRandom.uniformInt(n);
			int n2 = StdRandom.uniformInt(n);
			
			if(uf.find(n1) == uf.find(n2)) continue;
				
			uf.union(n1, n2);
			con++;
		}
		
		return con;
	}
}
