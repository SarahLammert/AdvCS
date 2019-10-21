package abstractClass;

public class Test {

	static Point p1 = new Point(0.0, 0.0);
	static Point p2 = new Point(6.0, 0.0);
	static Point p3 = new Point(0.0, 6.0);
	static Point p4 = new Point(1.0, 0.0);
	static Point p5 = new Point(-1.0, 0.0);
	static Point p6 = new Point(0.0, Math.sqrt(3.0));
	
	public static void main(String[] args) {
		Triangle t1 = new Triangle(p1, p2, p3);
		System.out.println(t1.area());
		System.out.println(t1.isEquilateral());
		Triangle t2 = new Triangle(p4, p5, p6);
		System.out.println(t2.area());
		System.out.println(t2.isEquilateral());
	}
}
