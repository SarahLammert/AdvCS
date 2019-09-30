package balloonTest;

public class BalloonTest {
	public static Balloon b;

	public static void main(String[] args) {
		b = new Balloon(3);
		b.nextPage();
		System.out.println(b.getCurrentPage());
		b.nextPage();
		System.out.println(b.getCurrentPage());
		b.nextPage();
		System.out.println(b.getCurrentPage());
		
	}
}
