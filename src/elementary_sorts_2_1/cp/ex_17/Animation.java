package elementary_sorts_2_1.cp.ex_17;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import java.awt.Color;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 *
 * <pre>
 * Animation.
 * Add code to Insertion and Selection to make them draw the array contents as vertical
 * bars like the visual traces in this section, redrawing the bars after each pass,
 * to produce an animated effect, ending in a “sorted” picture where the bars appear in
 * order of their height. Hint : Use a client like the one in the text that generates
 * random Double values, insert calls to show() as appropriate in the sort code,
 * and implement a show() method that clears the canvas and draws the bars.
 * </pre>
 */
public class Animation {
  private static int boundX = 50_000, boundY = 50_000;
  private static double penRadius;
  private static double penRadiusSize;

  private static int graphStartBoundX = (int) (boundX * 0.1);
  private static int graphEndBoundX = (int) (boundX - boundX * 0.1);
  private static int graphBotBoundY = (int) (boundY / 3);
  private static int graphTopBoundY = graphBotBoundY + (int) (boundY * 0.3);

  public static void main(String[] args) {
    int n = 50, min = 0, max = 100;
    animateSelection(n, min, max);
    animateInsertion(n, min, max);
  }

  private static void animateSelection(int n, int min, int max) {
    if (n < 0) {
      throw new IllegalArgumentException();
    }
    int[] arr = new int[n];

    penRadiusSize = (double) (graphEndBoundX - graphStartBoundX) / (n + 1);
    penRadius = penRadiusSize / boundX;

    for (int i = 0; i < arr.length; i++) {
      arr[i] = StdRandom.uniformInt(min, max);
    }

    System.out.println(Arrays.toString(arr));
    StdDraw.setTitle("Selection Sort");
    selectionSort(arr, min, max);
    System.out.println(Arrays.toString(arr));

    StdDraw.clear();
  }

  private static void animateInsertion(int n, int min, int max) {
    int[] arr = new int[n];

    penRadiusSize = (double) (graphEndBoundX - graphStartBoundX) / (n + 1);
    penRadius = penRadiusSize / boundX;

    for (int i = 0; i < arr.length; i++) {
      arr[i] = StdRandom.uniformInt(min, max);
    }

    System.out.println(Arrays.toString(arr));
    StdDraw.setTitle("Insertion Sort");
    insertionSort(arr, min, max);
    System.out.println(Arrays.toString(arr));

    StdDraw.clear();
  }

  public static void selectionSort(int[] arr, int min, int max) {
    print(arr, min, max);
    int waitPerExch = 10000 / (arr.length);

    for (int i = 0; i < arr.length - 1; i++) {
      int sm = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[sm]) sm = j;
      }

      try {
        Thread.sleep(waitPerExch);
      } catch (InterruptedException e) {
        throw new RuntimeException(e); }
      swap(arr, i, sm, min, max);

      int tmp = arr[i];
      arr[i] = arr[sm];
      arr[sm] = tmp;
    }
  }

  private static void insertionSort(int[] arr, int min, int max) {
    Objects.requireNonNull(arr);
    print(arr, min, max);

    int waitPerExch = 10000 / (arr.length * (arr.length - 1) / 2);

    for (int i = 1; i < arr.length; i++) {
      for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--) {

        try {
          Thread.sleep(waitPerExch);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        swap(arr, j, j + 1, min, max);

        int tmp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = tmp;
      }
    }
  }

  public static void print(int[] arr, int min, int max) {
    Objects.requireNonNull(arr);

    StdDraw.setCanvasSize(1000, 1000);
    StdDraw.setXscale(0, boundX);
    StdDraw.setYscale(0, boundY);
    StdDraw.setPenRadius(penRadius);
    StdDraw.setPenColor(Color.RED);

    StdDraw.setPenColor(Color.BLACK);
    StdDraw.point(graphStartBoundX, graphBotBoundY);
    StdDraw.point(graphEndBoundX, graphBotBoundY);

    StdDraw.setPenColor(Color.RED);

    for (int i = 0; i < arr.length; i++) {
      int r = arr[i];
      if (r < min || r >= max) {
        throw new IllegalArgumentException(
            String.format("Value %s is smaller than %s or bigger than %s", r, min, max));
      }

      double x = calcX(i, graphStartBoundX, penRadiusSize);
      double y = calcY(r, max, graphTopBoundY, graphBotBoundY);

      StdDraw.line(x, graphBotBoundY, x, y);
    }
  }

  public static void swap(int[] arr, int a, int b, int min, int max) {
    Objects.requireNonNull(arr);
    if (a < 0 || a > arr.length || b < 0 || b > arr.length) {
      throw new IllegalArgumentException();
    }

    int varA = arr[a];
    int varB = arr[b];

    if (varA < 0 || varA >= max || varB < 0 || varB >= max) throw new IllegalArgumentException();

    var oldColor = StdDraw.getPenColor();
    StdDraw.setPenColor(Color.WHITE);

    double ax = calcX(a, graphStartBoundX, penRadiusSize);
    double ay = calcY(varA, max, graphTopBoundY, graphBotBoundY);

    double bx = calcX(b, graphStartBoundX, penRadiusSize);
    double by = calcY(varB, max, graphTopBoundY, graphBotBoundY);

    StdDraw.line(ax, graphBotBoundY, ax, ay);
    StdDraw.line(bx, graphBotBoundY, bx, by);

    StdDraw.setPenColor(oldColor);

    StdDraw.line(bx, graphBotBoundY, bx, ay);
    StdDraw.line(ax, graphBotBoundY, ax, by);
  }

  private static int calcY(int val, int max, int graphTopBoundY, int graphBotBoundY) {
    return graphBotBoundY + ((val * 100 / max) * (graphTopBoundY - graphBotBoundY) / 100);
  }

  private static double calcX(int i, int graphStartBoundX, double penRadiusSize) {
    return graphStartBoundX + (penRadiusSize * (i + 1));
  }
}
