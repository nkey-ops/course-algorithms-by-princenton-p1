package unionfind_1_5.intquest.ex_3;

import java.util.Arrays;

public class SuccessorWithDelete {
	private int[] data;
	private int[] size;
	private int[] succ;
	private int[] pred;
	private int[] last;
	private int count;
	
	public SuccessorWithDelete(int n) {
		if (n < 0)
			throw new IllegalArgumentException("N cannot be below zero");

		count = n;
		data = new int[n];
		size = new int[n];
		succ = new int[n];
		pred = new int[n];
		last = new int[n];
		
		for (int i = 0; i < n; i++) {
			data[i] = i;
			last[i] = i;
			size[i] = 1;
			
			succ[i] =  i == n - 1 ? i : i + 1;
			pred[i] =  i == 0 ? i: i - 1;
		}
	}

	public int find(int p) {
		validate(p);

		int root = p;
		while (data[root] != root)
			root = data[root];

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

		if(p == q) return;
		
		int pR = find(p);
		int qR = find(q);
		if(pR == qR) return;

		
		if (size[pR] > size[qR]) {
			data[qR] = pR;
			size[pR] += size[qR];
			
			succ[pred[qR]] = succ[qR];
			pred[qR] = pred[pR];
			last[pR] = qR;
			
		} else {
			data[pR] = qR;
			size[qR] += size[pR];
			
			succ[pred[pR]] = succ[pR];
			pred[pR] = pred[qR];
			last[qR] = pR;
		}		
		count--;
	}
	
	
	/**
	 * Removes x if it is a root
	 * <br/> if x's size == 1
	 * <br/> &emsp;  Unites it with x's successor or
	 * <br/> &emsp;  if x is it's own successor with it's predecessor
	 * <br/> if x's size > 1
	 * <br/> &emsp; Changes it's value to the last united value 
	 *
	 * @param x element to be removed
	 */
	public void delete(int x) {
		validate(x);
		if(data.length == 1) 
				throw new IllegalStateException("Lengh is too short");
		
		if(data[x] != x) return; //if is not root skip
		
		int x1 = findSuccessor(x) == x ? pred[x] : findSuccessor(x);
		
		if(size[x] == 1)
			union(x, x1);
		else {
			data[x] = last[x];
			data[last[x]] = last[x];
		}
	}
	
	public int findSuccessor(int x) {
		validate(x);
		
		return succ[x];
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
		SuccessorWithDelete uf = 
				new SuccessorWithDelete(5);
	
			uf.union(2, 0);
			System.out.println("Starting array " + uf);
			
			System.out.println("successor of 0 -> 1 is " + uf.findSuccessor(0));
			System.out.println("successor of 1 -> 3 is " + uf.findSuccessor(1));
			System.out.println("successor of 2 -> 3 is " + uf.findSuccessor(2));
			System.out.println("successor of 4 -> 4 is " + uf.findSuccessor(4));
	
			uf.union(1, 3);
			System.out.println("Union 1 and 3" + uf);
			
			System.out.println("successor of 2 -> 3 is " + uf.findSuccessor(2));
	
			System.out.println("delete 4 -> uniting with 3");
			uf.delete(4);
			System.out.println(uf);
			
			System.out.println("delete 3 -> replacing 3 with 4 ");
			uf.delete(3);
			System.out.println(uf);
	
	}

}