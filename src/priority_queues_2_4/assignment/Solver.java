package priority_queues_2_4.assignment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdRandom;

public class Solver {
    private final Iterable<Board> solution;
    private final boolean isSolvable;
    private final int minMoves;

    private static class SearchNode implements Comparable<SearchNode> {
        final SearchNode prev;
        final int moves; 
        final Board board;
        final int manhattan;
        final int sum; 
        
        public SearchNode(int moves, Board board, SearchNode prev) {
            this.moves = moves;
            this.board = board;
            this.prev = prev;
            this.manhattan = board.manhattan();
            this.sum = this.manhattan + moves;
        }

        @Override
        public int compareTo(SearchNode that) {
           int cmp = Integer.compare(this.sum, that.sum);
           return cmp == 0 ? Integer.compare(this.manhattan, that.manhattan)
                           : cmp;
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial){
        if(initial == null)
            throw new IllegalArgumentException();

        if(initial.isGoal()){
            this.isSolvable = true;
            this.minMoves = 0;
            this.solution = List.of(initial);
            return;
        }

        //TODO doesnt hand actual solution
        SearchNode solution =  getSolution(initial);
        if(solution == null) {
            this.isSolvable = false;
            this.solution = null; 
            this.minMoves = -1;
            return;
        }

        LinkedList<Board> boards = new LinkedList<>();
        this.isSolvable = true;
        this.minMoves = solution.moves;
        this.solution = boards;

        while(solution != null) {
            boards.addFirst(solution.board);    
            solution = solution.prev;
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable(){return isSolvable;}

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves(){return minMoves;}

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution(){ return solution;}

    // test client (see below) 
    @Override
    public String toString() {
        return "Solver [isSolvable=" + isSolvable + ", minMoves=" + minMoves + "]";
    }


    private SearchNode getSolution(Board initial){
        MinPQ<SearchNode> pQueue1 = new MinPQ<>(); 
        MinPQ<SearchNode> pQueue2 = new MinPQ<>(); 

        pQueue1.insert(new SearchNode(0, initial, null));
        pQueue2.insert(new SearchNode(0, initial.twin(), null));
        
        while(!pQueue1.min().board.isGoal() 
                && !pQueue2.min().board.isGoal()){
            
            iterate(pQueue1);
            if (pQueue1.min().board.isGoal()) break;
            iterate(pQueue2);
        }

        return pQueue1.min().board.isGoal() ? pQueue1.min()
                                            : null; }

    private void iterate(MinPQ<SearchNode> queue) {
          SearchNode curr = queue.delMin();            
                
          for (Board board : curr.board.neighbors()) {
             if(curr.prev != null && board.equals(curr.prev.board)) continue;

             queue.insert(new SearchNode(curr.moves + 1, board, curr));
             if(board.isGoal()) return;
          }  
    }

    public static void main(String[] args){
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 3;
         
        Board initial = new Board(getRandomTiles(n));
        System.out.println("Random Board:");
        System.out.println(initial);
        
        Solver s = new Solver(initial);
        showResult(s);
    }


    private static int[][] getRandomTiles(int n) {
        int[][] tiles = new int[n][n]; 

        int[] data = StdRandom.permutation(n * n);

        for (int y = 0, i = 0; y < n; y++) {
            for (int x = 0; x < n; x++, i++) {
                tiles[y][x] = data[i];
            }
        }
        
        return tiles;
    }

    private static void showResult(Solver sol) {
        if(sol.isSolvable()) {
            for( Board b : sol.solution()) {
                System.out.println(b);
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Is solvable? " + sol.isSolvable());
        System.out.println("Minimum moves: " + sol.moves());
            
    }
}
