package elementary_sorts_2_1.ex.ex3;

public class ObliviousSortingNetworks {
	public static void main(String[] args) {
		sort4();
		sort5();
	}

	
	public static void sort4() {
		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				for (int c = 0; c < 4; c++) {
					for (int d = 0; d < 4; d++) {
						if(!sort(a, b , c, d)) {
							throw new RuntimeException(
									String.format("%s, %s, %s, %s", a, b, c, d));
						}
					}
				}
			}
		}
	}

	public static void sort5() {
		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				for (int c = 0; c < 4; c++) {
					for (int d = 0; d < 4; d++) {
						for (int e = 0; e < 4; e++) {
							
							if(!sort(a, b , c, d, e)) {
								throw new RuntimeException(
										String.format("%s, %s, %s, %s, %s", 
												a, b, c, d, e));
							}
						}
					}
				}
			}
		}
	}

//	 @formatter:off
	public static boolean sort(int A, int B, int C, int D) {
		int t;

		if (A > B) { t = A; A = B; B = t; }
		if (C > D) { t = C; C = D; D = t; }
		if (A > C) { t = C; C = A; A = t; }
		if (B > D) { t = D; D = B; B = t; }
		if (B > C) { t = B; B = C; C = t; }

		return A <= B && B <= C && C <= D;
	}

	public static boolean sort(int A, int B, int C, int D, int E) {
		int t;

		if (A > B) { t = A; A = B; B = t; }
		if (D > E) { t = D; D = E; E = t; }
		if (A > C) { t = C; C = A; A = t; }
		if (C > E) { t = C; C = E; E = t; }
		if (A > D) { t = A; A = D; D = t; }
		if (B > E) { t = B; B = E; E = t; }
		if (C > D) { t = C; C = D; D = t; }
		if (B > D) { t = B; B = D; D = t; }
		if (B > C) { t = B; B = C; C = t; }

		return A <= B && B <= C && C <= D && D <= E;
	}
// @formatter:on
}
