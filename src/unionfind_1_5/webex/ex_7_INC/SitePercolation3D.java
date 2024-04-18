package unionfind_1_5.webex.ex_7;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

// 2d
public class SitePercolation3D {
  private int[] data;
  private int sideLength;
  private int count;

  public SitePercolation3D(int n) {
    if (n < 0) throw new IllegalArgumentException("N cannot be below zero");

    this.count = n;
    this.sideLength = n;
    this.data = new int[n * n];

    for (int i = 0; i < data.length; i++) {
      if(i < n) data[i] = 0; 
      else if(i >= data.length - n) data[i] = data.length - 1;
      else 
      data[i] = i;
    }
  }


  public int find(int x, int y) {
    validate(x, y, sideLength);

    int p = (y - 1) * sideLength + (x - 1);
    System.out.printf("x %s y %s p %s\n", x, y, p);

    int root = p;
    while (data[root] != root) root = data[root];

    // while(data[p] != p) {
    //	int tmp = p;
    //	p = data[p];
    //	data[tmp] = root;
    // }

    return root;
  }

  private static void validate(int x, int y, int sideLength) {
    if (x < 1 || y < 1 || x > sideLength || y > sideLength) 
      throw new IllegalArgumentException(
          String.format("x %s y %s side %s | Invalid", x, y, sideLength));
  }

  public int count() {
    return count;
  }

  public boolean connected(int xp, int yp, int xq, int yq) {
    validate(xp, yp, sideLength);
    validate(xq, yq, sideLength);

    return find(xp, yp) == find(xq, yq);
  }

  public boolean isPercolated() {
    return connected(1, 1, sideLength, sideLength);
  }

  public void union(int xp, int yp, int xq, int yq) {
    validate(xp, yp, sideLength);
    validate(xq, yq, sideLength);

    // are the same
    int pR = find(xp, yp);
    int qR = find(xq, yq);

    if (pR > qR) data[qR] = pR;
    else data[pR] = qR;

    count--;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%s x %s", sideLength, sideLength));
    sb.append(System.lineSeparator());

    for (int y = 0; y < sideLength; y++) {
      for (int x = 0; x < sideLength; x++) {
        int i = y * sideLength + x;
        int v = data[i];
        sb.append(v == i ? "▢ " : "▣ ");
      }
      sb.append(System.lineSeparator());
    }
    return sb.toString();
  }

  private void validate(int p) {
    if (p < 0 || p >= data.length)
      throw new IllegalArgumentException(
          "p cannot be below zero or higher than " + (data.length - 1));
  }

  public static void main(String[] args) {
    int n = 10;
    double p = 0.5;

    for (int i = 0; i < args.length; i++) {
      switch(args[i]) {
        case "-n" -> n = Integer.parseInt(args[++i]);
        case "-p" -> p = Double.parseDouble(args[++i]);
      } 
    } 
    


    //	if(args.length != 1) {
    //		System.err.printf("Usage [n]\n " + "n - [0, n)");
    //		System.exit(1);
    //	}

    SitePercolation3D uf = new SitePercolation3D(n);
    System.out.println(uf);

    for (int y = 2; y <= n; y++) {
      for (int x = 2; x <= n; x++) {


        if(Math.random() > p) continue;

        int dx = x + (StdRandom.bernoulli() ? -1 : 1);
        int dy = y + (StdRandom.bernoulli() ? -1 : 1);

        if(dx < 1 || dx > n || dy < 1 || dy > n) continue;


        uf.union(x, y,dx, dy);
        System.out.println(uf);
      }
    }

    System.out.println(uf);
    StdOut.println(uf.count() + " components");
    System.out.println("Is Percolated: " + uf.isPercolated());
  }


//jhttps://github.com/reneargento/algorithms-sedgewick-wayne/blob/master/src/chapter2/section3/Exercise19_MedianOf5Partitioning.java
}
