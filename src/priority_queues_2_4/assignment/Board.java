
package priority_queues_2_4.assignment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.StdRandom;


/**
 * Board
 */
public class Board {
    private final int[] tiles;  
    private final int n;

    private int empCellIndex;
    private int hamming;
    private int manhattan;
    private boolean isGoal;

    private final int x1, x2, y1, y2;
    
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        if(tiles == null 
                || tiles.length < 2
                || tiles.length != tiles[0].length)
            throw new IllegalArgumentException();

        this.n = tiles.length;
        this.tiles = new int[n*n];    

        int hamming = 0; 
        int manhattan = 0; 
        boolean isGoal = true;

        for (int i = 0, y = 0; y < n; y++) {
            for (int x = 0; x < n; x++, i++) {

                if(tiles[y][x] == 0) {empCellIndex = i;}

                if(!isAtFinalPosition(tiles, y, x)){
                    hamming++ ;
                    isGoal = false;
                }   

                manhattan += calcManhattan(tiles, y, x); 
                this.tiles[i]= tiles[y][x];
            }
        }

        int x1, x2, y1, y2;

        do {
             x1 =  StdRandom.uniformInt(0, n); 
             y1 =  StdRandom.uniformInt(0, n); 

             x2 =  StdRandom.uniformInt(0, n); 
             y2 =  StdRandom.uniformInt(0, n); 

        } while (x1 == x2 && y1 == y2 
                || tiles[x1][y1] == 0 
                || tiles[x2][y2] == 0 );
      
        
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

        this.hamming = hamming;
        this.manhattan = manhattan;
        this.isGoal = isGoal;
    }


    private boolean isAtFinalPosition(int[][] tiles, int y, int x) {
        return tiles[y][x] == 0 || n * y + x + 1 == tiles[y][x];
    }

    private int calcManhattan(int[][] tiles, int y, int x) {
        int curr = tiles[y][x];

        if(curr == 0) return 0;

        curr--;
        int ey =  curr / n ;
        int ex =  curr - ey * n;

        return Math.abs(y - ey) + Math.abs(x - ex);
    }
                                           
    // string representation of this board
    public String toString(){
        String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder(
                              n * n * 2 
                            + n * lineSeparator.length());
        sb.append(n);

        for (int i = 0; i < tiles.length; i++) {
            if(i % n == 0) sb.append(lineSeparator);
            sb.append(" ").append(tiles[i]);
        }

        return sb.toString();
    }

    // board dimension n
    public int dimension() {return n;}

    // number of tiles out of place
    public int hamming() {
        return hamming;
    }

    public int manhattan() {
        return manhattan;
    }

    
    // is this board the goal board?
    public boolean isGoal(){
        return isGoal;
    }

    // does this board equal y?
    public boolean equals(Object o) {
        if(o == null) return false;
        if(this == o) return true;

        if(!(o instanceof Board)) return false;
        Board that = (Board) o;
        
        return this.n == that.n
                && this.manhattan == that.manhattan
                && this.hamming == that.hamming
                && this.isGoal == that.isGoal
                && this.empCellIndex == that.empCellIndex
                && Arrays.equals(this.tiles, that.tiles) ;
    }

    // all neighboring boards
    public Iterable<Board> neighbors(){
        int[] dir = new int[]{-1, 0, 1, 0};
        List<Board> neighbors = new ArrayList<>();

        int empY = empCellIndex / n;
        int empX = empCellIndex % n;

        for (int i = 0; i < dir.length; i++) {
            int dY = empY + dir[i];
            int dX = empX + dir[dir.length - i - 1];

            if (!isCorrect(dY, dX, n))
                continue;
            neighbors.add(
                    getNeighbor( dY, dX));
        }

        neighbors.sort((a,b) -> Integer.compare(a.manhattan, b.manhattan));
        return neighbors;

    }

    // a board that is obtained by exchanging any pair of tiles
    private Board getNeighbor( int dY, int dX) {
        if(!isCorrect(dY, dX, n) || tiles[empCellIndex] != 0) 
            throw new IllegalArgumentException();
        
        int[][] neighbor = new int[n][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                neighbor[y][x] = tiles[getIndex(x, y, n)];  
            }
        } 

        neighbor[empCellIndex / n ][empCellIndex % n] = neighbor[dY][dX];
        neighbor[dY][dX] = 0;

        
        return new Board(neighbor);
    }

    private static int getIndex(int x, int y, int n)  {
        if(!isCorrect(y, x, n))
            throw new IllegalArgumentException();
       return y * n + x;
    }

    private static boolean isCorrect(int y, int x, int n ) {
        return y >= 0 && y < n 
            && x >= 0 && x < n;
    }

    public Board twin(){
        int[][] neighbor = new int[n][n];      

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                neighbor[y][x] = tiles[getIndex(x, y, n)];  
            }
        } 

        int v = neighbor[x1][y1];
        neighbor[x1][y1] = neighbor[x2][y2];
        neighbor[x2][y2] = v;

        Board b =  new Board(neighbor);
       return b;
    }

    // unit testing (not graded)
    public static void main(String[] args) {

        test( new int[][]
            {{0, 1, 3},
             {4, 2, 5},
             {7, 8, 6},
            } , 4, 4, false);


        test( new int[][]
            {{1, 2, 3},
             {0, 7, 6},
             {5, 4, 8},
            } , 4, 7,  false);

       test( new int[][]
           {{3, 1},
            {0, 2}
           }, 3, 3,  false);

       test( new int[][]
           {{0, 4, 7},
            {8, 5, 2},
            {3, 6, 1},
           }, 7, 20,  false);

        testEquals();
        testNeighbors();


        assert getIndex(0, 0, 2) == 0 ;
        assert getIndex(1, 0, 2) == 1 ;
        assert getIndex(2, 0, 3) == 2 ;
        assert getIndex(0, 1, 3) == 3 ;
        assert getIndex(1, 1, 3) == 4 ;

    }


    private static void testNeighbors() {
        Board b1  = new Board( 
                new int[][]
                   {{1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 0}});  

       int[][] n1 =  
                   {{1, 2, 3},
                    {4, 5, 0},
                    {7, 8, 6}};
       int[][] n2 =  
                   {{1, 2, 3},
                    {4, 5, 6},
                    {7, 0, 8}};

        Board[] expNeighbors = {new Board(n1), new Board(n2)};

        List<Board> neighbors = new ArrayList<>();
        b1.neighbors().forEach(neighbors::add);


        for (Board expNeighbor : expNeighbors) {
           boolean isFound = false;
           for (Board actNeighbor : neighbors) {
                if(expNeighbor.equals(actNeighbor))
                    isFound = true;
           } 
           assert isFound;
        }
    }


    private static void test(int[][] tiles,
            int expHamming, 
            int expManhattan, 
            boolean expIsGoal) {
        Board board = new Board(tiles);
        System.out.println(board);

        System.out.println("Hamming: " + board.hamming()); assertEquals(board.hamming(), expHamming, "Hamming"); 

        System.out.println("Manhattan: " + board.manhattan());
        assertEquals(board.manhattan(), expManhattan, "Manhattan"); 

        System.out.println("Is Goal: " + board.isGoal());
        assertEquals(board.isGoal(), expIsGoal , "isGoal"); 


        System.out.println();
        System.out.println();
    }

    private static void assertEquals(int act, int exp, String s) {
        if(act != exp)
            throw new AssertionError(
                   s + " exp " + exp + "!=  act " + act); 
    }

    private static void assertEquals(boolean act, boolean  exp, String s) {
        if(act != exp)
            throw new AssertionError(
                   s + " exp " + exp + "!=  act " + act); 
    }
   
    private static void testEquals() {
        Board b1  = new Board( 
                new int[][]
                {{1, 2, 3},
                 {4, 5, 6},
                 {7, 8, 0}});  

        Board b2  = new Board( 
                new int[][]
                {{1, 2, 3},
                 {4, 5, 6},
                 {7, 8, 0}});  

        Board b3  = new Board( 
                new int[][]
                {{1, 2, 3},
                 {4, 5, 6},
                 {7, 8, 0}});  
        
        //check reflexiveness
        assert b1.equals(b1); 
        //check  symmetric
        assert b1.equals(b2) == b2.equals(b1);
        // transition
        assert b1.equals(b2) == b2.equals(b3) == b3.equals(b1);
    }
}
