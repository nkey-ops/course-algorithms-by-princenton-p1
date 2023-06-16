package analysis_1_4.cp.ex_25;

import java.util.Random;

public class ThrowingTwoEggs {

	public static void main(String[] args) {
		Random r = new Random();

		for (int i = 0; i < 100; i++) {
			int h = r.nextInt(1, 100);
			int eH = r.nextInt(1, h + 1);
			Egg e = new Egg(eH);

			int act = floorCSqrtF(h, e);

			System.out.printf("[floorLgN] Expected: %2s | Actual %2s | is Correct: %s | height %s\n", eH, act,
					act == eH, h);
		}
	}

	public static int floorCSqrtF(int h, Egg e) {
		int low = 0, high = 1;
		int i = 2;

		while(high < h && !e.throwFrom(high)) {
			low = high;
			high += i;
		}
		
		while(low <= high && !e.throwFrom(low)) {
			low++;
		}

		return low;
	}
	
	public static int floor2sqrtN(int h, Egg e) {
		double sqrt = Math.sqrt(h);

		int low = 0, high = -1;
		int i = 1;
		do {
			low = high + 1;
			high = (int) (i++ * sqrt) - 1;
		
		} while (high <= h && !e.throwFrom(high));

		if(high > h) high = h;
		
		while (low <= high && !e.throwFrom(low))
			low++;

		return low;
	}

	private static class Egg {

		// first floor at which the egg is broken
		private final int height;

		public Egg(int height) {
			this.height = height;
		}

		/**
		 * @param height
		 * @return true if the egg was broken otherwise false
		 */
		public boolean throwFrom(int height) {
			return height >= this.height;
		}
	}
}
