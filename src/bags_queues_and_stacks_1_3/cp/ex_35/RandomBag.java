package bags_queues_and_stacks_1_3.cp.ex_35;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

/**
 *
 *
 * <pre>
 * Random bag. 
 * A random bag stores a collection of items and supports the fol- lowing API:
 * Write a class RandomBag that implements this API. Note that this API is the same as for Bag,
 * except for the adjective random, which indicates that the iteration should provide
 * the items in random order (all N ! permutations equally likely, for each iterator).
 *
 * Hint : Put the items in an array and randomize their order in the iterator’s constructor.
 * </pre>
 */
public class RandomBag<Item> implements Iterable<Item> {
  private Node<Item> first;
  private Node<Item> last;
  private int size;

  private static class Node<Item> {
    public final Item item;
    public Node<Item> next;

    public Node(Item item) {
      this.item = item;
    }
  }

  public void add(Item item) {
    if (first == null) {
      first = last = new Node<>(item);
    } else {
      last = last.next = new Node<>(item);
    }

    size++;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Iterator<Item> iterator() {
    Item[] arr = (Item[]) new Object[size];
    boolean[] isSet = new boolean[size];

    Node<Item> curr = first;
    while (curr != null) {

      int uniformInt;
      do {
        uniformInt = StdRandom.uniformInt(0, size);
      } while (isSet[uniformInt] == true);

      isSet[uniformInt] = true;
      arr[uniformInt] = curr.item;
      curr = curr.next;
    }

    return new Iterator<Item>() {
      int i = 0;

      @Override
      public boolean hasNext() {
        return i != size;
      }

      @Override
      public Item next() {
        return arr[i++];
      }
    };
  }

  public static void main(String[] args) {
    RandomBag<Integer> rb = new RandomBag<>();

    for (int i = 0; i < 10; i++) {
      rb.add(i);
    }

    rb.forEach(System.out::println);
  }
}
