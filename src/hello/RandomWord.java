package hello; //remove package

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {

	public static void main(String[] args) {
		String champ = "";
		String s;
		
		for (int i = 1; !StdIn.isEmpty(); i++) {
			s = StdIn.readString();

			if (StdRandom.bernoulli(1d / i) || champ.isBlank())
				champ = s;
		}
		System.out.println(champ);
	}
}
