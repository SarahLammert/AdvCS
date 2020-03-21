package collinearPoints;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
	private final LineSegment[] lS;
	private final int size;

	public FastCollinearPoints(Point[] points) {
		if (points == null) {
			throw new IllegalArgumentException("Constructor is null");
		}
		ArrayList<Point> duplicates = new ArrayList<Point>();
		for (Point p : points) {
			if (p == null) {
				throw new IllegalArgumentException("A point is null");
			} else if (duplicates.contains(p)) {
				throw new IllegalArgumentException("A duplicate");
			} else {
				duplicates.add(p);
			}
		}
		duplicates.clear();
		if(points.length >= 4) {
			ArrayList<LineSegment> lSA = new ArrayList<LineSegment>();
			Point[] newPoints;
			Point[] pL;

			for (int a = 0; a < points.length; a++) {
				
				newPoints = points.clone();
				Point origin = newPoints[a];
				
				Arrays.sort(newPoints, origin.slopeOrder());
				
				double slope = origin.slopeTo(newPoints[1]);
				int c = 1;
				
				for (int x = 1; x < newPoints.length; x++) {
					double o = origin.slopeTo(newPoints[x]);
					if (Double.compare(o, slope) == 0) {
						duplicates.add(newPoints[x]);
						c++;
					} else {
						if (c > 3) {
							pL = new Point[c];
							pL[0] = origin;
							for (int y = 1; y < c; y++) {
								pL[y] = duplicates.get(y - 1);
							}
							Arrays.sort(pL, 0, c);
							if(pL[0].equals(origin)) {
								lSA.add(new LineSegment(pL[0], pL[c - 1]));
							}
						}
						c = 2;
						duplicates.clear();
						duplicates.add(newPoints[x]);
						slope = o;
					}
				}
				if (c > 3) {
					pL = new Point[c];
					pL[0] = origin;
					for (int y = 1; y < c; y++) {
						pL[y] = duplicates.get(y - 1);
					}
					Arrays.sort(pL, 0, c);
					if(pL[0].equals(origin)) {
					lSA.add(new LineSegment(pL[0], pL[c - 1]));
					}
				}
				duplicates.clear();
			}

			lS = new LineSegment[lSA.size()];
			for (int i = 0; i < lSA.size(); i++) {
				lS[i] = lSA.get(i);
			}
		} else {
			lS = new LineSegment[0];
		}
		size = lS.length;
	}
	
	public int numberOfSegments() {
		return size;
	}

		public LineSegment[] segments() {
			return lS.clone();

		}

		public static void main(String[] args) throws FileNotFoundException {
			Scanner s = new Scanner(new File("equidistant.txt"));
			int nums = s.nextInt();
			Point[] points = new Point[nums];
			for(int x = 0; x < nums; x++) {
				points[x] = new Point(s.nextInt(), s.nextInt());
			}
			FastCollinearPoints fCP = new FastCollinearPoints(points);
			for(LineSegment lS: fCP.segments()) {
				System.out.println(lS);
			}
			System.out.println(fCP.numberOfSegments());
			System.out.println();
		}
}