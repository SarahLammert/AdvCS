package collinearPoints;

import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw() {
		StdDraw.point(x, y);
	}

	public void drawTo(Point that) {
		StdDraw.line(this.x, this.y, that.x, that.y);
	}

	public double slopeTo(Point that) {
		double slope = (double) (that.getY() - this.getY()) / (that.getX() - this.getX());
		if (this.getX() == that.getX() && this.getY() == that.getY()) {
			return Double.NEGATIVE_INFINITY;
		} else if (this.getY() == that.getY()) {
			return 0.0;
		} else if (this.getX() == that.getX()) {
			return Double.POSITIVE_INFINITY;
		} else {
			return slope;
		}
	}

	public int compareTo(Point that) {
		if (this.getY() < that.getY() || (this.getY() == that.getY() && this.getX() < that.getX())) {
			return -1;
		} else if (that.getX() == this.getX() && that.getY() == this.getY()) {
			return 0;
		} else {
			return 1;
		}
	}

	public Comparator<Point> slopeOrder() {
		return new SlopeOrder();
	}

	private class SlopeOrder implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			return Double.compare(slopeTo(o1), slopeTo(o2));
		}

	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	private int getX() {
		return x;
	}

	private int getY() {
		return y;
	}
}