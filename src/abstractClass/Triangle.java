package abstractClass;

public class Triangle extends Polygon {
	
	public static final int TRIANGLE_SIDES = 3;
	public Triangle() {
		super(TRIANGLE_SIDES);
	}
	
	@Override
	public double area() {
		Point x = coordinates.get(0);
		Point y = coordinates.get(1);
		Point z = coordinates.get(2);
		double area = Math.abs(((x.x * (y.y-z.y)) + (y.x * (z.y-x.y)) + (z.x * (x.y-y.y)))/2);
		area = Math.round(area * 100.0) / 100.0;
		return area;
	}
	
	@Override
	public boolean isEquilateral() {
		Point x = coordinates.get(0);
		Point y = coordinates.get(1);
		Point z = coordinates.get(2);
		if(disOfPoints(x, y) == disOfPoints(y, z) && disOfPoints(x, y) == disOfPoints(x, z)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	private double disOfPoints(Point a, Point b) {
		double distance = Math.sqrt(Math.pow((b.y - a.y), 2) + Math.pow((b.x - a.x), 2));
		distance = Math.round(distance * 100.0) / 100.0;
		return distance;
	}
}