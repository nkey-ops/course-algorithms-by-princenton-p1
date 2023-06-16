package elementary_sorts_2_1.exp.ex23_24;

public class InsertionX {

	public  static <T> void sort(Comparable<T>[] a) { // Sort a[] into increasing order.
		
		int N = a.length;

		for(int i = a.length - 1; i > 0; i-- ) {
			Comparable<T> tmp =  a[i - 1];
				a[i - 1] = a[i];
				a[i] = tmp;
		}

		
		for (int i = 1; i < N; i++) { // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
			Comparable<T> e = a[i];
	
			int j = i;
			for (; j > 0 && e.compareTo((T) a[j - 1]) < 0; j--) {
				a[j] = a[j - 1];
			}

			a[j] = e;
		}
	}
}
