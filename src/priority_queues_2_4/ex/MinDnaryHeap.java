package priority_queues_2_4.ex;

import java.util.Arrays;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdRandom;

public class MinDnaryHeap {
    final int[] heap;
    int size = 0;
    int d = 2;

    public MinDnaryHeap(int s, int d) {
        this.heap = new int[s + 1];
        this.d = d;
    }

    public static void main(String[] args) {
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;
        MinDnaryHeap h = new MinDnaryHeap(n, 2);
        MinPQ<Integer> ex = new MinPQ<>(n);

        for (int i = 0; i < n; i++) {
            int v = StdRandom.uniformInt(n * 2);
            h.insert(v);
            ex.insert(v);
            System.out.println(Arrays.toString(h.heap));
        }

        while (h.size != 0) {
            int v = h.removeMin();
            int exp = ex.delMin();

            System.out.println(v);
            System.out.println("exp " + exp);
            System.out.println(Arrays.toString(h.heap));
            System.out.println();
            assert v == exp;
        }
    }

    public void insert(int v) {
        if (size >= heap.length)
            throw new IllegalArgumentException();

        heap[++size] = v;
        swim(size);
    }

    public int removeMin() {
        if (size == 0)
            throw new IllegalArgumentException();

        int v = heap[1];
        exch(1, size);
        heap[size--] = 0;
        sink(1);

        return v;
    }

    private void sink(int i) {
        while (i * d - d + 2 <= size) {
            int j = i * d - d + 2;

            // find smallest on the level
            int m = j;
            for (int j2 = j; j2 <= size && j2 < j + d; j2++)
                if (heap[j2] < heap[m])
                    m = j2;
            j = m;

            if (heap[i] < heap[j]) return;
            exch(i, j);
            i = j;
        }
    }

    private void swim(int i) {
        for (int j = (i + d - 2) / d; 
                j > 0 && heap[j] > heap[i]; 
                j = (j + d - 2) / d) {

            exch(j, i);
            i = j;
        }
    }

    private void exch(int i, int i2) {
        int tmp = heap[i];
        heap[i] = heap[i2];
        heap[i2] = tmp;
    }
}
