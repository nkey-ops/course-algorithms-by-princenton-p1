package analysis_1_4.intquest;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author deuru 
 * Egg drop. 
 * Suppose that you have an N-story building (with
 * 		floors 1 through N) and plenty of eggs. 
 * An egg breaks if it is
 * 		dropped from floor T or higher and does not break otherwise. 
 * Your goal is to devise a strategy to determine the value of T given the
 * 		following limitations on the number of eggs and tosses:
 * 
 * Version 0: 1 egg ≤T tosses. 
 * Version 1: ∼1lgN eggs and ∼1lgN tosses.
 * Version 2: ∼lgT eggs and ∼2lgT tosses 
 * Version 3: 2 eggs and ∼2 √N tosses. 
 * Version 4: 2 eggs and ≤c√T tosses for some fixed constant c.
 * 
 * 
 */
public class EggDrop {
	
	public static void main(String[] args) {
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
		
			int h = StdRandom.uniformInt(1, 100);
			int eH = StdRandom.uniformInt(1, h + 1);
			assert eH == floorV0(h, new Egg(eH));

			int h1 = StdRandom.uniformInt(1, 100);
			int eH1 = StdRandom.uniformInt(1, h1 + 1);
			assert eH1 == floorV1(h1, new Egg(eH1));

			int h2 = StdRandom.uniformInt(1, 100);
			int eH2 = StdRandom.uniformInt(1, h2 + 1);
			assert eH2 == floorV2(h2, new Egg(eH2));


			int h3 = StdRandom.uniformInt(1, 100);
			int eH3 = StdRandom.uniformInt(1, h3 + 1);
			assert eH3 == floorV3(h3, new Egg(eH3));


			int h4 = StdRandom.uniformInt(1, 100);
			int eH4 = StdRandom.uniformInt(1, h4 + 1);
			assert eH4 == floorV4(h4, new Egg(eH4));

		}
    }
	
	
	
	/**
	 * Time Complexity O(lg N)
	 * 
	 * Requirement:  
	 * Version 1: ∼1lgN eggs and ∼1lgN tosses.
	 * 
	 * @return floor at which an egg is broken
	 */
	public static int floorV0(int h, Egg e) {
		for (int i = 1; i <= h; i++) 
			if(e.throwFrom(i)) return i ;
		
		return -1;
	}

	/**
	 * Time Complexity O(n)
	 * 
	 * Requirement:  
	 * Version 0: 1 egg ≤T tosses. 
	 * 
	 * @return floor at which an egg is broken
	 */
	public static int floorV1(int h, Egg e) {
		int low = 1;
		int mid = -1;
		
		while(low <= h) {
			mid = low + (h - low) / 2;
			
			if(e.throwFrom(mid))
				h = mid - 1;
			else { 
				if(h == low && low == mid) return ++mid;
				low = mid + 1;
			}
		}
		return mid;
	}
	
	
	
	/**
	 * Time Complexity O(2lg N)
	 * 
	 * Requirement:  
	 * Version 2: ∼lgT eggs and ∼2lgT tosses 
	 * 
	 * @return floor at which an egg is broken
	 */
	public static int floorV2(int h, Egg e) {
		int low = 1, high = 1;
		int mid = -1;
		
		while(high <= h && !e.throwFrom(high)) {
			low = high;
			high *= 2;
		}
		
		high  = high > h ? h : high;

		
		while(low <= high) {
			mid = low + (high - low) / 2;
			
			if(e.throwFrom(mid))
				high = mid - 1;
			else { 
				if(high == low && low == mid) return ++mid;
				low = mid + 1;
			}
		}
		
		return mid;
	}

	/**
	 * Time Complexity O(sqrt(n))
	 * 
	 * Requirement:  
	 * Version 3: 2 eggs and ∼2 √N tosses. 
	 * 
	 * @return floor at which an egg is broken
	 */
	public static int floorV3(int h, Egg e) {
		int low = 1, high = 1;
		
		while(high <= h && !e.throwFrom(high)) {
			low = high;
			high += Math.sqrt(h);
		}	

		if(high > h) high = h;


		for (int i = low; i <= high; i++) 
			if(e.throwFrom(i)) return i;
		

		return -1;
	}
	/**
	 * Time Complexity O(c sqrt(n))
	 * 
	 * Requirement:  
	 * Version 4: 2 eggs and ≤c√T tosses for some fixed constant c.
	 * 
	 * @return floor at which an egg is broken
	 */
	public static int floorV4(int h, Egg e) {
		int low = 1, high = 1;
		int j = 2;

		while(high < h && !e.throwFrom(high)) {
			low = high;
			high += j++;
		}

		for (int i = low; i <= high; i++) 
			if(e.throwFrom(i)) return i;
		

		return -1; 
	}	

	private static class Egg {
		
		//first floor at which the egg is broken
		private final int height;
		
		public Egg(int height) {
			this.height = height;
		}
		/**
		 * @param height
		 * @return  true if the egg was broken otherwise false
		 */
		public boolean throwFrom(int height) {
			if(height <=0 ) throw new IllegalArgumentException();
			
			return height >= this.height;
		}
	}
}
