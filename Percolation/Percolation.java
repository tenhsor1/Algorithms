

public class Percolation {
	private WeightedQuickUnionUF quUF;
	private boolean[][] grid;
	private int N, topN;
	public Percolation(int N){
		this.N = N;
		this.topN = (N*N) + 1;
		grid = new boolean[N][N];
		quUF = new WeightedQuickUnionUF((N * N) + 2);
	}
	
	public void open(int i, int j){
		int row = i - 1;
		int col = j - 1;
		
		if(row < 0 || row > N || col < 0 || col > N){
			 throw new IndexOutOfBoundsException("Out of grid");
		}
		
		 //change to true the grid element = open
		grid[row][col] = true;	
		
		if((row -1) >= 0){ // union the site upward if is available
			if(grid[row - 1][col]){
				quUF.union(indexHelper(row, col), indexHelper(row - 1, col));
			}
		}
		
		if(i < N){ //union the site below if is available
			if(grid[i][col]){
				quUF.union(indexHelper(row, col), indexHelper(i, col));
			}
		}
		
		if((col - 1) >= 0){ // union the site left if is available
			if(grid[row][j]){
				quUF.union(indexHelper(row, col), indexHelper(row, col - 1));
			}
		}
		
		if(j < N){ //open the site right if is available
			if(grid[row][j]){
				quUF.union(indexHelper(row, col), indexHelper(row, j));
			}
		}
		
		if(row == 0){ //If the site is in the first row, we union it with the virtual top site
			quUF.union(0, indexHelper(row, col));
		}
		if(row == (N-1)){ //If the site is in the last row, we union it with the virtual bottom site
			quUF.union(topN, indexHelper(row, col));
		}
	}
	
	public boolean isOpen(int i, int j){
		if(i < 0 || i > N || j < 0 || j > N){
			 throw new IndexOutOfBoundsException("Out of grid");
		}
		return grid[i-1][j-1];
	}
	
	public boolean isFull(int i, int j){
		if(i < 0 || i > N || j < 0 || j > N){
			 throw new IndexOutOfBoundsException("Out of grid");
		}
		 return quUF.connected(0, indexHelper( i-1, j-1 ));
	}
	public boolean percolates(){
		return quUF.connected(0, topN);
	}
	
	private int indexHelper(int i, int j){
		if(i < 0 || i > N || j < 0 || j > N){
			 throw new IndexOutOfBoundsException("Out of grid");
		}
		 return ((i * N) + j) + 1;
	}
	
	public int count(){
		return quUF.count();
	}
	
	 public static void main(String[] args){
	        int N = StdIn.readInt();
	        Percolation perc = new Percolation(N);
	        while(!perc.percolates()){
	            int i = StdIn.readInt();
	            int j = StdIn.readInt();
	            if (perc.isOpen(i, j)) continue;
	            perc.open(i, j);
	            StdOut.println(i + " " + j);
	        }
	        StdOut.println("p* = " + perc.count()/((N*N) + 2));
	    }
}
