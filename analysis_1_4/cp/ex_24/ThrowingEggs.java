package analysis_1_4.cp.ex_24;

import edu.princeton.cs.algs4.StdRandom;

public class ThrowingEggs {
		
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
			return height >= this.height;
		}
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int h = StdRandom.uniformInt(1, 100);
			int eH = StdRandom.uniformInt(1, h + 1);
			Egg e =  new Egg(eH);

			int act = floorLgN(h, e);
			
			System.out.printf("[floorLgN] Expected: %2s | Actual %2s | is Correct: %s | height %s\n",
							eH, act, act == eH , h );
		}

		for (int i = 0; i < 10; i++) {
			int h = StdRandom.uniformInt(1, 100);
			int eH = StdRandom.uniformInt(1, h + 1);
			Egg e =  new Egg(eH);
			
			int act = floor2LgF(h, e);
			
			System.out.printf("[floor2LgF] Expected: %2s | Actual %2s | is Correct: %s | height %s\n",
					eH, act, act == eH , h );
		}
		
    }

	public static int floorLgN(int h, Egg e) {
		int low = 0, high = h;
		int mid = -1;
		
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

	public static int floor2LgF(int h, Egg e) {
		int low = 0, high = 1;
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
	
}
