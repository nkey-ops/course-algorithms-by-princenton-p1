package priority_queues_2_4.ex.ex33;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;


/**
 * IndexMaxPQ
 */
public class IndexMaxPQ<Key extends Comparable<Key>> implements Iterable<Key> {
    private Key[] keys; // store items at indices 1 to n
    private int pq[];
    private int qp[];

    private int n; // number of items on priority queue

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param initCapacity the initial capacity of this priority queue
     */
    @SuppressWarnings("unchecked")
    public IndexMaxPQ(int initCapacity) {
        keys = (Key[]) new Comparable[initCapacity + 1];
        this.pq = new int[initCapacity + 1];
        this.qp = new int[initCapacity + 1];

        n = 0;
    }

    /**
     * Initializes a priority queue from the array of keys.
     * Takes time proportional to the number of keys, using sink-based heap
     * construction.
     *
     * @param keys the array of keys
     */
    @SuppressWarnings("unchecked")
    public IndexMaxPQ(Key[] keys) {
        n = keys.length;

        keys = (Key[]) new Object[keys.length + 1];

        for (int i = 0; i < n; i++)
            keys[i + 1] = keys[i];
        for (int k = n / 2; k >= 1; k--)
            sink(k);

        assert isMaxHeap();
    }

    /**
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns a largest key on this priority queue.
     *
     * @return a largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key max() {
        if (isEmpty())
            throw new NoSuchElementException("Priority queue underflow");
        return keys[pq[1]];
    }

    /**
     * @return index of a largest key
     * @throws NoSuchElementException if this priority queue is empty
     */
    public int maxIndex() {
        if (isEmpty())
            throw new NoSuchElementException("Priority queue underflow");

        return pq[1];
    }

    /**
     * Adds a new key to this priority queue.
     *
     * @param x the new key to add to this priority queue
     */
    public void insert(int k, Key x) {
        if (contains(k) || x == null)
            throw new IllegalArgumentException();

        validate(k);
        k++;

        // add x, and percolate it up to maintain heap invariant
        keys[k] = x;
        pq[n + 1] = k;
        qp[k] = n + 1;

        n++;
        swim(n);

        assert isMaxHeap();
        assert isProper();
    }

    private void validate(int k) {
        if (k < 0 || k >= keys.length - 1)
            throw new IllegalArgumentException(
                    String.format("k = %s cannot be below 0 " +
                            "or bigger or equal to %s", k, keys.length - 1));
    }

    private boolean isProper() {
        for (int i = 1; i <= n; i++) {
            if (keys[i] == null)
                continue;

            if (keys[i] != keys[pq[qp[i]]]) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(int k) {
        validate(k);
        return keys[k + 1] != null;
    }

    /**
     * Removes and returns a largest key on this priority queue.
     *
     * @return a largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key delMax() {
        if (isEmpty())
            throw new NoSuchElementException("Priority queue underflow");

        Key max = keys[pq[1]];

        exch(1, n--);
        sink(1);

        keys[pq[n + 1]] = null; // to avoid loitering and help with garbage collection
        pq[n + 1] = 0;
        qp[n + 1] = 0;

        assert isMaxHeap();
        assert isProper();
        return max;
    }

    public Key delete(int k) {
        validate(k);

        if (isEmpty() || !contains(k))
            throw new NoSuchElementException("Priority queue underflow");

        k++;
        int ind = qp[k];
        Key key = keys[k];

        exch(ind, n--);
        assert pq[n + 1] == k;

        sink(ind);
        assert pq[n + 1] == k;
        assert pq[qp[k]] == k;

        qp[pq[n + 1]] = k;

        keys[k] = null; // to avoid loitering and help with garbage collection
        pq[n + 1] = 0;
        qp[k] = 0;

        assert isMaxHeap();
        assert isProper();

        return key; 
    }

    @Override
    public String toString() {
        return String.format("keys= %s\n" +
                "pq = %s\n" +
                "qp = %s\n",
                Arrays.toString(keys),
                Arrays.toString(pq),
                Arrays.toString(qp));
    }

    /***************************************************************************
     * Helper functions to restore the heap invariant.
     ***************************************************************************/

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for compares and swaps.
     ***************************************************************************/

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void exch(int i, int j) {

        int kSwap = pq[i];
        pq[i] = pq[j];
        pq[j] = kSwap;

        qp[pq[i]] = i;
        qp[pq[j]] = j;

    }

    // is pq[1..n] a max heap?
    private boolean isMaxHeap() {
        for (int i = 1; i <= n; i++) {
            if (keys[pq[i]] == null)
                return false;
        }
        for (int i = n + 1; i < keys.length; i++) {
            if (keys[pq[i]] != null)
                return false;
        }
        if (keys[0] != null)
            return false;
        return isMaxHeapOrdered(1);
    }

    // is subtree of pq[1..n] rooted at k a max heap?
    private boolean isMaxHeapOrdered(int k) {
        if (k > n)
            return true;
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left <= n && less(k, left))
            return false;
        if (right <= n && less(k, right))
            return false;
        return isMaxHeapOrdered(left) && isMaxHeapOrdered(right);
    }

    /***************************************************************************
     * Iterator.
     ***************************************************************************/

    /**
     * Returns an iterator that iterates over the keys on this priority queue
     * in descending order.
     * The iterator doesn't implement {@code remove()} since it's optional.
     *
     * @return an iterator that iterates over the keys in descending order
     */
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {

        // create a new pq
        private IndexMaxPQ<Key> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            copy = new IndexMaxPQ<Key>(size());
            for (int i = 1; i <= n; i++)
                copy.insert(qp[i], keys[i]);
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Key next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return copy.delMax();
        }
    }

    public static void main(String[] args) {
        int n = 4;

        IndexMaxPQ<Integer> heap = new IndexMaxPQ<>(n);



        System.out.println("Inserting items");

        for (int i = 0; i < n ; i++) {
            int key = i;

            heap.insert(key, heap.size());
            System.out.println("Inserting key: " + key);
            System.out.println(heap);
            
        }

        System.out.println("Filled heap\n " + heap);
        System.out.println();
        System.out.println();

        int maxIndex = heap.maxIndex();
        System.out.println("maxIndex " + maxIndex);
        System.out.println();
        System.out.println();



        System.out.println("Deleting max values");
        for (int i = 0; i < n / 2; i++) {
            System.out.println("Deleting max: " + heap.delMax());
            System.out.println(heap);
            System.out.println();
        }

        System.out.println();
        System.out.println();


        System.out.println("Deleting smallest"); 
        for (int i = 0; i < n / 2; i++) {
            System.out.println("deleting k " + i);
            heap.delete(i);
            System.out.println(heap);
            System.out.println();
        }

        while(heap.size() != n) {
            //System.out.println(heap.size());
            int key = StdRandom.uniformInt(0, n);
            if (heap.contains(key) ) continue;

            heap.insert(key, heap.size());
            System.out.println("Inserting key: " + key);
            System.out.println(heap);
        }
        System.out.println("Refilled heap\n" + heap);
        System.out.println();
        System.out.println();


        while (!heap.isEmpty()) {
            int key = StdRandom.uniformInt(0, n);

            if (!heap.contains(key))
                continue;

            heap.delete(key);
            System.out.println("Removing key: " + key);
            System.out.println(heap);
        }




    }

}
