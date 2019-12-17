package percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private static final double CONFIDENCE_95 = 1.96;
	private int[] allOpenSites;
	private int totalNums;
	private double standardDev;
	private double avgMean;
	private double confidenceLo;
	private double confidenceHi;
	
	public PercolationStats(int n, int trials) {
		if (n <= 0 || trials <= 0) {
			throw new IllegalArgumentException("N or trials must be bigger than 0");
		} else {
			totalNums = n*n;
			allOpenSites = new int[trials];
			for (int t = 0; t < trials; t++) {
				Percolation p = new Percolation(n);
				while (!p.percolates()) {
					p.open(StdRandom.uniform(1, n+1), StdRandom.uniform(1, n+1));
				}
				allOpenSites[t] = p.numberOfOpenSites();
			}
			avgMean = StdStats.mean(allOpenSites)/totalNums;
			standardDev = StdStats.stddev(allOpenSites)/totalNums;
			confidenceLo = avgMean - (CONFIDENCE_95*standardDev/Math.sqrt(totalNums));
			confidenceHi = avgMean + (CONFIDENCE_95*standardDev/Math.sqrt(totalNums));
		}
	}

	public double mean() {
		return avgMean;
	}
	
	public double stddev() {
		return standardDev;
	}
	
	public double confidenceLo() {
		return confidenceLo;
	}
	
	public double confidenceHi() {
		return confidenceHi;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int t = Integer.parseInt(args[1]);
		PercolationStats pS = new PercolationStats(n, t);
		System.out.println(pS.mean());
		System.out.println(pS.stddev());
		System.out.println(pS.confidenceLo());
		System.out.println(pS.confidenceHi());
		
	}

}
