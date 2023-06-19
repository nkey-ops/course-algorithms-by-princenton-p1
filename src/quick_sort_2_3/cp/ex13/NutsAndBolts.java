package quick_sort_2_3.cp.ex13;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Nuts and bolts. (G. J. E. Rawlins).
 * You have a mixed pile of N nuts and N bolts
 * and need to quickly find the corresponding pairs of nuts and bolts.
 *
 * Each nut matches exactly one bolt, and each bolt matches exactly one nut.
 * By fitting a nut and bolt together, you can see which is bigger.
 *
 * But it is not possible to directly compare two nuts or two bolts.
 * Given an efficient method for solving the problem.
 *
 */
public class NutsAndBolts {

    public static void main(String[] args) {
        int pairs = args.length == 1 ? Integer.parseInt(args[0]) : 10;
        if (pairs <  0)
            throw new IllegalArgumentException();


        int[] a = StdRandom.permutation(pairs);
        int[] b = StdRandom.permutation(pairs);
        NutOrBolt[] s = new NutOrBolt[pairs * 2];

        for (int i = 0; i < s.length; i++)
            s[i] = i < a.length ? 
                new NutOrBolt(true, a[i]) : 
                new NutOrBolt(false, b[i - b.length]);

        StdRandom.shuffle(s);


        System.out.println("Array: " +  Arrays.toString(s));
        sort(s);
        System.out.println("Paired: " + Arrays.toString(s));

        assert isPaired(s, 0, s.length - 1);

    }
   
    public static void sort(NutOrBolt[] pile) {
        sort(pile, 0, pile.length - 1);
    }

    private static void sort(NutOrBolt[] pile, int lo, int hi) {
        if (lo + 1 >= hi) return; 

        int li = lo, gi = hi;
        int i = li + 1;

        NutOrBolt v = pile[lo];
        while (i <= gi) {

            int cmp = pile[i].compare(v);

            if (cmp < 0)        exch(pile, li++, i++);
            else if (cmp > 0)   exch(pile, gi--, i);
            else if (v.isNut != pile[i].isNut) { // moving v pair to the end
                exch(pile,  gi, i);
                exch(pile,  gi--, hi);
            } else i++; 
        }
        
        // moving "v"'s pair to be begging of equals values of "v"        
        exch(pile, hi, gi + 1); 
        exch(pile, gi + 1, gi); 
        exch(pile, gi, li);     
             
        sort(pile, li, gi + 1); // sorts values equal to v 
 
        // finds where "v" value will be placed with its pair 
       int l = lo + (li - lo) * 2; 

       if(li!=  gi){
           sort(pile, lo,  l - 1);
           sort(pile, l + 2, hi);
       }
    }

       private static void exch(NutOrBolt[] arr, int i, int k) {
        NutOrBolt tmp = arr[i];
        arr[i] = arr[k];
        arr[k] = tmp;
    }

    private static boolean isPaired(NutOrBolt[] arr, int lo, int hi ){
        for (int i = lo + 1; i <= hi; i+=2) {

          if(arr[i - 1].isNut == arr[i].isNut
                  || arr[i - 1].v != arr[i].v) 
            return false;
        }
        return true;
    }

    private static class NutOrBolt {
        private final boolean isNut;
        private final int v;

        public NutOrBolt(boolean isNut, int v) {
            this.isNut = isNut;
            this.v = v;
        }

        public int compare(NutOrBolt b) {
            if (this.isNut && b.isNut)        return 0;
            else if (!this.isNut && !b.isNut) return 0;
            else
                return Integer.compare(this.v, b.v);
        }

        public String toString() {
            return String.format("(%s : %s)", isNut ? "N" : "B", v);
        }

    }
}
