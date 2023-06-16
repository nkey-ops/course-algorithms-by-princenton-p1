
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private int size;
	private Node<Item> first = null, last = null;

	// construct an empty deque
	public Deque() {
	}

	// is the deque empty?
	public boolean isEmpty() {
		return size == 0;
	}

	// return the number of items on the deque
	public int size() {
		return size;
	}

	// add the item to the front
	public void addFirst(Item item) {
		if (item == null)
			throw new IllegalArgumentException("Item cannot be null");

		Node<Item> n = new Node<>(item, first);

		if (first == null) {
			last = first = n;
		} else {
			first.prev = n;
			first = n;
		}

		size++;
	}

	// add the item to the back
	public void addLast(Item item) {
		if (item == null)
			throw new IllegalArgumentException("Item cannot be null");

		Node<Item> n = new Node<>(item);

		if (last == null)
			first = last = n;
		else {
			n.prev = last;
			last = last.next = n;
		}

		size++;
	}

	// remove and return the item from the front
	public Item removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException("Deque is empty");

		size--;

		Item item = first.item;
		if (size == 0)
			last = first = null;
		else {
			first = first.next;
			first.prev = null;
		}

		return item;
	}

	// remove and return the item from the back
	public Item removeLast() {
		if (isEmpty())
			throw new NoSuchElementException("Deque is empty");
		size--;

		Item item = last.item;
		if (size == 0)
			first = last = null;
		else {
			last = last.prev;
			last.next = null;
		}

		return item;
	}

	// return an iterator over items in order from front to back
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			private Node<Item> next = first;
			
			@Override
			public boolean hasNext() {
				return next != null;
			}

			@Override
			public Item next() {
				if (next == null)
					throw new NoSuchElementException("Deque is empty");
				
				Item i = next.item;;
				next = next.next;
				
				return i;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	// unit testing (required)
	public static void main(String[] args) {
		int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;

		Deque<Integer> d = new Deque<>();

		System.out.println("Add first");
		for (int i = 0; i < n; i++) {
			d.addFirst(i);
			show(d);
		}

		System.out.println("Add last");

		for (int i = n; i < n * 2; i++) {
			d.addLast(i);
			show(d);
		}

		System.out.println("Remove First");

		for (int i = 0; i < n; i++) {
			d.removeFirst();
			show(d);
		}

		System.out.println("Remove Last");

		for (int i = 0; i < n; i++) {
			d.removeLast();
			show(d);
		}
		
		testAddFirst();
		testAddLast();
		testRemoveFirst();
		testRemoveLast();
}

	private static <T> void show(Deque<T> d) {
		System.out.print(d.size + " | " + 
						 "Is empty: " + d.isEmpty() + " | ");

		for (T t : d)
			System.out.print(t + " ");

		System.out.println();

	}

	private static void testAddFirst() {
		Deque<Integer> d = new Deque<>();
		d.addFirst(1);

		assert d.first.item == 1 
				&& d.first.next == null
				&& d.first.prev == null
				&& d.first == d.last;
		
		
		Deque<Integer> d2 = new Deque<>();
		d2.addFirst(1);
		d2.addFirst(2);
		
		assert d2.first.item == 2
				&& d2.first.prev == null
				&& d2.first.next == d2.last
				
				&& d2.last.item == 1
				&& d2.last.next == null
				&& d2.last.prev == d2.first;
	}
	
	private static void testAddLast() {
		Deque<Integer> d = new Deque<>();
		d.addLast(1);

		assert d.last.item == 1 
				&& d.last.next == null
				&& d.last.prev == null
				&& d.last == d.first;
		
		
		Deque<Integer> d2 = new Deque<>();
		d2.addLast(1);
		d2.addLast(2);
		
		assert d2.last.item == 2
				&& d2.last.prev == d2.first
				&& d2.last.next == null 
				
				&& d2.first.item == 1
				&& d2.first.next == d2.last
				&& d2.first.prev == null; 
	}

	private static void testRemoveFirst() {
		Deque<Integer> d = new Deque<>();
		d.addFirst(1);
		d.removeFirst();

		assert d.first == null && d.last == null;
		
		d.addLast(1);
		d.addLast(2);
		d.removeFirst();
		
		assert d.first.item == 2 
				&& d.first.next == null
				&& d.first.prev == null
				&& d.first == d.last;
	}
	
	private static void testRemoveLast() {
		Deque<Integer> d = new Deque<>();
		d.addFirst(1);
		d.removeLast();
	
		assert d.first == null && d.last == null;

		d.addLast(1);
		d.addLast(2);
		d.removeLast();

		assert d.last.item == 1 
				&& d.last.next == null
				&& d.last.prev == null
				&& d.last == d.first;
	}

	//	(16 + 8 + 8 + 8)N = 40N
	private static class Node<T> {
		public Node<T> next;
		public Node<T> prev;
		public final T item;

		public Node(T item) {
			this.item = item; } 
		public Node(T item, Node<T> next) {
			this(item);
			this.next = next;
		}
	}

}