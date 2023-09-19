package priority_queues_2_4.ex.ex3;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Provide priority queue implementations
 * that support insert and remove the maximum,
 * one for each of the following underlying data structures:
 * unordered array,
 * ordered array,
 * unordered linked list, and
 * ordered linked list.
 *
 * Give a table of the worst-case bounds for each operation
 * for each of your four implementations from the previous exercise.
 *
 */
public class ex3 {

    public static void main(String... args) {
        int[] arr = StdRandom.permutation(
                args.length == 1 ? Integer.parseInt(args[0]) : 10);

        System.out.println("Test Data: \n" + Arrays.toString(arr));


        testUnorderedQueue(arr);
        testOrderedQueue(arr);

        testLinkedUnodrderedQueue(arr);
        testLinkedOrderedQueue(arr);
    }

    /**
     *
     * {@link #put(int)} O(N)
     * {@link #pop()} O(1)
     *
     */
    public static class OrderedQueue {
        private int[] q;
        private int l = -1;

        public OrderedQueue(int n) {
            this.q = new int[n];
        }

        public void put(int v) {
            if (l >= q.length - 1)
                throw new IllegalArgumentException();

            int m = l + 1;
            for (int i = 0; i < q.length; i++) {
                if (q[i] > v) {
                    m = i;
                    break;
                }
            }

            for (int i = l; i >= m; i--)
                q[i + 1] = q[i];

            q[m] = v;
            l++;
        }

        public int pop() {
            if (l == -1)
                throw new IllegalArgumentException();

            return q[l--];
        }
    }

    /**
     *
     * {@link #put(int)} O(1)
     * {@link #pop()} O(N)
     *
     */
    public static class UnorderedQueue {
        private int[] q;
        private int l = -1;

        public UnorderedQueue(int n) {
            this.q = new int[n];
        }

        public void put(int v) {
            if (l >= q.length - 1)
                throw new IllegalArgumentException();
            q[++l] = v;
        }

        public int pop() {
            if (l == -1)
                throw new IllegalArgumentException();

            int v = 0;
            for (int i = 1; i <= l; i++)
                if (q[i] > q[v])
                    v = i;

            int k = q[v];

            for (int i = v; i <= l; i++)
                q[v] = q[i];

            l--;

            return k;
        }
    }

   /**
     * {@link #put(int)} O(1)
     * {@link #pop()} O(N)
     */
    public static class LinkedUnorderedQueue {
        private Node enque;
        private Node top;

        private int l = -1;

        public void put(int v) {
            if (l == -1) {
                enque = new Node(v);
                top = enque;
            } else
                enque = enque.next = new Node(v);

            l++;
        }

        public int pop() {
            if (l == -1)
                throw new IllegalArgumentException();

            if (l == 0) {
                l--;
                int v = top.v;
                top = null;
                enque = null;

                return v;
            }

            Node m = top, mp = null;
            for (Node c = top, p = null; c != null; p = c, c = c.next) {
                if (c.v > m.v) {
                    m = c;
                    mp = p;
                }
            }

            if (m == top)
                top = top.next;
            else
                mp.next = m.next;
            if (m == enque)
                enque = mp;

            l--;

            return m.v;
        }
    }

   /**
     * {@link #put(int)} O(N)
     * {@link #pop()} O(1)
     */
    public static class LinkedOrderedQueue {
        private Node deque;

        private int l = -1;

        public void put(int v) {
            Node node = new Node(v);

            if (l == -1) {
                deque = node;
                l++;
                return;
            }

            Node c = deque, p = null;
            while (c != null && c.v > v) {
                p = c;
                c = c.next;
            }

            if (c == deque) {
                node.next = deque;
                deque = node;
            } else {
                if (c != null)
                    node.next = c;
                p.next = node;
            }

            l++;
        }

        public int pop() {
            if (l == -1)
                throw new IllegalArgumentException();

            int v = deque.v;
            deque = deque.next;

            l--;
            return v;
        }
    }

    private static void testUnorderedQueue(int[] arr) {
        int n = arr.length;
        UnorderedQueue uq = new UnorderedQueue(n);
        int[] a = new int[arr.length];

        for (int i = 0; i < n; i++)
            uq.put(arr[i]);
        for (int i = 0; i < n; i++)
            a[i] = uq.pop();


        System.out.println("Unordered Queue:\n" + Arrays.toString(a));
        assert isOrdered(a);
    }

    private static void testOrderedQueue(int[] arr) {
        int n = arr.length;
        OrderedQueue uq = new OrderedQueue(n);
        int[] a = new int[arr.length];

        for (int i = 0; i < n; i++)
            uq.put(arr[i]);
        for (int i = 0; i < n; i++)
            a[i] = uq.pop();

        System.out.println("Ordered Queue:\n" + Arrays.toString(a));
        assert isOrdered(a);
    }

    private static void testLinkedUnodrderedQueue(int[] arr) {
        int n = arr.length;
        LinkedUnorderedQueue uq = new LinkedUnorderedQueue();
        int[] a = new int[arr.length];

        for (int i = 0; i < n; i++)
            uq.put(arr[i]);
        for (int i = 0; i < n; i++)
            a[i] = uq.pop();

        System.out.println("Linked Unordered Queue:\n" + Arrays.toString(a));
        assert isOrdered(a);
    }

    private static void testLinkedOrderedQueue(int[] arr) {
        int n = arr.length;
        LinkedOrderedQueue uq = new LinkedOrderedQueue();
        int[] a = new int[arr.length];

        for (int i = 0; i < n; i++)
            uq.put(arr[i]);
        for (int i = 0; i < n; i++)
            a[i] = uq.pop();

        System.out.println("Linked Ordered Queue:\n" + Arrays.toString(a));
        assert isOrdered(a);
    }

    private static class Node {
        private int v;
        private Node next;

        public Node(int v) {
            this.v = v;
        }
    }

    private static boolean isOrdered(int[] a) {
        int prev = a[0], c;

        for (int i = 1; i < a.length; i++) {
            c = a[i];
            if (prev < c)
                return false;
            prev = c;
        }

        return true;
    }

}
