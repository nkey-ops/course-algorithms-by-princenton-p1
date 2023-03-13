package unionfind_1_5.assignment;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author deuru
 *
 */
public class Percolation {
	
	//stores parent's row and column
	private final int[][][] grid;
	private final String[][] state;
	private final int[][] size;

	private final int length;
	private int openSites;

	private final String BLOCKED = " █";
	private final String OPENED = " □";
	private final String FULL = " V";

	// creates n-by-n grid, with all sites initially blocked
	/**
	 * 
	 * Time Comlexity O(n^2)
	 * @param n
	 */
	public Percolation(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("N cannot be equal or below zero");

		this.grid = new int[n + 1][n + 1][2];
		this.state = new String[n + 1][n + 1];
		this.size = new int[n + 1][n + 1];
		this.length = n;
		
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				grid[row][col][0] = row;
				grid[row][col][1] = row == 1 || row == n ? 1 : col;
				
				
				size[row][col] = 1;
				
				
				if(row == 0 )
					state[row][col] = String.format("%2s", col);
				else if (col == 0)
					state[row][col] = String.format("%2s", row);
				else 
					state[row][col] = BLOCKED;
			}
		}

		
	}


	// opens the site (row, col) if it is not open already
	public void open(int row, int col) {
		validate(row, col, grid.length);
		
		if (isOpen(row, col))
			return;

		state[row][col] = OPENED;
		openSites++;

		unionFourSites(row, col);
	}

	// is the site (row, col) open?
	public boolean isOpen(int row, int col) {
		validate(row, col, grid.length);

		return state[row][col] == OPENED;
	}

	// is the site (row, col) full?
	public boolean isFull(int row, int col) {
		validate(row, col, grid.length);

		return find(1, 1).equals(find(row, col));
	}

	// returns the number of open sites
	public int numberOfOpenSites() {
		return openSites;
	}

	// does the system percolate?
	public boolean percolates() {
		Cords c1 = find(1, 1);
		Cords c2 = find(length, length);
		
		if (c1.equals(c2)) {
			for (int row = 1; row < grid.length; row++) {
				for (int col = 1; col < grid.length; col++) {
					if(c1.equals(find(row, col)) && isOpen(row, col))
						 state[row][col] = FULL;
				}
			}
			
			return true;
		}
		
		return false;
	}

	// test client (optional)
	public static void main(String[] args) throws InterruptedException {
		int n = args.length == 0 ? 100 : Integer.parseInt(args[0]);

		Percolation p = new Percolation(n);
		
		while (!p.percolates()) {
			int row = StdRandom.uniformInt(1, n + 1);
			int col = StdRandom.uniformInt(1, n + 1);

			if (p.isOpen(row, col))
				continue;
			p.open(row, col);
//			p.showStateSimpleUp();
		}
		p.showStateSimpleUp();
		System.out.print("\n".repeat(n - 1));
		
	}
		
	private static class Cords {
		public final int row;
		public final int col;
		
		public Cords(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cords other = (Cords) obj;
			return col == other.col && row == other.row;
		}
		
		
		
	}

	private static boolean isValid(int row, int col, int length) {
		return row <= length && row > 0 && col <= length && col > 0;
	}

	private static void validate(int row, int col, int length) {
		if (!isValid(row, col, length))
			throw new IllegalArgumentException(
					"Row and Column cannot be bigger than " + length + 
					"+ and lower or equal to 0");
	}

	/**
	 * 
	 * Time Complexity O(2 log( length)) Space Complexity O(4 log( length))
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	private Cords find(int row, int col) {
		validate(row, col, length);
		
		int rR = row, rC = col;
		int trR = rR;
		int trC = rC;
		while (grid[rR][rC][0] != rR || grid[rR][rC][1] != rC) {
			trR = grid[rR][rC][0];
			trC = grid[rR][rC][1];

			rR = trR;
			rC = trC;
		}

		Cords cords = new Cords(rR, rC); 
		
		rR = row; rC = col;
		while (grid[trR][trC][0] != trR || grid[trR][trC][1] != trC) {
			trR = grid[trR][trC][0];
			trC = grid[trR][trC][1];
			
			grid[trR][trC][0] = cords.row;
			grid[trR][trC][1] = cords.col;
			
			rR = trR;
			rC = trC;
		}

		return cords;
	}
	
	private void unionFourSites(int row, int col) {
		//@formatter:off
		int[] xy = new int[] {    -1, 0, 
							0,-1,/*cell*/0, 1, 
							       1, 0};
		//@formatter:on
		
		for (int i = 0; i < xy.length; i += 2) {
			int row2 = row + xy[i];
			int col2 = col + xy[i + 1];
			
			if(isValid(row2, col2, length) 
					&& state[row2][col2] == OPENED)
				union(row, col, row2, col2);
		}
	}


	/**
	 * 
	 * Time Complexity O(log( length)) Space Complexity O(1))
	 * 
	 * @param row
	 * @param col1
	 * @param col2
	 * @return
	 */
	private boolean union(int row1, int col1, int row2, int col2) {
		validate(row1, col1, length);
		validate(row2, col2, length);
		
		if (row1 == row2 && col1 == col2)
			return false;

		Cords c1 = find(row1, col1);
		Cords c2 = find(row2, col2);

		if (c1.equals(c2))
			return false;

		if (size[c1.row][c1.col] > size[c2.row][c2.row]) {

			grid[c2.row][c2.col][0] =  c1.row;
			grid[c2.row][c2.col][1] =  c1.col;
			size[c1.row][c1.col] += size[c2.row][c2.col];
		
		} else {
			grid[c1.row][c1.col][0] =  c2.row;
			grid[c1.row][c1.col][1] =  c2.col;
			size[c2.row][c2.col] += size[c1.row][c1.col];
		}

		return true;
	}
	
	private String getShow(int row) {
		int iMax = length;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int col = 0; ; col++) {
           
        	b.append(state[row][col])
        	 .append(" ^")
        	 .append("[" +grid[row][col][0] + ", " + grid[row][col][1]);
            
            if (col == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
	}

	private String getStateSimple(int row) {
		StringBuilder b = new StringBuilder();

		for (int col = 1; col <= length; col++) {
			b.append(state[row][col]);
		}

		return b.toString();
	}
	
	private void showStateSimpleUp() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= length; i++) {
			sb.append(getStateSimple(i)).append("\n");
		}
		
		System.out.print(sb);
		System.out.print("\033[F".repeat(grid.length - 1));
	}

	private String getGrid() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < grid.length; i++) {
			sb.append(getShow(i)).append("\n");
		}
		
		return sb.toString();
	}
	

	private void showGridUp() {
		System.out.print(getGrid());
		System.out.print("\033[F".repeat(grid.length));
	}

	private void showGrid() {
		System.out.println(getGrid());
	}
}
