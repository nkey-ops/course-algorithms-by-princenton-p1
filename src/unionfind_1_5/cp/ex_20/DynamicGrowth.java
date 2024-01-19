package unionfind_1_5.cp.ex_20;

import edu.princeton.cs.algs4.StdRandom;

/**
 *
 *
 * <pre>
 * 1.5.20 Dynamic growth.
 * Using linked lists or a resizing array, develop a weighted quick-union
 * implementation that removes the restriction on needing the number of objects ahead of time.
 * Add a method newSite() to the API, which returns an int identifier.
 *
 * </pre>
 */
public class DynamicGrowth {
  /**
   * data[0] is empty to prevent intialization of the array in constructor with data[i] = i values
   * which means that the site is conntected to itself if its value is 0.
   */
  private int[] data;
  private int[] sizes;

  private int size;
  private int components;

  public DynamicGrowth() {
    this(10);
  }

  /**
   * Creat an dynamic-size weighted quick-union data structure
   * with the provided size.
   * With the call to {@link DynamicGrowth#newSite()} the size
   * can be increased by 1
   *
   * @param size starting size of the data structure.
   */
  public DynamicGrowth(int size) {
    if (size < 0) {
      throw new IllegalArgumentException();
    }

    this.size = size;
    this.data = new int[size + 1];
    this.sizes = new int[size + 1];
    this.components = size;
  }

  /**
   * Performs search of the component identifier of
   * the provide site 
   *
   * Time Complexity:
   * Ω (1)
   * O (log n)
   *
   * @param p side to find component identifer of.
   * @return component identifier of the site with ID: {@code p}
   */
  public int find(int p) {
    if (p < 0 || p >= size) {
      throw new IllegalArgumentException();
    }

    p++;

    int v;
    while ((v = data[p]) != p && v != 0) {
      p = v;
    }

    assert p != 0;
    return p;
  }

  /**
   * Performs union operation of two sites if they aren't 
   * a part of the same component 
   * 
   * Time Complexity:
   * Ω (1)
   * O (2 log n)
   *
   * @param p site to unite with {@code q}
   * @param q site to unite with {@code p}
   */
  public void union(int p, int q) {
    if (p < 0 || q < 0 || p >= size || q >= size) {
      throw new IllegalArgumentException(
          String.format(
              "Value p: %s or q %s is smaller than zero or bigger than size %s", p, q, size));
    }

    if (p == q) {
      return;
    }

    int pID = find(p);
    int qID = find(q);

    if (pID == qID) return;

    if (sizes[pID] < sizes[qID]) {
      data[pID] = qID;
      sizes[qID] += sizes[pID];
    } else {
      data[qID] = pID;
      sizes[pID] += sizes[qID];
    }

    components--;
  }

  /**
   * Increase the size of the datastrure by 1 if
   * there is available space or creates a new one twice as big
   * 
   * Time Complexity:
   * Ω (1)
   * O (N)
   *
   * @return the ID of the newly added site.
    */
  public int newSite() {
    if (data.length - 1 - size == 0) {
      int[] tmpData = new int[Math.multiplyExact(size, 2)];
      int[] tmpSizes = new int[Math.multiplyExact(size, 2)];

      for (int i = 0; i < data.length; i++) {
        tmpData[i] = data[i];
        tmpSizes[i] = sizes[i];
      }

      this.data = tmpData;
      this.sizes = tmpSizes;
    }

    components++;
    return size++;
  }

  /**
   * Returns the number of components.
   *
   * @return the number of components. 
   */
  public int count() {
    return components;
  }

  /**
   * Returns the total number of sites 
   *
   * @return the total number of sites 
   */
  public int size() {
    return size;
  }

  public static void main(String[] args) {
    DynamicGrowth dg = new DynamicGrowth();

    int n = 100;
    for (int i = 0; i < n; i++) {
      int p = StdRandom.uniformInt(dg.size());
      int q = StdRandom.uniformInt(dg.size());

      if (i == dg.size()) {
        p = dg.newSite();
      }

      dg.union(p, q);
      System.out.printf("Union of %s : %s\n", p, q);
      System.out.println("Components:" + dg.count());
      System.out.println();
    }
  }
}
