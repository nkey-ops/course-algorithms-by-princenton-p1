package priority_queues_2_4.ex.ex27;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;

/**
 * DynamiMedianFinding
 */
public class DynamiMedianFinding_INC<T extends Comparable<T>> {
    MaxPQ<T> maxPq= new MaxPQ<>();
    MinPQ<T> minPQ= new MinPQ<>();
    T v;

    public static void main(String[] args) {

    }


    public void insert(T value) {
        if(size() == 0 ) {
           minPQ.insert(value); 
        }else if(size() == 1) {
            if(minPQ.min().compareTo(value) < 0) {
                maxPq.insert(minPQ.delMin());
                minPQ.insert(value);
            }else 
                maxPq.insert(value);
        } else {
            if(v.compareTo(value) < 0){
                minPQ.insert(value);
                //replace(minPQ, v);
            }

        } 
            

    }

    public int size() {
        return maxPq.size() + minPQ.size() + (v  == null ? 0 : 1);    
    }


}
