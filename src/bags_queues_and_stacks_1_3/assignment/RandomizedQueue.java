
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] data = (Item[]) new Object[1];
	private int size;
	
    // construct an empty randomized queue
	public RandomizedQueue() {
	}

    // is the randomized queue empty?
    public boolean isEmpty() {
    	return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
    	return size;
    }
    
    public void enqueue(Item item) {
    	if (item == null)
			throw new IllegalArgumentException("Item cannot be null");
    	
    	if(size >=  data.length * 0.75) {
    		Item[] data2 = (Item[]) new Object[(data.length * 2)];
    		for (int i = 0; i < data.length; i++) {
				data2[i] = data[i];
    		}
    		data = data2;
    	}
    	
    	data[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("Deque is empty");
		
		int r = StdRandom.uniformInt(size);
	
		if(size <=  data.length * 0.40) {
			int size = data.length / 2;
    		Item[] data2 = (Item[]) new Object[(size > 0 ? size : 1)];
    		for (int i = 0; i < data2.length; i++) {
				data2[i] = data[i];
    		}
    		data = data2;
    	}
		
		Item tmp = data[r];
		data[r] = data[--size];
		data[size] = null;
		
		
		return tmp;
    }

    // return a random item (but do not remove it)
    public Item sample() {
    	if (isEmpty())
			throw new NoSuchElementException("Deque is empty");
    
    	int i = StdRandom.uniformInt(size);
    	
    	return data[i];
    }

    // return an independent iterator over items in random order
 	public Iterator<Item> iterator() {
 		return new Iterator<Item>() {
 			private Item[]  items = init();
 			private int i = -1;
 			
 			@Override
 			public boolean hasNext() {
 				return i + 1 != size;
 			}

 			@Override
 			public Item next() {
 				if (i + 1 == size)
 					throw new NoSuchElementException("Deque is empty");

 				return items[++i];
 			}

 			@Override
 			public void remove() {
 				throw new UnsupportedOperationException();
 			}
 			
			private Item[] init(){
				Item[] items = (Item[]) new Object[size];
				if(size == 0) return items;
				
				for(int i = size - 1; i > 0 ; i-- ) {
 					int r = StdRandom.uniformInt(i + 1);
 					
 					Item tmp = data[r];
 					data[r] = data[i];
 					data[i] = tmp;
 					
 					items[i] = data[i];
				}
				items[0] = data[0];
				
 				return items;
 			}
 		};
 	}

    // unit testing (required)
    public static void main(String[] args) {
		int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;

		RandomizedQueue<Integer> d = new RandomizedQueue<>();

		System.out.println("enqueue");
		for (int i = 0; i < n; i++) {
			d.enqueue(i);
			show(d);
		}

		System.out.println("sample");
		for (int i = 0; i < n; i++) {
			System.out.println(d.sample());
		}
		
		System.out.println("dequeue");
		for (int i = 0; i < n; i++) {
			d.dequeue();
			show(d);
		}
    }
    

	private static <T> void show(RandomizedQueue<T> d) {
		System.out.print(d.size + " | " + 
						 "Is empty: " + d.isEmpty() + " | ");

		for (T t : d)
			System.out.print(t + " ");

		System.out.println();

	}
}
		
