package priority_queues_2_4.webex.ex14;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 *
 *
 * <pre>
 * Stack with min/max.
 *
 * Design a data type that supports push, pop, size, min, and max
 * (where min and max are the minimum and maximum items on the stack).
 * All operations should take constant time in the worst case.
 *
 *
 * Output: 
 *
 *    Input array:
 *    [6, 3, 1, 5, 2, 8, 9, 0, 4, 7]
 *
 *    Added: 6 | Min: 6 | Max: 6
 *    Added: 3 | Min: 3 | Max: 6
 *    Added: 1 | Min: 1 | Max: 6
 *    Added: 5 | Min: 1 | Max: 6
 *    Added: 2 | Min: 1 | Max: 6
 *    Added: 8 | Min: 1 | Max: 8
 *    Added: 9 | Min: 1 | Max: 9
 *    Added: 0 | Min: 0 | Max: 9
 *    Added: 4 | Min: 0 | Max: 9
 *    Added: 7 | Min: 0 | Max: 9
 *    Result:
 *    [6, 3, 1, 5, 2, 8, 9, 0, 4, 7]
 *    Size : 10
 *
 *    Min: 0 | Max: 9 | Removed: 7
 *    Min: 0 | Max: 9 | Removed: 4
 *    Min: 0 | Max: 9 | Removed: 0
 *    Min: 1 | Max: 9 | Removed: 9
 *    Min: 1 | Max: 8 | Removed: 8
 *    Min: 1 | Max: 6 | Removed: 2
 *    Min: 1 | Max: 6 | Removed: 5
 *    Min: 1 | Max: 6 | Removed: 1
 *    Min: 3 | Max: 6 | Removed: 3
 *    Min: 6 | Max: 6 | Removed: 6
 *    Result:
 *    []
 *    Size : 0
 *
 * </pre>
 */
public class StackWithMinAndMax {
  private final int[] stack;
  private int[] min;
  private int[] max;

  private int size = 0;

  public StackWithMinAndMax(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException();
    }

    stack = new int[size];
    min = new int[size];
    max = new int[size];
  }

  public void push(int v) {
    if (isFull()) throw new IllegalStateException();

    if (isEmpty()) {
      stack[size++] = min[0] = max[0] = v;
      return;
    }

    max[size] = v > max[size - 1] ? v : max[size - 1];
    min[size] = v < min[size - 1] ? v : min[size - 1];

    stack[size++] = v;
  }

  public int pop() {
    if (isEmpty()) throw new IllegalStateException();

    int val = stack[--size];

    return val;
  }

  public int min() {
    if (isEmpty()) throw new IllegalStateException();

    return min[size - 1];
  }

  public int max() {
    if (isEmpty()) throw new IllegalStateException();

    return max[size - 1];
  }

  private boolean isEmpty() {
    return size == 0;
  }

  private boolean isFull() {
    return size == stack.length;
  }

  private int size() {
    return size;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");

    for (int i = 0; i < size; i++) {
      sb.append(stack[i]);
      if (i != size - 1) sb.append(", ");
    }

    return sb.append("]").toString();
  }

  public static void main(String[] args) {
    int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;

    int[] arr = StdRandom.permutation(n);
    StackWithMinAndMax stack = new StackWithMinAndMax(n);

    System.out.println("Input array:");
    System.out.println(Arrays.toString(arr));
    System.out.println();

    for (int i = 0; i < arr.length; i++) {
      stack.push(arr[i]);
      System.out.printf("Added: %s | Min: %s | Max: %s\n", arr[i], stack.min(), stack.max());

      assert Arrays.stream(arr, 0, i + 1).min().getAsInt() == stack.min();
      assert Arrays.stream(arr, 0, i + 1).max().getAsInt() == stack.max();
    }

    System.out.println("Result: \n" + stack);
    System.out.println("Size : " + stack.size());
    System.out.println();

    for (int i = 0; i < arr.length; i++) {
      assert Arrays.stream(arr, 0, arr.length - i).min().getAsInt() == stack.min();
      assert Arrays.stream(arr, 0, arr.length - i).max().getAsInt() == stack.max();

      System.out.printf("Min: %s | Max: %s | Removed: %s\n", stack.min(), stack.max(), stack.pop());
    }

    System.out.println("Result: \n" + stack);
    System.out.println("Size : " + stack.size());
  }
}
