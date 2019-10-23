package tryingInterfaces;

public class Test {
	
	public static void main(String[] args) {
		School s = new School(10);
		Library l = new Library(5);
		Shop o = new Shop(15);
		System.out.println(sameDistance(s, l, o));
		
		School k = new School(100);
		Library y = new Library(20);
		Shop z = new Shop(10);
		System.out.println(sameDistance(k, y, z));
	}
	
	public static boolean sameDistance(Place p1, Place p2, Place p3) {
		return p1.distance(p2) == p1.distance(p3);
	}

}
