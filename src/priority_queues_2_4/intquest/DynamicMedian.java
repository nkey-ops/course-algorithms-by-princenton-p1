
package priority_queues_2_4.intquest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Dynamic median.
 * Design a data type that supports
 * insert in logarithmic time,
 * find-the-median in constant time,
 * and remove-the-median in logarithmic time.
 *
 * If the number of keys in the data type is even,
 * find/remove the lower median.
 */
public class DynamicMedian {
    private MaxPQ<Integer> maxHeap = new MaxPQ<>();
    private MinPQ<Integer> minHeap = new MinPQ<>();
    private int size = 0;

    public static void main(String[] args) {
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;

        DynamicMedian d = new DynamicMedian();
        List<Integer> testList = new ArrayList<>();


        for (int i = n; i > 0; i--) {
            int val = StdRandom.uniformInt(n);

            d.insert(val);
            testList.add(val);

            System.out.printf(
                    "Inserted: %s, mediana is: %s\n", val, d.med());

            assert d.med() == getMedian(testList); 
        }

        System.out.println();


        for (int i = 0; i < n; i++) {
            int oldMed = d.med();
            d.delMed();

            testList.remove(getMedian(testList));

            System.out.printf(
                    "Deleted median: %s, new mediana is: %s\n", 
                    oldMed,  d.isEmpty() ? "no meadian" : d.med());

            if(n != n)
                assert d.med() == getMedian(testList); 
        }


    }

    private static Integer getMedian(List<Integer> l) {
        if(l.isEmpty() ) return null;
        
        l.sort(Comparator.naturalOrder()); 
        return  l.get((l.size() - 1) / 2);
    }


    public void insert(int val) {
        if (size == 0)
            maxHeap.insert(val);
        else {
          if (val <= med()) {
              maxHeap.insert(val);
                if (size == 1 || maxHeap.size() - minHeap.size() == 2)
                    minHeap.insert(maxHeap.delMax());// 3 log(n/2)
          }else{
              minHeap.insert(val);
              if (minHeap.size() - maxHeap.size() == 2)
                  maxHeap.insert(minHeap.delMin());// 3 log(n/2)
          }  
            
        }

        size++;
    }

    public boolean isEmpty() {
        return size ==0; 
    }

    public int med() {
        if(size == 0) throw new RuntimeException("Heap is empty");
        else if(size == 1) return maxHeap.max();
        else return maxHeap.size() >= minHeap.size() 
                         ? maxHeap.max() : minHeap.min();
    }

    public void delMed(){
        if(size == 0)
            throw new RuntimeException("Heap is empty");

        maxHeap.delMax();
        size--;

        if(maxHeap.size() < minHeap.size())
            maxHeap.insert(minHeap.delMin());
     }

}
