package bags_queues_and_stacks_1_3.cp.ex_37;

import edu.princeton.cs.algs4.Queue;

/**
 * Josephus problem.
 * In the Josephus problem from antiquity,
 * N people are in dire straits and agree to the following
 * strategy to reduce the population.
 * They arrange themselves in a circle (at positions numbered from 0 to N-1)
 * and proceed around the circle,
 * eliminating every Mth person until only one person is left.
 * Legend has it that Josephus figured out where to sit to avoid being
 * eliminated.
 * Write a Queue client Josephus.java that takes M and N from the command line
 * and prints out the order in which people are eliminated
 * (and thus would show Josephus where to sit in the circle)
 *
 *
 * 0 1 2 3 4 5 6
 * 6 0 2 4
 * 6 2
 * 6
 * 
 * 1 3 5
 * 0 4
 * 2
 */
public class JosephusProblem {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        int m = Integer.parseInt(args[0]), 
            n = Integer.parseInt(args[1]);


        for (int i = 0; i < n; i++)
            queue.enqueue(i);

        while (queue.size() >= m) {
            for (int i = 0; i < m - 1; i++)
                queue.enqueue(queue.dequeue());
            System.out.print(queue.dequeue() + " ");
        }

    }

}
