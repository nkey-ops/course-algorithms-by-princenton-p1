package priority_queues_2_4.ex.ex22;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Array resizing. 
 * Add array resizing to MaxPQ, and prove bounds like those of
 * Proposition Q for array accesses, in an amortized sense.
 */

public class ArrayResizing {

    public static void main(String[] args) {
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;

        MaxPQWithArrayResizing<Integer> heap = new MaxPQWithArrayResizing<>();

        for (int i = 0; i < n; i++) {
            heap.insert(StdRandom.uniformInt(n));
            System.out.println(Arrays.toString(heap.pq)) ;
                ;
        }

        for (int i = 0; i < n; i++) {
            heap.delMax()
                ;
            System.out.println(Arrays.toString(heap.pq));
        }
    }

    private static class MaxPQWithArrayResizing<Key extends Comparable<Key>> {
        private Key[] pq; // store items at indices 1 to n
        private int n; // number of items on priority queue
        private Comparator<Key> comparator; // optional comparator

        @SuppressWarnings("unchecked")
        public MaxPQWithArrayResizing() {
            this.pq = (Key[]) new Comparable[2];
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
            return pq[1];
        }

        /**
         * Adds a new key to this priority queue.
         *
         * @param x the new key to add to this priority queue
         */
        public void insert(Key x) {
            // double size of array if necessary
            if (n >= (pq.length - 1) * 0.75)
                increaseSize();

            // add x, and percolate it up to maintain heap invariant
            pq[++n] = x;
            swim(n);
            assert isMaxHeap();
        }

        @SuppressWarnings("unchecked")
        private void increaseSize() {
            Key[] arr = (Key[]) new Comparable[(pq.length - 1) * 2 + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = pq[i];
            }

            pq = arr;
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

            Key max = pq[1];
            exch(1, n--);
            sink(1);
            pq[n + 1] = null; // to avoid loitering and help with garbage collection

            if (n > 0 && n - 1 <= (pq.length - 1) * 0.25)
                decreaseSize();

            assert isMaxHeap();
            return max;
        }

        @SuppressWarnings("unchecked")
        private void decreaseSize() {
            Key[] arr = (Key[]) new Comparable[pq.length / 2];
            for (int i = 1; i <= n; i++) {
                arr[i] = pq[i];
            }

            pq = arr;

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
            if (comparator == null) {
                return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
            } else {
                return comparator.compare(pq[i], pq[j]) < 0;
            }
        }

        private void exch(int i, int j) {
            Key swap = pq[i];
            pq[i] = pq[j];
            pq[j] = swap;
        }

        // is pq[1..n] a max heap?
        private boolean isMaxHeap() {
            for (int i = 1; i <= n; i++) {
                if (pq[i] == null)
                    return false;
            }
            for (int i = n + 1; i < pq.length; i++) {
                if (pq[i] != null)
                    return false;
            }
            if (pq[0] != null)
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
    }
}
