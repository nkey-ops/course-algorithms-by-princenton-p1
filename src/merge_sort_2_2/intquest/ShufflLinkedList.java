package merge_sort_2_2.intquest;

import static java.lang.Integer.compare;

import java.nio.channels.spi.AsynchronousChannelProvider;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import utils.Utils;

/**
 * @author deuru
 * 
 *         Shuffling a linked list. Given a singly-linked list containing n
 *         items, rearrange the items uniformly at random.
 *         Your algorithm should consume a logarithmic (or constant)
 *         amount of extra memory and run in
 *         time proportional to nlogn in the worst case.
 */
public class ShufflLinkedList {

    public static void main(String[] args) {
        int l = args.length > 0 ? Integer.parseInt(args[0]) : 3;

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < l; i++)
            list.add(i);


        System.out.println("List: " + list);
        // shuffle2(list);
        // System.out.println("sh " + list);
        bias(6_000_000, list);
        // if(args.length == 1 || args.length == 0)
        // System.out.println(shuffle2(list));
        // else
    }

    public static void bias(int times, LinkedList<Integer> list) {
        Map<int[], Integer> counts = new TreeMap<>(Arrays::compare);

        for (int i = 0; i < times; ++i) {
            LinkedList<Integer> l = (LinkedList<Integer>) list.clone();
            // shuffle2(l);

            counts.compute(
                    l.stream().mapToInt(a -> a).toArray(),
                    (k, v) -> v == null ? 1 : v + 1);
        }
        counts.entrySet()
                .stream()
                .sorted((e1, e2) -> compare(e1.getValue(), e2.getValue()))
                .forEach(e -> System.out.printf("%s | times: %s | prob: %.3f\n",
                        Arrays.toString(e.getKey()),
                        e.getValue(), (double) e.getValue() / times));
    }

    public static <T> void shuffleRd(LinkedList<T> l) {
        // System.out.println(l.size());
        if (l.size() <= 1)
            return;

        int s = l.size();
        LinkedList<T> l1 = new LinkedList<>(),
                l2 = new LinkedList<>();

        while (!l.isEmpty()) {
            l1.add(l.pollFirst());
            if (!l.isEmpty())
                l2.add(l.pollFirst());
        }

        // System.out.println(l2);
        // System.out.println(l1);
        // System.out.println(l.size());

        shuffleRd(l1);
        shuffleRd(l2);

        boolean isDummy = l2.size() < l1.size();

        merge(l, l1, l2, isDummy);
    }

    private static <T> void merge(LinkedList<T> l, LinkedList<T> l1,
            LinkedList<T> l2, boolean dummyNode) {

        T t = null;
        if (dummyNode) {
            int m = StdRandom.uniformInt(l2.size() + 1);
            l2.add(m, t = (T) new Object());
        }
        // skip if isdum && i == m
        // skip l2 at random
        // System.out.println(l2.size() - 1);
        int m = StdRandom.uniformInt(l2.size() + 1);

        int i = 0;
        // System.out.println(dummyNode + " " + m);
        // System.out.println(i++ != m && !dummyNode);
        while (!l1.isEmpty() || !l2.isEmpty()) {
            if (l1.isEmpty())
                l.add(l2.pollFirst());
            else if (l2.isEmpty())
                l.add(l1.pollFirst());
            else if (StdRandom.bernoulli())
                l.add(l1.pollFirst());
            else
                l.add(l2.pollFirst());
            // else if(!(i++ == m && dummyNode)) l.add(l2.pollFirst());
            // else l.add(l1.pollFirst());
        }

        if (dummyNode) {
            Iterator<T> iter = l.iterator();

            while (!iter.next().equals(t))
                ;
            iter.remove();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> LinkedList<T> shuffle(LinkedList<T> list) {
        // Do lg N passes of pairwise merges.
        Iterator<T> cIter = list.iterator();
        LinkedList<T> nList = new LinkedList<>();

        int n = list.size();
        T[] aux = (T[]) new Comparable[n];
        for (int len = 1; len < n; len *= 2) { // sz: subarray size
            int lo;
            for (lo = 0; lo < n - len; lo += len + len) { // lo: subarray index
                int mid = lo + len - 1;
                int hi = Math.min(lo + len + len - 1, n - 1);
                merge(list, aux, lo, mid, hi, cIter, nList);
            }

            // System.out.println(0 < n - lo && len == 1);
            for (int i = 0; i < n - lo; i++) {
                nList.add(cIter.next());
                // System.out.println(nList.getLast());
            }
            // System.out.println(nList + " ADded");
            list = nList;
            cIter = list.listIterator();
            nList = new LinkedList<>();
        }

        return list;
    }

    private static <T extends Comparable<T>> void merge(LinkedList<T> a, T[] aux,
            int lo, int mid, int hi, Iterator<T> cIter,
            LinkedList<T> list) {
        // System.out.println(a);
        // System.out.printf("%s %s %s\n", lo, mid, hi);
        for (int i = lo; i <= hi; i++) {
            aux[i] = cIter.next();
            // System.out.print(aux[i] + ", ");
        }
        // System.out.println();

        int l = lo, r = mid + 1;

        for (int i = lo; i <= hi; i++) {
            if (l > mid)
                list.add(aux[r++]);
            else if (r > hi)
                list.add(aux[l++]);
            else if (StdRandom.bernoulli())
                list.add(aux[l++]);
            // else if (aux[l].compareTo(aux[r]) < 0) list.add(aux[l++]);
            else
                list.add(aux[r++]);
        }

        // System.out.println(list + " Retr");
    }

    public static void shuffle(int[] arr) {
        shuffle(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static void shuffle(int[] arr, int[] aux, int lo, int hi) {

        if (lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2;
        shuffle(arr, aux, lo, mid);
        shuffle(arr, aux, mid + 1, hi);

        merge(arr, aux, lo, mid, hi);
    }

    private static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {

        for (int i = lo; i <= hi; i++)
            aux[i] = arr[i];

        int li = lo, ri = mid + 1;
        for (int i = lo; i <= hi; i++) {
            if (li > mid)
                arr[i] = aux[ri++];
            else if (ri > hi)
                arr[i] = aux[li++];
            else if (StdRandom.bernoulli())
                arr[i] = aux[ri++];
            else
                arr[i] = aux[li++];

        }

    }
}
