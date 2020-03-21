package collinearPoints;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints2 {
	private final LineSegment[] lineSegments;
	private final int sizeOfArray;

	public FastCollinearPoints2(Point[] points) {
		
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
		
		if (points.length >= 4) {
			
			ArrayList<LineSegment> arrayOfLineSegments = new ArrayList<LineSegment>();
			
			ArrayList<Point> subSegments = new ArrayList<Point>();
			
			Point[] slopeOrderPoints = points.clone();
			
			Arrays.sort(slopeOrderPoints);
			
			Point[] naturalOrderPoints = slopeOrderPoints;

			for (int a = 0; a < naturalOrderPoints.length; a++) {
				
				Point origin = naturalOrderPoints[a];
				
				Arrays.sort(slopeOrderPoints, origin.slopeOrder());	
				
				int iterator = 0;
				
				int lengthOfArray = slopeOrderPoints.length;
				
				Point p = slopeOrderPoints[iterator];
				
				while (iterator < lengthOfArray) {
					
					double slope = origin.slopeTo(slopeOrderPoints[iterator]);
					
					int count = 1;
					
					while(Double.compare(origin.slopeTo(p), slope) == 0) {
						
						subSegments.add(p);
						
						count++;
						
						iterator++;
						
						if(iterator == lengthOfArray) {
							
							break;
							
						} else {
							
							p = slopeOrderPoints[iterator];
						}
						
					}
					if (count > 3 && origin.compareTo(subSegments.get(0)) < 0) {
						
						arrayOfLineSegments.add(new LineSegment(origin, subSegments.get(subSegments.size()-1)));
						
					}
					
					subSegments.clear();
				}
				
				Arrays.sort(slopeOrderPoints);
			}
			
			lineSegments = arrayOfLineSegments.toArray(new LineSegment[arrayOfLineSegments.size()]);
			
		} else {
			
			lineSegments = new LineSegment[0];
			
		}
		
		sizeOfArray = lineSegments.length;
	}
	
	public int numberOfSegments() {
		
		return sizeOfArray;
	}

		public LineSegment[] segments() {
			
			return lineSegments.clone();

		}

		public static void main(String[] args) throws FileNotFoundException {
			Scanner s = new Scanner(new File("horizontal50.txt"));
			int nums = s.nextInt();
			Point[] points = new Point[nums];
			for(int x = 0; x < nums; x++) {
				points[x] = new Point(s.nextInt(), s.nextInt());
			}
			FastCollinearPoints2 fCP = new FastCollinearPoints2(points);
			for(LineSegment lS: fCP.segments()) {
				System.out.println(lS);
			}
			System.out.println(fCP.numberOfSegments());
		}
}