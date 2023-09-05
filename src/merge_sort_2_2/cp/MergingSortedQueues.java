package merge_sort_2_2.cp;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 2.2.14 Merging sorted queues. 
 * Develop a static method that takes two queues of sorted
 * items as arguments and returns a queue that results from merging the queues
 * into sorted order.
 */
public class MergingSortedQueues {

    public static void main(String[] args) {
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;

        Queue<Integer> q1 = new ArrayDeque<Integer>();
        Queue<Integer> q2 = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                q1.add(i);
            else
                q2.add(i);
        }

        System.out.println(q1);
        System.out.println(q2);
        System.out.println(sort(q1, q2));

    }

    public static Queue<Integer> sort(Queue<Integer> a,
                                      Queue<Integer> b) {

        Queue<Integer> queue = new ArrayDeque<Integer>(a.size() + b.size());

        while (!a.isEmpty() || !b.isEmpty()) {
            if (a.isEmpty())                queue.add(b.poll());
            else if (b.isEmpty())           queue.add(a.poll());
            else if (a.peek() < b.peek())   queue.add(a.poll());
            else                            queue.add(b.poll());
        }

        return queue;
    }

}
