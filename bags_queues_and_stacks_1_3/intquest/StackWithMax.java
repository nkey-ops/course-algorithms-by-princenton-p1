package bags_queues_and_stacks_1_3.intquest;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Stack with max. 
 * Create a data structure that efficiently supports 
 * 	the stack operations (push and pop) and also 
 * 	a return-the-maximum operation. 
 * Assume the elements are real numbers so that you can compare them.
 *
 */
public class StackWithMax {
	private Double[] data;
	private int le = -1;
	
	public StackWithMax(int s) {
		if(s <= 0 )
			throw new IllegalArgumentException();
		
		data = new Double[s];
	}
	
	
	
	public void push(double v) {
		if(isFull()) 
			throw new IllegalStateException();
		
		data[++le] = v;
	}

	public double pop() {
		if(isEmpty()) 
			throw new IllegalStateException();

		Double d =  data[le];
		data[le--] = null;
		
		return d;
	}

	private double getMax() {
		if(isEmpty())
			throw new IllegalStateException();
		
		double r = data[0];
		
		for (Double d : data) {
			if(d == null ) break;
			if(r < d) r = d;
		}

		return r;
	}
	private boolean isEmpty() {
		return le == -1;
	}

	private boolean isFull() {
		return le == data.length - 1;
	}

	private int size() {
		return data.length;
	}

	@Override
	public String toString() {
		return Arrays.toString(data);
	}
	
	
	public static void main(String[] args) {
		
		
		StackWithMax s  = 
				new StackWithMax(StdRandom.uniformInt(20));
		
		for (int i = 0; i < s.size(); i++) {
			double push = Math.round(StdRandom.uniformDouble(1, 20));
			
			
			System.out.println("push: " + push);
			s.push(push);
			
			System.out.println("getMax: " + s.getMax());
			
			System.out.println(s);
			
			if(StdRandom.uniformInt(2) == 1)
				System.out.println("pop " + s.pop()); 
			
			System.out.println(s);
		}
	}
	
	
	
	
	
	
	
}
