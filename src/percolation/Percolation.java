package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private boolean[][] grid;
	private WeightedQuickUnionUF uF;
	private int openSites;
	private int sideLength;
	private boolean percolates;
	
	public Percolation(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("row and col must be bigger than 0");
		} else {
			sideLength = n;
			openSites = 0;
			percolates = false;
			grid = new boolean[n][n];
			uF = new WeightedQuickUnionUF(n*n+2);
			for (int row = 1; row <= n; row++) {
				for (int col = 1; col <= n; col++) {
					grid[row-1][col-1] = false;
				}
			}
		}
	}
	
	public void open(int row, int col) {
		if (row <= 0 || row > sideLength || col <= 0 || col > sideLength) {
			throw new IllegalArgumentException("row and col must be bigger than 0");
		} else if (!isOpen(row, col)) {
			openSites += 1;
			grid[row-1][col-1] = true;
			int x = findNumForUF(row, col);
			if (row < sideLength && isOpen(row+1, col)) {
				uF.union(x+sideLength, x);
			}
			if (row > 1 && isOpen(row-1, col)) {
				uF.union(x-sideLength, x);
			}
			if (col < sideLength && isOpen(row, col+1)) {
				uF.union(x+1, x);
			}	
			if (col > 1 && isOpen(row, col-1)) {
				uF.union(x-1, x);
			}
			if (x <= sideLength) {
				uF.union(x, 0);
			}
			if (x > sideLength*(sideLength-1)) {
				uF.union(x, findNumForUF(sideLength, sideLength)+1);
			}
		}
	}
	
	public boolean isOpen(int row, int col) {
		if (row <= 0 || row > sideLength || col <= 0 || col > sideLength) {
			throw new IllegalArgumentException("row and col must be bigger than 0");
		} else {
			return grid[row-1][col-1];
		}
	}
	
	public boolean isFull(int row, int col) {
		if (row <= 0 || row > sideLength || col <= 0 || col > sideLength) {
			throw new IllegalArgumentException("row and col must be bigger than 0");
		} else {
			int x = findNumForUF(row, col);
			if (uF.find(x) == uF.find(0) && isOpen(row, col)) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public int numberOfOpenSites() {
		return openSites;
	}
	
	public boolean percolates() {
		if (uF.find(findNumForUF(sideLength, sideLength+1)) == uF.find(0)) {
			percolates = true;
		}
		return percolates;
	}
	
	private int findNumForUF(int row, int col) {
		return (row - 1) * sideLength + col;
	}
}
