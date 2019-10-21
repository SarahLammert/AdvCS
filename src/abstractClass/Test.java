package abstractClass;

public class Test {

	public static void main(String[] args) {
		Triangle t1 = new Triangle();
		t1.addOneCoordinate(0.0, 0.0);
		t1.addOneCoordinate(6.0, 0.0);
		t1.addOneCoordinate(0.0, 6.0);
		System.out.println(t1.area());
		System.out.println(t1.isEquilateral());
		Triangle t2 = new Triangle();
		t2.addOneCoordinate(1.0, 0.0);
		t2.addOneCoordinate(-1.0, 0.0);
		t2.addOneCoordinate(0.0, Math.sqrt(3));
		System.out.println(t2.area());
		System.out.println(t2.isEquilateral());
	}
}
