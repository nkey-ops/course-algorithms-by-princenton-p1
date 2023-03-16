package unionfind_1_5.assignment;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private double mean;
	private double stddev;
	private double confidenceHi;
	private double confidenceLo;
	
	
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
    	if(n <= 0 || trials <= 0)
    		throw new IllegalArgumentException(
    				"n or trials cannot be lower or equal to zero");
    
    	run(n, trials);
    };

    private void run(int n, int trials) {
    	if(n <= 0 || trials <= 0)
    		throw new IllegalArgumentException(
    				"n or trials cannot be lower or equal to zero");
    	
    	int[] fractionsOfOpenSites = new int[trials];
    	
    	for (int i = 0; i < trials; i++) {
    		Percolation p = new Percolation(n);
    		
    		while (!p.percolates()) {
    			int row = StdRandom.uniformInt(1, n + 1);
    			int col = StdRandom.uniformInt(1, n + 1);

    			if (p.isOpen(row, col))
    				continue;
    			p.open(row, col);
    		}
    		
    		fractionsOfOpenSites[i] = p.numberOfOpenSites();
    	}
    	
    	int cells = Math.multiplyExact(n, n);
    	
    	mean = 1.0D * StdStats.mean(fractionsOfOpenSites) / cells;
		stddev = 1.0D * StdStats.stddev(fractionsOfOpenSites) / cells;
   
		confidenceLo = mean - ((1.96D * stddev) / Math.sqrt(trials));
		confidenceHi = mean + ((1.96D * stddev) / Math.sqrt(trials));
 		
	}

	// sample mean of percolation threshold
    public double mean() {
    	return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
    	return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
    	return confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
    	return confidenceHi;
    }

   // test client (see below)
   public static void main(String[] args) {
	   int n = Integer.parseInt(args[0]);
	   int t = Integer.parseInt(args[1]);
	   
	   PercolationStats p = new PercolationStats(n, t);
   
	   StdOut.printf("mean                    = %s\n", p.mean);
	   StdOut.printf("stddev                  = %s\n", p.stddev);
	   StdOut.printf("95%% confidence interval = [%s, %s]\n", p.confidenceLo, p.confidenceHi);
   
   
   
   }

}
