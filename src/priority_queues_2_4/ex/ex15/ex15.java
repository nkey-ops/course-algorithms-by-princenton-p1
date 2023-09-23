package priority_queues_2_4.ex;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * ex15
 */
public class ex15 {

    public static void main(String[] args) {
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;
        MinHeap h  = new MinHeap(n);

        for (int i = 0; i < n; i++) {
           h.insert(StdRandom.uniformInt(n)); 
        }

        System.out.println("Real heap");
        System.out.println(Arrays.toString(h.heap));
        System.out.println(isMinHeap(h.heap));
        System.out.println(isMinHeapOrdered(1, h.heap));
        System.out.println();

        System.out.println("False Heap");
        int[] falseHeap = StdRandom.permutation(n);
        System.out.println(Arrays.toString(falseHeap));
        System.out.println(isMinHeap(falseHeap));
        System.out.println(isMinHeapOrdered(1, falseHeap));
    }


    private static boolean isMinHeap(int[] heap) {
        for (int i = heap.length - 1; i > 0; i--) {
            if(heap[i / 2] > heap[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * MinPQ implementation
     */
    private static boolean isMinHeapOrdered(int k, int[] heap) {
        if (k > heap.length) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  < heap.length && heap[k] > heap[left] )  return false;
        if (right < heap.length && heap[k] > heap[right]) return false;
        return isMinHeapOrdered(left, heap) && isMinHeapOrdered(right, heap);
    }

    private static class MinHeap {
        final int[] heap;
        int size = 0;
        public MinHeap(int s) {
            this.heap = new int[s];
        }
       


        public void insert(int v) {
            if(size >= heap.length) 
                throw new IllegalArgumentException();

            heap[size++] = v;
            swim(size - 1);
        }

        private void swim(int i) {
            while(i / 2 >= 0 && heap[i / 2] > heap[i]) {
                    exch(i / 2, i);
                    i = i / 2;
            }
        }

        private void exch(int i, int i2) {
            int tmp = heap[i];
            heap[i] = heap[i2];
            heap[i2] = tmp;
        }

    }
}
