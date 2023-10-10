package priority_queues_2_4.intquest;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Randomized priority queue.
 * Describe how to add the methods sample()sample()
 * and delRandom()delRandom() to our binary heap implementation.
 * The two methods return a key that is chosen uniformly
 * at random among the remaining keys,
 * with the latter method also removing that key.
 * 
 * The sample()sample() method should take constant time;
 * the delRandom()delRandom() method should take logarithmic time.
 * 
 * Do not worry about resizing the underlying array.
 *
 *
 * Result:
 *
 * RandomizedMaxPriorityQueue.java
 * Insert: 0
 * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
 * Insert: 1
 * [0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0]
 * Insert: 2
 * [0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0]
 * Insert: 3
 * [0, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0]
 * Insert: 4
 * [0, 4, 3, 1, 0, 2, 0, 0, 0, 0, 0]
 * Insert: 5
 * [0, 5, 3, 4, 0, 2, 1, 0, 0, 0, 0]
 * Insert: 6
 * [0, 6, 3, 5, 0, 2, 1, 4, 0, 0, 0]
 * Insert: 7
 * [0, 7, 6, 5, 3, 2, 1, 4, 0, 0, 0]
 * Insert: 8
 * [0, 8, 7, 5, 6, 2, 1, 4, 0, 3, 0]
 * Insert: 9
 * [0, 9, 8, 5, 6, 7, 1, 4, 0, 3, 2]
 * 
 * Random Sample: 3
 * Random Sample: 3
 * Random Sample: 4
 * Random Sample: 5
 * Random Sample: 8
 * Random Sample: 0
 * Random Sample: 6
 * Random Sample: 0
 * Random Sample: 3
 * Random Sample: 2
 * 
 * Delete Random: 8
 * [0, 9, 7, 5, 6, 2, 1, 4, 0, 3, 0]
 * Delete Random: 7
 * [0, 9, 6, 5, 3, 2, 1, 4, 0, 0, 0]
 * Delete Random: 3
 * [0, 9, 6, 5, 0, 2, 1, 4, 0, 0, 0]
 * Delete Random: 6
 * [0, 9, 4, 5, 0, 2, 1, 0, 0, 0, 0]
 * Delete Random: 0
 * [0, 9, 4, 5, 1, 2, 0, 0, 0, 0, 0]
 * 
 * Delete Max: 9
 * [0, 5, 4, 2, 1, 0, 0, 0, 0, 0, 0]
 * Delete Max: 5
 * [0, 4, 1, 2, 0, 0, 0, 0, 0, 0, 0]
 * Delete Max: 4
 * [0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0]
 * Delete Max: 2
 * [0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0]
 * Delete Max: 1
 * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
 *
 */
public class RandomizedMaxPriorityQueue {
    private int[] heap;
    private int size;

    public RandomizedMaxPriorityQueue(int size) {
        if (size < 1)
            new IllegalArgumentException();
        this.heap = new int[size + 1];
    }

    public void insert(int val) {
        if (size + 1 == heap.length)
            throw new RuntimeException();

        heap[++size] = val;
        swim();
    }

    public int delMax() {
        if (size == 0)
            throw new RuntimeException();
        int val = heap[1];
        heap[1] = heap[size];
        heap[size--] = 0;

        sink(1);

        return val;
    }

    public int sample() {
        if (size == 0)
            throw new RuntimeException();

        return heap[StdRandom.uniformInt(1, size + 1)];
    }

    public int delRandom() {
        if (size == 0)
            throw new RuntimeException();

        int i = StdRandom.uniformInt(1, size + 1);
        int val = heap[i];
        heap[i] = heap[size];
        heap[size--] = 0;

        sink(i);

        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void sink(int i) {
        while ((i *= 2) <= size) {
            if (i + 1 <= size && heap[i] < heap[i + 1])
                i++;
            if (heap[i / 2] < heap[i])
                swap(i / 2, i);
        }
    }

    private void swim() {

        int i = size;
        while (i / 2 != 0 && heap[i / 2] < heap[i]) {
            swap(i / 2, i);
            i /= 2;
        }
    }

    private void swap(int a, int b) {
        int t = heap[a];
        heap[a] = heap[b];
        heap[b] = t;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }

    public static void main(String[] args) {
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;
        RandomizedMaxPriorityQueue q = new RandomizedMaxPriorityQueue(n);

        for (int i = 0; i < n; i++) {
            q.insert(i);
            System.out.println("Insert: " + i);
            System.out.println(q);
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.println("Random Sample: " + q.sample());
        }

        System.out.println();

        for (int i = 0; i < n / 2; i++) {
            System.out.println("Delete Random: " + q.delRandom());
            System.out.println(q);
        }
        System.out.println();

        while (!q.isEmpty()) {
            int delMax = q.delMax();
            System.out.println("Delete Max: " + delMax);
            System.out.println(q);
        }

    }
}
