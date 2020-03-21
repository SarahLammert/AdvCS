package collinearPoints;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
	private final LineSegment[] lS;

	public BruteCollinearPoints(Point[] points) {
		if (points == null) {
			throw new IllegalArgumentException("Constructor is null");
		}
		for (Point p : points) {
			if (p == null) {
				throw new IllegalArgumentException("A point is null");
			}
		}
		ArrayList<Point> duplicatePoints = new ArrayList<Point>();
		for (Point p : points) {
			if (duplicatePoints.contains(p)) {
				throw new IllegalArgumentException("Duplicate points");
			} else {
				duplicatePoints.add(p);
			}
		}

		Point[] newPoints = points.clone();

		Arrays.sort(newPoints);
		ArrayList<LineSegment> lSA = new ArrayList<LineSegment>();

		for (int a = 0; a < newPoints.length - 3; a++) {
			for (int b = a + 1; b < newPoints.length - 2; b++) {
				for (int c = b + 1; c < newPoints.length - 1; c++) {
					for (int d = c + 1; d < newPoints.length; d++) {
						if (collinear(newPoints[a], newPoints[b], newPoints[c], newPoints[d])) {
							lSA.add(new LineSegment(newPoints[a], newPoints[d]));
						}
					}
				}
			}
		}

		lS = new LineSegment[lSA.size()];
		for (int i = 0; i < lSA.size(); i++) {
			lS[i] = lSA.get(i);
		}
	}

	public int numberOfSegments() {
		return lS.length;
	}

	public LineSegment[] segments() {
		return lS.clone();
	}

	private boolean collinear(Point a, Point b, Point c, Point d) {
		return Double.compare(a.slopeTo(b), b.slopeTo(c)) == 0 && Double.compare(b.slopeTo(c), c.slopeTo(d)) == 0;
	}
}
