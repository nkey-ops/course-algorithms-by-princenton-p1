package analysis_1_4.cp.ex_34;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 *	<br/> Hot or cold. 
 *	<br/> Your goal is the guess a secret integer between 1 and N. 
 *  <br/> You repeatedly guess integers between 1 and N. 
 *  <br/> After each guess you learn if it equals 
 *  <br/> the secret integer (and the game stops); 
 *  <br/> otherwise (starting with the second guess), 
 *  <br/> you learn if the guess is hotter (closer to) 
 *  <br/> or colder (farther from) the secret number 
 *  <br/> than your previous guess. 
 *  <br/> Design an algorithm that finds the secret number 
 *  <br/> in ~ 2 lg N guesses. Then, design an algorithm 
 *  <br/> that finds the secret number in ~ 1 lg N guesses.
 *	
 *@author deuru
 */
public class HotOrCold {
	private static class Termostat {
		private final int num;
		
		public Termostat(int num) {
			this.num = num;
		}

		public boolean isNumber(int num) {
			return this.num == num;
		}
		
		/**
		 * @return 0 if  first number is equal to secrete integer,
		 * <br />  1 if the first number is closer to secret integer,
		 * <br /> -1 if the second number is closer to secret integer.
		 */

		public int isHotter2(int num1, int num2) {
			if(num1 < 1 || num2 < 1) 
				throw new IllegalArgumentException(
						"Numbers cannot be lower then 1");
		
			return Integer.compare(Math.abs(num - num2), Math.abs(num - num1));
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int n = StdRandom.uniformInt(1, 100);
			int aim = n == 1 ? 1 : StdRandom.uniformInt(1, n);
			Termostat t =  new Termostat(aim);

			int act = findSecretInteger(n, t);
			
			System.out.printf("[floorLgN] Expected: %2s | Actual %2s | is Correct: %5s | N %s\n",
							aim, act, act == aim , n );
			
			if(act != aim) 
				throw new RuntimeException();
		}
    }

	public static int findSecretInteger(int n, Termostat t) {
		int low = 1, high = n, mid = -1;
		
		while(low <= high) {
			mid = low + (high - low) / 2;
			
			if(t.isNumber(mid)) return mid;
			
			int r = t.isHotter2(mid, mid - 1 < 1 ? mid +1 : mid - 1);
			
			if(r == -1 && mid - 1 >= 1)
				high = mid - 1;
			else { 
				low = mid + 1;
			}
		}
		return mid;
	}


	
}
